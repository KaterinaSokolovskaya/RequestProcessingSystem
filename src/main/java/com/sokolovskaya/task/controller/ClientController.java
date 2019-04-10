package com.sokolovskaya.task.controller;

import com.sokolovskaya.task.service.dto.AddRequest;
import com.sokolovskaya.task.service.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/client")
    public String getClientPage(Model model, @RequestParam("id") String id, @ModelAttribute("addRequest") AddRequest addRequest) {
        model.addAttribute("userId", id);
        model.addAttribute("requests", clientService.getAllByUserId(Integer.valueOf(id)));
        return "client";
    }

    @PostMapping("/client")
    public String addRequest(@Valid AddRequest addRequest, Errors errors) {
        if (!errors.hasErrors()) {
            clientService.addRequest(addRequest);
        }
        return "redirect:/client?id=" + addRequest.getUserId();
    }
}
