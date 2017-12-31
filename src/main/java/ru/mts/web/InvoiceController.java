package ru.mts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mts.model.Item;
import ru.mts.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping(value ="rest/invoice", produces = MediaType.APPLICATION_JSON_VALUE)
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public List<Item> getAll() {
        return invoiceService.getAll();
    }
}
