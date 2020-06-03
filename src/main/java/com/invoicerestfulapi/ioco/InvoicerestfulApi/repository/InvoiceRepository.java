package com.invoicerestfulapi.ioco.InvoicerestfulApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicerestfulapi.ioco.InvoicerestfulApi.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	
}
