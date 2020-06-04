package com.invoicerestfulapi.ioco.InvoicerestfulApi.service.dtoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.invoicerestfulapi.ioco.InvoicerestfulApi.service.InvoiceService;
import com.invoicerestfulapi.ioco.InvoicerestfulApi.model.Invoice;
import com.invoicerestfulapi.ioco.InvoicerestfulApi.model.InvoiceRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DtoInvoiceService implements InvoiceService {

    @Autowired
    InvoiceRepo repository;

    @Override
    public Invoice addInvoice(Invoice invoice) {
       return repository.save(invoice);
    }

    @Override
    public List<Invoice> viewAllInvoices() {
        return repository.findAll();
    }

    @Override
    public Optional<Invoice> viewInvoice(Long id) {
        return repository.findById(id);
    }
}
