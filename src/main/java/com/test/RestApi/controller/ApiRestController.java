package com.test.RestApi.controller;

import com.test.RestApi.entity.Api;
import com.test.RestApi.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/apis") // Base URL for the API
public class ApiRestController {

    @Autowired
    private ApiService apiService;

    // GET all APIs
    @GetMapping
    public ResponseEntity<List<Api>> getAllApis() {
        List<Api> apis = apiService.getAllApis();
        return ResponseEntity.ok(apis);
    }

    // GET a single API by ID
    @GetMapping("/{id}")
    public ResponseEntity<Api> getApiById(@PathVariable Long id) {
        Optional<Api> api = apiService.getApiById(id);
        if (api.isPresent()) {
            return ResponseEntity.ok(api.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // CREATE a new API
    @PostMapping
    public ResponseEntity<Api> createApi(@RequestBody Api api) {
        Api savedApi = apiService.saveApi(api);
        return ResponseEntity.ok(savedApi);
    }

    // UPDATE an existing API
    @PutMapping("/{id}")
    public ResponseEntity<Api> updateApi(@PathVariable Long id, @RequestBody Api apiDetails) {
        Optional<Api> existingApi = apiService.getApiById(id);
        if (existingApi.isPresent()) {
            Api apiToUpdate = existingApi.get();
            apiToUpdate.setName(apiDetails.getName());
            apiToUpdate.setDescription(apiDetails.getDescription());
            apiToUpdate.setImage(apiDetails.getImage());
            apiToUpdate.setUrl(apiDetails.getUrl());

            Api updatedApi = apiService.saveApi(apiToUpdate);
            return ResponseEntity.ok(updatedApi);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE an API by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApi(@PathVariable Long id) {
        if (apiService.getApiById(id).isPresent()) {
            apiService.deleteApi(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
