package ru.mts.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mts.model.Customer;
import ru.mts.model.Invoice;
import ru.mts.model.Product;
import ru.mts.model.Seller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class InvoiceRepositoryImpl implements InvoiceRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> getAllProduct() {
        return em.createNamedQuery(Product.FIND_ALL, Product.class).getResultList();
    }

    @Override
    public List<Seller> getAllSeller() {
        return em.createNamedQuery(Seller.FIND_ALL, Seller.class).getResultList();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return em.createNamedQuery(Customer.FIND_ALL, Customer.class).getResultList();
    }

    @Override
    public List<Invoice> getAllInvoice() {
        return em.createNamedQuery(Invoice.FIND_ALL, Invoice.class).getResultList();
    }

    @Override
    public List<Invoice> getInvoiceByName(String name) {
        return em.createNamedQuery(Invoice.BY_NAME, Invoice.class)
                .setParameter("name", name)
                .getResultList();
    }
}
