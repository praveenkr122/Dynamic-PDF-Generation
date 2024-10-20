package com.example.pdfgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pdfgenerator.model.BillRequest;
import com.example.pdfgenerator.service.PdfService;

import java.io.File;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @PostMapping("/generate")
    public ResponseEntity<Resource> generatePdf(@RequestBody BillRequest billRequest) throws Exception {
        File pdfFile = pdfService.generatePdf(billRequest);

        Path path = pdfFile.toPath();
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pdfFile.getName() + "\"")
                .body(resource);
    }
}
