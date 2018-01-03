package ru.mts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mts.model.*;
import ru.mts.service.InvoiceService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "rest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class InvoiceRestController {
    private static final String ALL_PRODUCT = "/product";
    private static final String ALL_SELLER = "/seller";
    private static final String ALL_CUSTOMER = "/customer";
    private static final String ALL_INVOICE = "/invoice";
    private static final String ALL_INVOICE_BY_NAME = "/invoice/filter";
    private final Logger LOG = LoggerFactory.getLogger(InvoiceRestController.class);

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(value = ALL_PRODUCT)
    public List<Product> getAllProduct() {
        LOG.info("getProducts");
        return invoiceService.getAllProduct();
    }

    @GetMapping(value = ALL_SELLER)
    public List<Seller> getAllSeller() {
        LOG.info("getSellers");
        return invoiceService.getAllSeller();
    }

    @GetMapping(value = ALL_CUSTOMER)
    public List<Customer> getAllCustomer() {
        LOG.info("getCustomers");
        return invoiceService.getAllCustomer();
    }

    @GetMapping(value = ALL_INVOICE)
    public List<Invoice> getAllInvoice() {
        LOG.info("getInvoices");
        return invoiceService.getAllInvoice();
    }

    @GetMapping(value = ALL_INVOICE_BY_NAME)
    public List<Invoice> getInvoicebyName(@RequestParam(value = "name") String name) {
        LOG.info("getInvoices with name = {}", name);
        return invoiceService.getInvoiceByName(name);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity handleError(HttpServletRequest req, Throwable t) {
        LOG.error("Request " + req.getRequestURI() + " error: " + t.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON_UTF8).body("{\"Error\": \"See logs\"}");
    }
}
