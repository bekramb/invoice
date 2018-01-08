package ru.mts.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс счета-фактуры
 */
@Entity
@Table(name = "invoice")
@NamedQueries({
        @NamedQuery(name = Invoice.BY_NAME, query = "SELECT inv FROM Invoice inv  WHERE inv.seller.name=:name ORDER BY inv.id"),
        @NamedQuery(name = Invoice.FIND_ALL, query = "SELECT inv FROM Invoice inv ORDER BY inv.id"),
})
public class Invoice {

    public static final String BY_NAME = "Invoice.getByName";
    public static final String FIND_ALL = "Invoice.findAll";

    /**
     * id счета-фактуры
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Дата составления
     */
    @Column(name = "invoice_date")
    private Date invoiceDate;
    /**
     * Данные поставщика
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Seller seller;
    /**
     * Данные покупателя
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    /**
     * Позиции в счете-фактуре
     */
    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    private Set<Item> items = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceDate=" + invoiceDate +
                ", seller=" + seller +
                ", customer=" + customer +
                ", items=" + items +
                '}';
    }
}
