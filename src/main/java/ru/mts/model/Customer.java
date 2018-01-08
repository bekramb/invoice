package ru.mts.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = Customer.FIND_ALL, query = "SELECT c FROM Customer c ORDER BY c.id"),
})
public class Customer extends BaseEntity {
    public static final String FIND_ALL = "Customer.findAll";

    /**
     * Имя клиента
     */
    @Column(name = "first_name")
    private String firstName;
    /**
     * Фамилия клиента
     */
    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "} " + super.toString();
    }
}
