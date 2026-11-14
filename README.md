# Cofre

API REST (interface que permite a integração entre sistemas) de carteira digital em Java, construída de forma incremental como projeto de estudo em backend, com foco em consistência de saldo (o saldo de um utilizador precisa estar sempre correto, mesmo com milhares de operações ao mesmo tempo, falhas de rede ou quedas de servidores) e operações concorrentes (transfêrencias ou outra operação acontecendo ao mesmo tempo na conta, podendo gerar resultados indesejados, como saldos negativos não autorizados).

## Funcionalidades

- Criar uma conta
- Depositar dinheiro
- Sacar dinheiro
- Transferir para outra conta
- Ver o extrato (o histórico de movimentações)

## Regras de negócio
- Saques e transferências maiores que o saldo disponível são recusadas.
- Saques, depósitos e transferências negativas ou iguais a zero são recusadas.
- Transferências para a mesma conta são recusadas.
- Transferências para uma conta que não existe são recusadas.
- Transferências para contas bloqueadas são recusadas.

## Desafios técnicos
- Precisão com centavos
- Duas operações simultâneas na mesma conta
- Queda no meio de uma transferência
- Cada usuário mexendo apenas no próprio dinheiro

## Stack planejada
Java 21, PostgreSQL, Spring Boot, Maven, JUnit 5, Docker.

## Status
Em construção. Fase atual: definição de escopo e regras de negócio (v0.0). Proxímo passo: modelagem do domínio em Java puro.

