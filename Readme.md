Java Springboot framework InvoicesRestfulApi Application


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




