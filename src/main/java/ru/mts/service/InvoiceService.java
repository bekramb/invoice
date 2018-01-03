package ru.mts.service;

import ru.mts.model.*;

import java.util.List;

public interface InvoiceService {
    List<Product> getAllProduct();

    List<Seller> getAllSeller();

    List<Customer> getAllCustomer();

    List<Invoice> getAllInvoice();

    List<Invoice> getInvoiceByName(String name);
}
