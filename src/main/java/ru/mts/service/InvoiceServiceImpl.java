package ru.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.model.*;
import ru.mts.repository.InvoiceRepository;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Product> getAllProduct() {
        return invoiceRepository.getAllProduct();
    }

    @Override
    public List<Seller> getAllSeller() {
        return invoiceRepository.getAllSeller();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return invoiceRepository.getAllCustomer();
    }

    @Override
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.getAllInvoice();
    }

    @Override
    public List<Invoice> getInvoiceByName(String name) {
        return invoiceRepository.getInvoiceByName(name);
    }
}
