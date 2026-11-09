# Cofre

API REST de carteira digital em Java, construída de forma incremental como projeto de estudo em backend, com foco em consistência de saldo e operações concorrentes.

## Funcionalidades

- Criar uma conta
- Depositar dinheiro
- Sacar dinheiro
- Transferir para outra conta
- Ver o extrato (o histórico de movimentações)

## Regras de negócio
- Saques e transferências maiores que o saldo disponível são recusadas.
- Saques e transferências negativas ou iguais a zero são recusadas.
- Transferências para a mesma conta são recusadas.

## Stack planejada
Java 26, PostgreSQL, Spring Boot, Maven, JUnit 5, Docker.

## Status
Em construção. Fase atual: definição de escopo e regras de negócio (v0.0). Proxímo passo: modelagem do domínio em Java puro.

