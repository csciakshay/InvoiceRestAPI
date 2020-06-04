package com.invoicerestfulapi.ioco.InvoicerestfulApi.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.invoicerestfulapi.ioco.InvoicerestfulApi.exception.ResourceNotFoundException;
import com.invoicerestfulapi.ioco.InvoicerestfulApi.model.Invoice;
import com.invoicerestfulapi.ioco.InvoicerestfulApi.service.InvoiceService;


@RestController
@RequestMapping("invoices")
public class InvoiceController {

	@Autowired
    InvoiceService invoiceService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Invoice addInvoice(@Valid @RequestBody @NotNull Invoice invoice) {
       return invoiceService.addInvoice(invoice);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Invoice> viewAllInvoices() {
        return invoiceService.viewAllInvoices();
    }

    @GetMapping(value = "/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Invoice> viewInvoice(@PathVariable("invoiceId") Long id) throws ResourceNotFoundException{
    	Invoice invoice = invoiceService.viewInvoice(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Invoice not found for this id :: " + id));
        return ResponseEntity.ok().body(invoice);
    }
    
}