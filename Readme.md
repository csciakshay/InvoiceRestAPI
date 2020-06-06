Java Springboot framework InvoicesRestfulApi Application

To runs perform below Steps ...... :-

1. download or clone git repo in your machine and then open terminal

2. prompt> cd InvoicesRestApi

3. prompt> mvn spring-boot:run

THAN RUN WITH POSTMAN CLIENTS TO RUN THE ENDPOINTS.

Steps to runs the endpoints are : --- 


1  - POST  http://localhost:8080/invoices 

{
  "client": "IOCO VENTURES",
  "vatRate": "12",
 "invoiceItems" : [{
        "quantity": "5",
        "description": "Printer",
        "unitPrice": "2.00"
    }]
}

2 - GET  http://localhost:8080/invoices

3 - GET  http://localhost:8080/invoices/1




