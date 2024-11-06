package com.test.RestApi.controller;

import com.test.RestApi.entity.Api;
import com.test.RestApi.exception.ResourceNotFoundException;
import com.test.RestApi.service.CrudSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    private CrudSerivce itemService;

    @RequestMapping(value = {"", "/", "/items"})
    public String listItems(Model model) {
        model.addAttribute("items", itemService.getAllAPi());
        return "index";
    }

    @GetMapping("/new")
    public String newItemForm(Model model) {
        model.addAttribute("item", new Api());
        return "new";
    }

    @PostMapping
    public String createItem(@ModelAttribute Api item) {
        itemService.addApi(item);
        return "redirect:/items";
    }

    @GetMapping("/{id}/edit")
    public String editItem(@PathVariable Long id, Model model) {
        Optional<Api> item = itemService.getApiById(id);
        if(item.isPresent()){
            model.addAttribute("item", item.get());
            return "edit";
        }else{
            return "redirect:/items";
        }
    }

    @PostMapping("{id}")
    public String updateItem(@PathVariable Long id, @ModelAttribute Api item) {
        try {
            item.setId(id);
            itemService.updateApiById(item); // Update the item
            return "redirect:/items";
        } catch (ResourceNotFoundException e) {
            // Handle the exception (e.g., return an error view or redirect)
            return "redirect:/items?error" ;
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteApiById(id);
        return "redirect:/items";
    }

}
