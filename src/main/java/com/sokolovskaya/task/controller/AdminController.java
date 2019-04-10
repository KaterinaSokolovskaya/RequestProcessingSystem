package com.sokolovskaya.task.controller;

import com.sokolovskaya.task.database.enumeration.RequestStatus;
import com.sokolovskaya.task.service.dto.UpdateStatus;
import com.sokolovskaya.task.service.service.AdminService;
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
public class AdminController {

    private final AdminService adminService;

    @ModelAttribute("allStatuses")
    public RequestStatus[] getAllStatuses() {
        return RequestStatus.values();
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model, @RequestParam("id") String id, @ModelAttribute("updateStatus") UpdateStatus updateStatus) {
        model.addAttribute("userId", id);
        model.addAttribute("requests", adminService.getAll());
        model.addAttribute("report", adminService.getReport());
        return "admin";
    }

    @PostMapping("/admin")
    public String updateStatus(@Valid UpdateStatus updateStatus, Errors errors) {
        if (!errors.hasErrors()) {
            adminService.updateStatus(updateStatus);
        }
        return "redirect:/admin?id=" + updateStatus.getUserId();
    }
}
