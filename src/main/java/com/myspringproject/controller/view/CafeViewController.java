package com.myspringproject.controller.view;

import com.myspringproject.dto.cafe.CafeResponseDto;
import com.myspringproject.service.cafe.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/cafes")
@RequiredArgsConstructor
public class CafeViewController {

    private final CafeService cafeService;

    @GetMapping()
    public String findAll(Model model) {

        Collection<CafeResponseDto> dtoList = cafeService.findAll();

        model.addAttribute("cafes", dtoList);

        return "cafes";
    }


}
