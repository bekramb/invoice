### Test InvoiceRestController.
> For windows use `Git Bash`

#### get All Products
`curl -s http://localhost:8080/rest/product`

#### get All Invoices
`curl -s http://localhost:8080/rest/invoice`

#### get All Sellers
`curl -s http://localhost:8080/rest/seller`

#### get All Customers
`curl -s http://localhost:8080/rest/customer`

#### filter Invoices
`curl -s "http://localhost:8080/rest/invoice/filter?name=ИП ИВАНОВ"`

