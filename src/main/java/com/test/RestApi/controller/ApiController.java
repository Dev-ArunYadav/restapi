package com.test.RestApi.controller;

import com.test.RestApi.entity.Api;
import com.test.RestApi.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/apis")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping
    public String listApis(Model model) {
        model.addAttribute("apis", apiService.getAllApis());
        return "list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("api", new Api());
        return "form";
    }

    @PostMapping
    public String createApi(@ModelAttribute Api api) {
        apiService.saveApi(api);
        return "redirect:/apis";
    }

    @GetMapping("/{id}")
    public String viewApi(@PathVariable Long id, Model model) {
        Optional<Api> api = apiService.getApiById(id);
        if (api.isPresent()) {
            model.addAttribute("api", api.get());
            return "view";
        } else {
            return "redirect:/apis";
        }
    }

    @GetMapping("/{id}/edits")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Api> api = apiService.getApiById(id);
        if (api.isPresent()) {
            model.addAttribute("api", api.get());
            return "edits";
        } else {
            return "redirect:/apis";
        }
    }

    @PostMapping("/{id}")
    public String updateApi(@PathVariable Long id, @ModelAttribute Api api) {
        api.setId(id);
        apiService.saveApi(api);
        return "redirect:/apis";
    }

    @GetMapping("/{id}/delete")
    public String deleteApi(@PathVariable Long id) {
        apiService.deleteApi(id);
        return "redirect:/apis";
    }
}
