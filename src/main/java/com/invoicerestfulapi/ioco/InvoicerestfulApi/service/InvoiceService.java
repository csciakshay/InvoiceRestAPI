package com.invoicerestfulapi.ioco.InvoicerestfulApi.service;

import java.util.List;
import java.util.Optional;

import com.invoicerestfulapi.ioco.InvoicerestfulApi.model.Invoice;

public interface InvoiceService {

	 Invoice addInvoice(Invoice invoice);

	 List<Invoice> viewAllInvoices();

	 Optional<Invoice> viewInvoice(Long id);
}
