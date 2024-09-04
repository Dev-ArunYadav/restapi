package com.test.RestApi.service;

import com.test.RestApi.entity.Api;
import com.test.RestApi.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        List<Api> apiList = new ArrayList<>();
        for(Api api : apiRepository.findAll()){
            apiList.add(new Api(api.getId(),api.getName(), api.getDescription(), api.getImage(), api.getUrl()));
        }
        return apiList;
        /*return apiRepository.findAll().stream()
                .map(api -> new Api(api.getId(),api.getName(), api.getDescription(), api.getImage(), api.getUrl()))
                .collect(Collectors.toList());*/
    }

    // get user by id
    public String getApiById(Long id){
        apiRepository.findById(id);
        return "Api retrieved successfully";
    }

    // update user by id
    public String updateApiById(Long id, Api api){
        //apiRepository.findById(id).ifPresent(apiRepository::save);
        if(apiRepository.findById(id).isPresent()){
            apiRepository.save(api);
            return "Api updated successfully";
        }
        return "No Api found with the given id";
    }

    // delete user by id
    public String deleteApiById(Long id){
        apiRepository.deleteById(id);
        return "Api deleted successfully";
    }
}
