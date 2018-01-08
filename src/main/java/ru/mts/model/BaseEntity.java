package ru.mts.model;

import javax.persistence.*;

/**
 * Базовый класс для классов клиента и поставщика
 */
@MappedSuperclass
public abstract class BaseEntity {
    /**
     * id сущности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Название улицы
     */
    private String street;
    /**
     * Индекс
     */
    @Column(name = "postal_code")
    private String postalCode;
    /**
     * Название города
     */
    private String city;
    /**
     * Название страны
     */
    private String Country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
