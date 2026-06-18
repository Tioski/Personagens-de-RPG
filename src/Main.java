import interfaces.Curavel;
import model.*;
import util.GerenciadorPersonagens;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static GerenciadorPersonagens gerenciador = new GerenciadorPersonagens();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInt("Opção: ");
            switch (opcao) {
            case 1:
                criarPersonagem();
                break;
            case 2:
                visualizarPersonagens();
                break;
            case 3:
                gerenciarItens();
                break;
            case 4:
                simularAcoes();
                break;
            case 0:
                System.out.println("\nAté mais, aventureiro!");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        } while (opcao != 0);
    }

    // ──────────────────────────────────────────
    // MENU PRINCIPAL
    // ──────────────────────────────────────────
    static void exibirMenu() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║      ⚔  SISTEMA RPG ⚔        ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║  1. Criar personagem          ║");
        System.out.println("║  2. Visualizar personagens    ║");
        System.out.println("║  3. Gerenciar itens           ║");
        System.out.println("║  4. Simular ações             ║");
        System.out.println("║  0. Sair                      ║");
        System.out.println("╚══════════════════════════════╝");
    }

    // ──────────────────────────────────────────
    // CRIAR PERSONAGEM
    // ──────────────────────────────────────────
    static void criarPersonagem() {
        System.out.println("\n── Tipos disponíveis ──");
        System.out.println("1. Mago");
        System.out.println("2. Cavaleiro");
        System.out.println("3. Curandeiro");
        System.out.println("4. Mago Sombrio  (subclasse de Mago)");
        System.out.println("5. Cavaleiro Sagrado (subclasse de Cavaleiro)");

        int tipo = lerInt("Escolha o tipo: ");

        System.out.print("Nome do personagem: ");
        String nome = sc.nextLine().trim();

        int vida   = lerInt("Vida: ");
        int ataque = lerInt("Ataque: ");

        Personagem p;
        switch (tipo) {
            case 1:
                p = new Mago(nome, vida, ataque);
                break;
            case 2:
                p = new Cavaleiro(nome, vida, ataque);
                break;
            case 3:
                p = new Curandeiro(nome, vida, ataque);
                break;
            case 4:
                p = new MagoSombrio(nome, vida, ataque);
                break;
            case 5:
                p = new CavaleiroSagrado(nome, vida, ataque);
                break;
            default:
                System.out.println("Tipo inválido. Criando Mago como padrão.");
                p = new Mago(nome, vida, ataque);
                break;
        }

        gerenciador.adicionar(p);
        System.out.println("\n✔ Personagem \"" + nome + "\" criado com sucesso!");
    }

    // ──────────────────────────────────────────
    // VISUALIZAR PERSONAGENS
    // ──────────────────────────────────────────
    static void visualizarPersonagens() {
        List<Personagem> lista = gerenciador.listar();
        if (lista.isEmpty()) {
            System.out.println("\nNenhum personagem cadastrado.");
            return;
        }
        System.out.println("\n═══ Personagens Cadastrados ═══");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            System.out.println(lista.get(i).getStatus());
        }
    }

    // ──────────────────────────────────────────
    // GERENCIAR ITENS
    // ──────────────────────────────────────────
    static void gerenciarItens() {
        if (gerenciador.total() == 0) {
            System.out.println("\nCrie um personagem primeiro.");
            return;
        }
        listarNomes();
        int idx = lerInt("Selecione o personagem (número): ") - 1;
        Personagem p = gerenciador.buscarPorIndice(idx);
        if (p == null) { System.out.println("Personagem não encontrado."); return; }

        System.out.println("\n1. Adicionar item comum");
        System.out.println("2. Adicionar item especial");
        int op = lerInt("Opção: ");

        System.out.print("Nome do item: ");
        String nomeItem = sc.nextLine().trim();
        System.out.print("Descrição do item: ");
        String desc = sc.nextLine().trim();

        model.Item item = new model.Item(nomeItem, desc);

        if (op == 1) {
            p.setItem(item);
            System.out.println("✔ Item comum atribuído a " + p.getNome());
        } else if (op == 2) {
            p.setItemEspecial(item);
            System.out.println("✔ Item especial atribuído a " + p.getNome());
        } else {
            System.out.println("Opção inválida.");
        }
    }

    // ──────────────────────────────────────────
    // SIMULAR AÇÕES
    // ──────────────────────────────────────────
    static void simularAcoes() {
        if (gerenciador.total() == 0) {
            System.out.println("\nCrie um personagem primeiro.");
            return;
        }
        listarNomes();
        int idx = lerInt("Selecione o personagem (número): ") - 1;
        Personagem p = gerenciador.buscarPorIndice(idx);
        if (p == null) { System.out.println("Personagem não encontrado."); return; }

        System.out.println("\n1. Atacar");
        System.out.println("2. Usar habilidade especial");
        if (p instanceof Curavel) System.out.println("3. Curar (disponível para este personagem)");

        int op = lerInt("Opção: ");

        switch (op) {
            case 1:
                System.out.print("Nome do alvo: ");
                String alvo = sc.nextLine().trim();
                p.atacar(alvo);
                break;
            case 2:
                p.usarHabilidadeEspecial();
                break;
            case 3:
                if (p instanceof Curavel) {
                    Curavel c = (Curavel) p;
                    int qtd = lerInt("Quantidade de cura: ");
                    c.curar(qtd);
                } else {
                    System.out.println("Este personagem não pode curar.");
                }
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    // ──────────────────────────────────────────
    // UTILITÁRIOS
    // ──────────────────────────────────────────
    static void listarNomes() {
        List<Personagem> lista = gerenciador.listar();
        System.out.println();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).getNome() + " [" + lista.get(i).getTipo() + "]");
        }
    }

    static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}
