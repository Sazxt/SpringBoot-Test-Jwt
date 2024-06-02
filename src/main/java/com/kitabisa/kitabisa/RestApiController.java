package com.kitabisa.kitabisa;

import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kitabisa.kitabisa.dto.TestDataDTO;
import com.kitabisa.kitabisa.dto.UsersDataDTO;
import com.kitabisa.kitabisa.handler.ApiHandlerResponse;
import com.kitabisa.kitabisa.mapper.TestMapperDTO;
import com.kitabisa.kitabisa.mapper.UsersMapperDTO;
import com.kitabisa.kitabisa.model.Testdata;
import com.kitabisa.kitabisa.model.Users;
import com.kitabisa.kitabisa.repository.TestdataRepository;
import com.kitabisa.kitabisa.repository.UsersdataRepository;
import com.kitabisa.kitabisa.service.UserServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class RestApiController {
    private final TestdataRepository testdataRepository;
    private final UsersdataRepository usersdataRepository;
    
    @Autowired
    private UserServices userservice;

    @Autowired
    public RestApiController(TestdataRepository testdataRepository, UsersdataRepository usersdataRepository) {
        this.testdataRepository = testdataRepository;
        this.usersdataRepository = usersdataRepository;
    }
    @GetMapping("/test")
    public String test() {
        return "Hello, World!";
    }

    @GetMapping("/find-data/{id}")
    public TestDataDTO getTestdataById(@PathVariable Long id) {
        Testdata testdata = testdataRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
        return TestMapperDTO.toDTO(testdata);
    }

    @GetMapping("/all-data")
    public List<TestDataDTO> getAllTestdata() {
        List<Testdata> testdataList = testdataRepository.findAll();
        return testdataList.stream().map(TestMapperDTO::toDTO).collect(Collectors.toList());
    }

    @PostMapping("/data-create")
    public TestDataDTO  datacreate(@RequestBody TestDataDTO testdataDTO) {
        Testdata testdata = TestMapperDTO.toEntity(testdataDTO);
        Testdata savedTestdata = testdataRepository.save(testdata);
        return TestMapperDTO.toDTO(savedTestdata);
    }

    @DeleteMapping("/data-delete/{id}")
    public ResponseEntity<Object> deletedata(@PathVariable Long id)
    {
        Map<String, Object> data = new HashMap<String, Object>();
        Optional<Testdata> testdata = testdataRepository.findById(id);
        if (testdata.isPresent()) {
            testdataRepository.deleteById(id);
            data.put("message", "Berhasil Di Delete");
            return new ResponseEntity<>(data,HttpStatus.OK);
        } else {
            data.put("message", "Data Tidak Di Temukan!");
            return new ResponseEntity<>(data,HttpStatus.OK);
        }
    }

    @PutMapping("update-data/{id}")
    public ApiHandlerResponse<TestDataDTO> update(@PathVariable long id, @RequestBody TestDataDTO testdataDTO) {
        Optional<Testdata> existingTestdata = testdataRepository.findById(id);
        if (existingTestdata.isPresent()) {
            Testdata testdataToUpdate = existingTestdata.get();
            testdataToUpdate.setUsername(testdataDTO.getUsername());
            testdataToUpdate.setAlamat(testdataDTO.getAlamat());
            testdataToUpdate.setEmail(testdataDTO.getEmail());
            Testdata updatedTestdata = testdataRepository.save(testdataToUpdate);
            return new ApiHandlerResponse<>("success", "Data updated successfully", TestMapperDTO.toDTO(updatedTestdata));
        } else {
            return new ApiHandlerResponse<>("error", "Testdata not found with id " + id, null);
        }
    }

    @PostMapping("add-users")
    public UsersDataDTO addusers(@RequestBody Users users) {
        Users usrs = userservice.userscreate(users);
        return UsersMapperDTO.toDto(usrs);
    }
    
    
}
