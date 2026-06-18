# ⚔️ Sistema RPG — POO em Java

Projeto desenvolvido para a disciplina de Programação Orientada a Objetos.  
Tema: **Personagens de RPG**

---

## Como compilar e executar

```bash
# Na raiz do projeto, compile todos os arquivos:
javac -d out -sourcepath src src/Main.java src/interfaces/*.java src/model/*.java src/util/*.java

# Execute:
java -cp out Main
```

---

## Estrutura do Projeto

```
src/
├── Main.java                      # Ponto de entrada, menu interativo
├── interfaces/
│   ├── Combatente.java            # Interface — atacar, habilidade especial, status
│   └── Curavel.java               # Interface — curar
├── model/
│   ├── Item.java                  # Classe Item (associação com Personagem)
│   ├── Personagem.java            # Classe abstrata base
│   ├── Mago.java                  # Herda Personagem
│   ├── Cavaleiro.java             # Herda Personagem
│   ├── Curandeiro.java            # Herda Personagem + implementa Curavel
│   ├── MagoSombrio.java           # Herda Mago (subclasse)
│   └── CavaleiroSagrado.java      # Herda Cavaleiro + implementa Curavel
└── util/
    └── GerenciadorPersonagens.java # Lista e gerencia os personagens
```

---

## Conceitos de POO utilizados

| Conceito                        | Onde está aplicado                                              |
|---------------------------------|-----------------------------------------------------------------|
| **Encapsulamento**              | Atributos privados com getters/setters em todas as classes      |
| **Classes**                     | Item, Personagem, Mago, Cavaleiro, Curandeiro, etc.             |
| **Classe Abstrata**             | `Personagem` — não pode ser instanciada diretamente             |
| **Métodos Abstratos**           | `usarHabilidadeEspecial()` e `getTipo()` em `Personagem`        |
| **Herança**                     | Mago/Cavaleiro/Curandeiro estendem Personagem; MagoSombrio e CavaleiroSagrado estendem as subclasses |
| **Interfaces**                  | `Combatente` (implementada por Personagem) e `Curavel` (Curandeiro e CavaleiroSagrado) |
| **Associação**                  | `Personagem` possui `Item` (item comum e item especial)          |
| **Entrada/Saída interativa**    | Menu no console via `Scanner` com validação de entrada           |

---

## Funcionalidades

- **Criar personagem** — escolhe tipo, define nome, vida e ataque
- **Visualizar personagens** — lista todos com status completo
- **Gerenciar itens** — atribui item comum ou item especial a qualquer personagem
- **Simular ações** — atacar, usar habilidade especial, curar (quando disponível)

---

## Diagrama de Classes

Consulte o arquivo `diagrama.mermaid` — pode ser visualizado em [mermaid.live](https://mermaid.live).
