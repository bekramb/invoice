package ru.mts.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "seller")
@NamedQueries({
        @NamedQuery(name = Seller.FIND_ALL, query = "SELECT s FROM Seller s ORDER BY s.id"),
})
public class Seller extends Person {
    public static final String FIND_ALL = "Seller.findAll";

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
