package com.dametumanolegal.domain.adapter.input;

import com.dametumanolegal.dtos.response.HomeDataInfoResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public HomeDataInfoResponse responseDataToHomePage(){
        return HomeDataInfoResponse.builder()
                .headerData(null)
                .bodyData(null)
                .footerData(null)
                .build();
    }
}
