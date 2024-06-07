# Arquitetura Hexagonal com Springboot

**Estrutura do projeto**
```
src/main/
├── java
│   └── com
│       └── pluxee
│           └── hexagonal
│               ├── HexagonalApplication.java
│               ├── adapter
│               │   ├── infrastructure
│               │   │   ├── configuration
│               │   │   │   └── BeanConfiguration.java // Esta classe define os beans necessários para 
│               │   │   └── persistence
│               │   │       ├── ProductRepositoryImpl.java //  Esta classe implementa a interface ProductRepositoryOut e fornece a lógica de persistência.
│               │   │       ├── entity
│               │   │       │   └── ProductEntity.java // Esta classe representa a entidade Product no banco de dados. Entidade que conecta com o banco de dados.
│               │   │       ├── jpa
│               │   │       │   └── ProductRepositoryJpa.java // Esta interface estende JpaRepository para fornecer métodos de acesso ao banco de dados.
│               │   │       └── mapper
│               │   │           └── ProductMapper.java // Esta classe fornece métodos estáticos para converter entre as entidades de domínio e as entidades de persistência.
│               │   └── rest
│               │       ├── ProductController.java // Este controlador fornece endpoints para operações CRUD na entidade 
│               │       ├── mapper
│               │       │   └── ProductRestMapper.java //  Esta classe fornece métodos estáticos para converter entre as representações REST e as entidades de domínio.
│               │       ├── request
│               │       │   └── ProductRequest.java // Esta classe representa o payload para a criação de um novo Product através da API REST.
│               │       └── response
│               │           └── ProductResponse.java // Esta classe representa a resposta retornada pela API REST após a criação ou leitura de um Product.
│               └── core
│                   ├── application
│                   │   └── ProductServiceImpl.java // Esta classe implementa a lógica de negócio relacionada a Product. Implementação da porta ProductServiceIn.
│                   └── domain
│                       ├── model
│                       │   └── Product.java // Esta classe representa a entidade de domínio Product.
│                       └── ports
│                           ├── inbound
│                           │   └── ProductServiceIn.java // Esta interface define os métodos de serviço disponíveis para a entidade Product.
│                           └── outbound
│                               └── ProductRepositoryOut.java // Esta interface define os métodos de persistência disponíveis para a entidade Product.
└── resources
    ├── application.yml // Este arquivo contém as configurações da aplicação, como dados de conexão com o banco de dados e configurações do Flyway.
    └── db
        └── migrations
            └── V1__initial_schema.sql // Este arquivo contém o script SQL para criar a tabela products no banco de dados.
```

## Run
Baixe o projeto
```
git clone https://github.com/everton-roliveira/springboot-hexagonal.git
```

Acesse o projeto
```
cd folder/springboot-hexagonal
```

Intalar dependências
```
mvn clean install
```

Subir o banco de dados
```
docker compose up -d
```

Agora basta subir a aplicação na ide de sua preferência

Para acessar a api import o arquivo `src/main/resources/static/SpringbootHexagonal.postman_collection.json` em seu postam

