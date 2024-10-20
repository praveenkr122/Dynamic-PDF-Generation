package com.example.pdfgenerator;

import com.example.pdfgenerator.model.BillRequest;
import com.example.pdfgenerator.service.PdfService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PdfServiceTest {

    @Autowired
    private PdfService pdfService;

    @Test
    public void testGeneratePdf() throws Exception {
        BillRequest billRequest = new BillRequest();
        // Populate billRequest data here
        billRequest.setSeller("XYZ Pvt. Ltd.");
        billRequest.setSellerGstin("29AABBCCDD121ZD");
        billRequest.setSellerAddress("New Delhi, India");
        billRequest.setBuyer("Vedant Computers");
        billRequest.setBuyerGstin("29AABBCCDD131ZD");
        billRequest.setBuyerAddress("New Delhi, India");

        File pdfFile = pdfService.generatePdf(billRequest);
        assertTrue(pdfFile.exists());
    }
}
