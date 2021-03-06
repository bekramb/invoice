package ru.mts.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = Product.FIND_ALL, query = "SELECT p FROM Product p ORDER BY p.id"),
})
public class Product {
    public static final String FIND_ALL = "Product.findAll";

    /**
     * id продукта
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Наименование продукта
     */
    @Column(name = "name")
    private String name;
    /**
     * Цена продукта
     */
    @Column(name = "price")
    private BigDecimal price;
    /**
     * Налог
     */
    @Column(name = "vat")
    private Float vat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Float getVat() {
        return vat;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", vat=" + vat +
                '}';
    }
}
