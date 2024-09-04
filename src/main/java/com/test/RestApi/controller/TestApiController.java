package com.test.RestApi.controller;

import com.test.RestApi.entity.Api;
import com.test.RestApi.service.CrudSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestApiController {

    @Autowired
    private CrudSerivce crudSerivce;


    @PostMapping("/addUser")
    public String addApi(@RequestBody Api api){
        return crudSerivce.addApi(api);
    }

    @GetMapping("/getAllUser")
    public List<Api> getAllAPi(){
        return crudSerivce.getAllAPi();
    }

    @GetMapping("/getUser/{id}")
    public String getApiById(@RequestBody Long id){
        return crudSerivce.getApiById(id);
    }

    @PutMapping("/updateUser/{id}")
    public String updateApiById(@RequestBody Long id, @RequestBody Api api){
        return crudSerivce.updateApiById(id, api);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteApiById(@RequestBody Long id){
        return crudSerivce.deleteApiById(id);
    }

}
