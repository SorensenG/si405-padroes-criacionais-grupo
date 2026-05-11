# Sistema de Relatórios Corporativos — Refatoração Criacional

> Atividade Prática — Padrões Criacionais de Projeto  
> Disciplina: Padrões de Projeto de Software | Instituto de Computação — Unicamp

---

## Sobre o sistema

Este repositório contém o código-fonte de um sistema interno de geração e exportação de relatórios corporativos desenvolvido para uma empresa fictícia. O sistema permite gerar relatórios de vendas, estoque e clientes nos formatos PDF, CSV, JSON, XML e HTML, com suporte a configurações globais de ambiente.

O sistema foi refatorado sobre o projeto legado original, preservando o comportamento esperado e aplicando os padrões criacionais Factory Method e Singleton.

---

## Refatoração realizada

- Factory Method: criação dos geradores centralizada em fábricas específicas por formato, reduzindo o acoplamento dos serviços com implementações concretas.
- Singleton: configurações globais centralizadas em `ConfiguracaoSistema.getInstance()`, compartilhadas pelos serviços da aplicação.
- Novos formatos: XML e HTML.
- Testes: cobertura mantida para o comportamento legado e adicionada para novos formatos, fábricas e configuração singleton.

## Integrantes

- Daniel Aniceto Rosell - 283988
- Davie Schimidt Fonseca - 259908
- Hugo Strassa - 246710
- Gabriel Sorensen M Traina - 283997
- Kaue Samuel Oliveira da Silva - 178449
- Kauã Henrique da Silva Andrade - 246165

---

## Pré-requisitos

- Java 17 ou superior
- Apache Maven 3.8 ou superior

---

## Como executar

Compilar e empacotar:

```bash
mvn clean package -q
```

Executar o sistema interativo:

```bash
java -jar target/sistema-relatorios.jar
```

Alternativamente, sem gerar o JAR:

```bash
mvn exec:java -Dexec.mainClass="br.unicamp.padroescriacionais.legacy.Main"
```

---

## Como rodar os testes

```bash
mvn test
```

Para exibir o resultado detalhado de cada caso de teste:

```bash
mvn test -Dsurefire.useFile=false
```

---
