package com.invoicerestfulapi.ioco.InvoicerestfulApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.invoicerestfulapi.ioco.InvoicerestfulApi.model.Invoice;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InvoicerestfulApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InvoiceControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllEmployees() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/invoices",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetInvoiceById() {
		Invoice invoice = restTemplate.getForObject(getRootUrl() + "/invoices/1", Invoice.class);
		System.out.println(invoice.getClient());
		assertNotNull(invoice);
	}

	@Test
	public void testCreateInvoice() {
		Invoice invoice = new Invoice();
		invoice.setClient("TestClient");
		invoice.setVatRate((long) 15.0);
		//invoice.setInvoiceItem("");

		ResponseEntity<Invoice> postResponse = restTemplate.postForEntity(getRootUrl() + "/invoices", invoice, Invoice.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	
}
