package com.invoicerestfulapi.ioco.InvoicerestfulApi.model;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepo {

    Invoice save(Invoice invoice);

    List<Invoice> findAll();

    Optional<Invoice> findById(Long id);
}