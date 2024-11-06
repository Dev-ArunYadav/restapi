package com.test.RestApi.service;

import com.test.RestApi.entity.Api;
import com.test.RestApi.exception.ResourceNotFoundException;
import com.test.RestApi.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CrudSerivce {

    @Autowired
    private ApiRepository apiRepository;

    // add user through Api
    public String addApi(Api api){
        apiRepository.save(api);
        return "Api added successfully";
    }

    // get all users
    public List<Api> getAllAPi(){
        return apiRepository.findAll().stream()
                .map(api -> new Api(api.getId(),api.getName(), api.getDescription(), api.getImage(), api.getUrl()))
                .collect(Collectors.toList());
    }

    // get user by id
    public Optional<Api> getApiById(Long id) {
        return apiRepository.findById(id);
    }

    // update user by id
    public String updateApiById(Api item) {
        // Assuming findById is used to check if item exists
        if (!apiRepository.existsById(item.getId())) {
            throw new ResourceNotFoundException("Item with ID " + item.getId() + " not found for update");
        }
        apiRepository.save(item);
        return "Api updated successfully";
    }

    // delete user by id
    public boolean deleteApiById(Long id){
        if(apiRepository.findById(id).isPresent()){
            apiRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
