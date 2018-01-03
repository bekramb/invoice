package ru.mts.repository;

import ru.mts.model.*;

import java.util.List;

public interface InvoiceRepository {
    List<Product> getAllProduct();

    List<Seller> getAllSeller();

    List<Customer> getAllCustomer();

    List<Invoice> getAllInvoice();

    List<Invoice> getInvoiceByName(String name);
}
