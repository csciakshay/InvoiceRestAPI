package com.invoicerestfulapi.ioco.InvoicerestfulApi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Entity
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive
    private Long quantity;
    @NotBlank
    private String description;
    @Positive
    private BigDecimal unitPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    
	public BigDecimal getInvoiceItemTotal() {
		BigDecimal invoiceItemTotal = new BigDecimal(0);
		if (unitPrice != null && quantity != null) {
			invoiceItemTotal = invoiceItemTotal.add(unitPrice).multiply(new BigDecimal(quantity));
		}
		return invoiceItemTotal.setScale(2, RoundingMode.HALF_UP);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem invoiceItem = (InvoiceItem) o;
        return Objects.equals(id, invoiceItem.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
