package com.test.RestApi.service;

import com.test.RestApi.entity.Api;
import com.test.RestApi.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {

    @Autowired
    private ApiRepository apiRepository;

    public List<Api> getAllApis() {
        return apiRepository.findAll();
    }

    public Optional<Api> getApiById(Long id) {
        return apiRepository.findById(id);
    }

    public Api saveApi(Api api) {
        return apiRepository.save(api);
    }

    public void deleteApi(Long id) {
        apiRepository.deleteById(id);
    }
}
