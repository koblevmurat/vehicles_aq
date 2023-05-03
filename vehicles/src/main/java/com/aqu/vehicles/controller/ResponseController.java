package com.aqu.vehicles.controller;

import com.aqu.vehicles.dto.DocStatusDto;
import com.aqu.vehicles.dto.ResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.aqu.vehicles.service.ResponseService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@Getter
public class ResponseController {
    private ResponseService responseService;

    @Autowired
    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping("/Vehicles")
    public String GetResponse1cVeh(Model model) throws URISyntaxException, IOException, InterruptedException {
        List<ResponseDto> response = this.responseService.getResponse();
        model.addAttribute("response" , response);
        return "Vehicles";
    }
    @GetMapping("/SpisokMachin")
    public String GetResponse1c(Model model) throws URISyntaxException, IOException, InterruptedException {
        List<ResponseDto> response = this.responseService.getResponse();
        model.addAttribute("response" , response);
        return "Vehicles";
    }

    @PostMapping("/submit")
    public String Submit(@RequestBody DocStatusDto docStatusDto) throws URISyntaxException, IOException, InterruptedException {
        int code = responseService.UpdateDocStatus(docStatusDto);
        return "redirect:/SpisokMachin";
    }

}
