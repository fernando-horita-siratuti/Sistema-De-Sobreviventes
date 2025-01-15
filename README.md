# Sistema-De-Sobreviventes

## Sobre o Projeto

Este projeto simula a gestão de um "vault" (abrigo) em um contexto pós-apocalíptico. Os jogadores podem gerenciar sobreviventes, recursos e missões para garantir a sobrevivência do grupo. As principais funcionalidades incluem o cadastro de sobreviventes, gerenciamento de habilidades, controle de recursos e organização de missões.

## Funcionalidades

### Cadastrar Sobrevivente
- Adiciona um novo sobrevivente ao vault, incluindo nome, ID, idade e status ("Ativo", "Ferido", "Doente" e "Morto").

### Gerenciar Habilidades
- Adicionar ou remover habilidades de um sobrevivente.

### Gerenciar Recursos
- Adicionar recursos ao vault ou consumi-los.

### Gerenciar Missões
- Registrar novas missões com nome, objetivo, local e status.
- Adicionar sobreviventes às missões (limite de 5 por missão).

### Exibir Dados
- Listar sobreviventes, recursos, missões realizadas e sobreviventes de uma missão específica.

## Estrutura do Código

O projeto é composto pelas seguintes classes principais:

- **MainTrab**: Responsável pela execução do programa e apresentação do menu de opções.
- **SobreviventeTrab**: Gerencia os dados e habilidades dos sobreviventes.
- **RecursoTrab**: Representa os recursos armazenados no vault.
- **MissaoTrab**: Gerencia as missões criadas e os sobreviventes designados.
- **VaultTrab**: Atua como repositório central para sobreviventes, recursos e missões.

## Regras e Restrições

- Cada sobrevivente deve ter um ID único.
- Sobreviventes "doentes" ou "mortos" não podem ser adicionados às missões.
- O limite de sobreviventes por missão é 5.
- Recursos adicionados devem ter uma quantidade maior ou igual a 1.