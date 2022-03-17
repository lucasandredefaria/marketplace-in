# Spring Boot API Rest for integration of marketplace products
This Rest API receives new products and price, stock, and product updates from partners to post to RabbitMQ queues.

## Installation
	mvn clean install
	mvn spring-boot:run

## Use
Exposed Endpoints:

###Insert and Update Product:
    
    curl -0 -v -X POST http://localhost:8080/api/marketplace/v1/products \
    -H "Expect:" \
    -H 'Content-Type: application/json; charset=utf-8' \
    --data-binary @- << EOF
    {
        "id": "15653",
        "idLojista": "12346",
        "nome": "nome do produto",
        "descricao": "descrição do produto",
        "idCategoriaSaraiva": "120165054",
        "idMarcaSaraiva": "15651651",
        "skus": {
            "skuLojista": "value nome",
            "ean": "value Descricao",
            "isbn": "1235465465",
            "precoDe": 49.90,
            "precoPor": 29.90,
            "estoque": 50,
            "tipo": "novo",
            "peso": 1.200,
            "status": "ativo",
            "caracteristicas": [{
                "id": "1",
                "valor": "valor caracteristica"
            },{
                "id": "2",
                "valor": "valor caracteristica"
            },{
                "id": "3",
                "valor": "valor caracteristica"
            }],
            "imagens": [{
                "urlInterna": "https://lojasaraiva.vteximg.com.br/arquivos/ids/12707349/1008977758.jpg",
                "capa": false
            },{
                "urlInterna": "https://lojasaraiva.vteximg.com.br/arquivos/ids/12707349/1008977758.jpg",
                "capa": true
            },{
                "urlInterna": "https://lojasaraiva.vteximg.com.br/arquivos/ids/12707349/1008977758.jpg",
                "capa": false
            }]
        }
    }
    EOF
    
###Update Stock:

    curl -0 -v -X PUT http://localhost:8080/api/marketplace/v1/products/stock \
    -H "Expect:" \
    -H 'Content-Type: application/json; charset=utf-8' \
    --data-binary @- << EOF
    {
        "idLojista": "12346",
        "skuLojista" : "value nome",
        "ean" : "value Descricao",
        "isbn" : "1235465465",
        "estoque" : 50
    }
    EOF

###Update Price:
    
    curl -0 -v -X PUT http://localhost:8080/api/marketplace/v1/products/price \
    -H "Expect:" \
    -H 'Content-Type: application/json; charset=utf-8' \
    --data-binary @- << EOF
    {
        "idLojista": "12346",
        "skuLojista" : "value nome",
        "ean" : "value Descricao",
        "isbn" : "1235465465",
        "precoDe" : 49.90,
        "precoPor" : 29.90
    }
    EOF


## Application Health Check
This method returns application health check

	curl -v -H "Content-Type: application/json" http://localhost:8080/actuator/health

