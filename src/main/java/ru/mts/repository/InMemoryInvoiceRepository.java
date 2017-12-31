package ru.mts.repository;

import org.springframework.stereotype.Repository;
import ru.mts.model.Invoice;
import ru.mts.model.Item;
import ru.mts.model.Person;
import ru.mts.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class InMemoryInvoiceRepository implements InvoiceRepository {
    private List<Item> listOfProducts = new ArrayList<>();

    public InMemoryInvoiceRepository() {

        Person customer = new Person();
        customer.setFirstName("aaaaaa");

        Person sellerr = new Person();
        sellerr.setFirstName("bbbbb");

        Product p1 = new Product();
        p1.setName("p1");

        Product p2 = new Product();
        p2.setName("p2");

        Invoice invoice = new Invoice();
        invoice.setId(1L);
        invoice.setCustomer(customer);
        invoice.setSeller(sellerr);
        invoice.setInvoiceDate(new Date());

        Item item1= new Item();
        item1.setNumber(1);
        item1.setInvoice(invoice);
        item1.setQuantity(1);

        Item item2= new Item();
        item2.setNumber(2);
        item2.setInvoice(invoice);
        item2.setQuantity(2);


        listOfProducts.add(item1);
        listOfProducts.add(item2);
    }

    @Override
    public List<Item> getAll() {
        return listOfProducts;
    }
}
