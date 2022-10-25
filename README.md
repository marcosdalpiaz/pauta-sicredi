### Requisitos
Para rodar a aplicação é necessário:
* [Lombok](https://projectlombok.org/download)

* [MySQL](https://www.mysql.com/)

* [Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)

* [Maven](https://maven.apache.org/download.cgi)

### Requests

1) Request para cadastrar pauta:
POST: http://localhost:8080/api/v1/pauta/cadastroPauta

Payload:
```
{
    "pauta_id": "1",
    "pautaNome": "Pauta",
    "status": "ABERTA",
    "pautaTime": "24/10/2022 23:30:20"
}
```

2) Request para abrir votação:
POST: http://localhost:8080/api/v1/pauta/votacao

Payload:
```
{
    "pautaId": "1",
    "minutagem": 30
}
```

3) Request para realizar voto:
POST: http://localhost:8080/api/v1/voto/realizarVoto

Payload:
```
{
    "usuarioId": 1,
    "pautaNome": "Pauta",
    "cpf": "80398700036",
    "voto": "SIM"
}
```

4) Request para gerar resultado:
GET: http://localhost:8080/api/v1/resultado/1

Este request ainda preciso trabalhá-lo, tive dificuldade na implementação, peço desculpas.