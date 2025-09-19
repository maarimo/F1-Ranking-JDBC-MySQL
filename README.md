# F1-Ranking-JDBC-MySQL

Sistema simples de **ranking de pilotos de Fórmula 1**, feito em **Java** usando **JDBC** para conectar a um banco de dados **MySQL**.  

O projeto permite **inserir, atualizar, deletar e listar pilotos**, mantendo o ranking em **ordem decrescente de pontuação**.

---

## Funcionalidades

- Inserir novos pilotos com nome e pontuação  
- Atualizar informações de pilotos existentes (nome e pontuação)  
- Deletar pilotos do ranking  
- Listar ranking completo, do maior para o menor pontuador  

---

## Tecnologias

- Java 11+  
- JDBC  
- MySQL  
- IDE recomendada: IntelliJ IDEA, Eclipse ou VS Code  

---

## Estrutura do projeto

src/
├─ dao/
│ ├─ PilotoDAO.java # Interface CRUD
│ └─ impl/
│ └─ PilotoDAOImpl.java # Implementação JDBC
├─ model/
│ └─ Piloto.java # Classe modelo do piloto
├─ util/
│ └─ Conexao.java # Conexão com MySQL
└─ Main.java # Classe principal para testes

---

Todas as operações usam PreparedStatement para evitar SQL Injection



