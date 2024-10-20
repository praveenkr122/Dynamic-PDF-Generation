package com.example.pdfgenerator.service;

import com.example.pdfgenerator.model.BillRequest;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class PdfService {

    public File generatePdf(BillRequest billRequest) throws IOException {
        String pdfFilename = "invoice_" + billRequest.getBuyer() + ".pdf";
        File pdfFile = new File(pdfFilename);

        // Check if PDF already exists
        if (pdfFile.exists()) {
            return pdfFile;
        }

        // Create PDF document
        PdfWriter writer = new PdfWriter(new FileOutputStream(pdfFile));
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        // Add Seller and Buyer Details
        Table table = new Table(2);
        table.setWidth(UnitValue.createPercentValue(100)); // Set width to 100%
        //table.addCell("Seller Details");
        //table.addCell("Buyer Details");
        table.addCell("Seller Details :" + "\n" + billRequest.getSeller() + "\n" + billRequest.getSellerAddress() + "\n" + billRequest.getSellerGstin());
        table.addCell("Buyer Details :" + "\n" + billRequest.getBuyer() + "\n" + billRequest.getBuyerAddress() + "\n" + billRequest.getBuyerGstin());

        document.add(table);

        // Create item table
        Table itemTable = new Table(4);
        itemTable.setWidth(UnitValue.createPercentValue(100)); // Set width to 100%
        
        // Header row for items
        itemTable.addCell("Item");
        itemTable.addCell("Quantity");
        itemTable.addCell("Rate");
        itemTable.addCell("Amount");

        // Add items
        for (BillRequest.Item item : billRequest.getItems()) {
            itemTable.addCell(item.getName());
            itemTable.addCell(item.getQuantity());
            itemTable.addCell(String.valueOf(item.getRate()));
            itemTable.addCell(String.valueOf(item.getAmount()));
        }

        document.add(itemTable);
        document.close();

        return pdfFile;
    }
}

