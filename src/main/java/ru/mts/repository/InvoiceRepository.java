package ru.mts.repository;

import ru.mts.model.Item;

import java.util.List;

public interface InvoiceRepository {
    List<Item> getAll();
}
