package com.myspringproject.controller.rest.xlxs;

import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.service.user.UserService;
import com.myspringproject.service.xlsx.ExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/excel")
@RequiredArgsConstructor
public class ExcelController {


    private final ExcelService excelService;
    private final UserService userService;

    @GetMapping("/download")
    public ResponseEntity<Resource> getFile() {

        List<UserResponseDto> allActiveUsers = userService.findAllActiveUsers();

        String filename = "users.xlsx";
        InputStreamResource file = new InputStreamResource(excelService.generateExcel(allActiveUsers));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }
}
