# API - Online Shop Quarkus
### EN-US:
An RESTful API made in Java with Quarkus for an Online Shop. 

This is an API made in Java for an online shop: customers, products and orders. <br>
All functions use DTO on data input and output.
<br><br>
This API uses MySQL as its database.
## API Functions:
### Customers:
- List customers - `/customer`
- Register customer - `/customer`
- Update customer - `/customer/{id}`
- Delete customer - `/customer/{id}`

### Products:
- List products - `/product`
- Insert product - `/product`
- Search for all products that contains the name you want (search field) - `/product/{name}`
- Update product - `/product/{id}`
- Delete product - `/product/{id}`

### Orders:

- List all orders - `/order`
- List paid orders - `/order/paid`
- List not paid orders - `/order/notpaid`
- Get order by id - `/order/{id}`
- Insert order - `/order`
- Pay order - `/order/payment/{id}`

## Technologies used:

- Java
- Quarkus
- Flyway
- MySQL
- Lombok
- Hibernate
- Maven
- Insomnia

## Documentation
Clone or download the application, upgrade the application.properties with your database link (it must be
a MongoDB database) then
run it, after that consult the documentation with all the methods in the link bellow:
<br>http://localhost:8080/swagger-ui.html

## Author

#### Allas Assis de Oliveira
https://www.linkedin.com/in/allasassis

--------------------------------------------------------
# API - Loja Online Quarkus
### PT-BR:

Uma API RESTful feita em Java com Quarkus para uma loja online.

Essa é uma API feita em Java para uma loja online: clientes, produtos e pedidos.
Todas as funções usam DTO na entrada e saída de dados.
<br><br>
Essa API utiliza o MySQL como seu banco de dados.
## Funções da API:
### Clientes:
- Listar clientes - `/customer`
- Registrar cliente - `/customer`
- Atualizar cliente - `/customer/{id}`
- Deletar cliente - `/customer/{id}`

### Produtos:
- Listar produtos - `/product`
- Inserir produto - `/product`
- Buscar todos os produtos que tenham o nome que você quiser (campo de busca) - `/product/{name}`
- Atualizar produto - `/product/{id}`
- Deletar produto - `/product/{id}`

### Pedidos:

- Listar todos os pedidos - `/order`
- Listar os pedidos pagos - `/order/paid`
- List os pedidos NÃO pagos - `/order/notpaid`
- Obter pedido pelo id - `/order/{id}`
- Inserir pedido - `/order`
- Pagar pedido - `/order/payment/{id}`

## Tecnologias usadas:

- Java
- Quarkus
- Flyway
- MySQL
- Lombok
- Hibernate
- Maven
- Insomnia

## Documentação
Clone ou baixe a aplicação, atualize o application.properties com o link do seu banco de dados (tem que ser
um banco de dados MongoDB), após
isso execute o programa e consulte a documentação com todos os métodos no link abaixo:
<br>http://localhost:8080/swagger-ui.html

## Autor

#### Allas Assis de Oliveira
https://www.linkedin.com/in/allasassis