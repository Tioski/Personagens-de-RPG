import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Personagem> personagens = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA RPG ===");
            System.out.println("1. Criar personagem");
            System.out.println("2. Listar personagens");
            System.out.println("3. Adicionar item a personagem");
            System.out.println("4. Simular acao");
            System.out.println("0. Sair");
            opcao = lerInt("Opcao: ");

            switch (opcao) {
                case 1: criarPersonagem(); break;
                case 2: listarPersonagens(); break;
                case 3: adicionarItem(); break;
                case 4: simularAcao(); break;
                case 0: System.out.println("Ate mais!"); break;
                default: System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    static void criarPersonagem() {
        System.out.println("\n-- Tipos --");
        System.out.println("1. Mago");
        System.out.println("2. Cavaleiro");
        System.out.println("3. Curandeiro");
        System.out.println("4. Mago Sombrio  (subclasse de Mago)");
        System.out.println("5. Cavaleiro Sagrado (subclasse de Cavaleiro)");
        int tipo = lerInt("Tipo: ");

        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        int vida = lerInt("Vida: ");
        int ataque = lerInt("Ataque: ");

        Personagem p;
        switch (tipo) {
            case 1: p = new Mago(nome, vida, ataque); break;
            case 2: p = new Cavaleiro(nome, vida, ataque); break;
            case 3: p = new Curandeiro(nome, vida, ataque); break;
            case 4: p = new MagoSombrio(nome, vida, ataque); break;
            case 5: p = new CavaleiroSagrado(nome, vida, ataque); break;
            default:
                System.out.println("Tipo invalido. Criando Mago.");
                p = new Mago(nome, vida, ataque);
        }

        personagens.add(p);
        System.out.println("Personagem " + nome + " criado!");
    }

    static void listarPersonagens() {
        if (personagens.isEmpty()) {
            System.out.println("Nenhum personagem cadastrado.");
            return;
        }
        for (int i = 0; i < personagens.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            personagens.get(i).exibirStatus();
        }
    }

    static void adicionarItem() {
        if (personagens.isEmpty()) { System.out.println("Nenhum personagem cadastrado."); return; }
        listarNomes();
        int idx = lerInt("Selecione o personagem: ") - 1;
        Personagem p = buscar(idx);
        if (p == null) return;

        System.out.println("1. Item comum");
        System.out.println("2. Item especial");
        int op = lerInt("Tipo de item: ");

        System.out.print("Nome do item: ");
        String nomeItem = sc.nextLine().trim();
        System.out.print("Descricao: ");
        String desc = sc.nextLine().trim();
        Item item = new Item(nomeItem, desc);

        if (op == 1) {
            p.setItem(item);
            System.out.println("Item comum adicionado a " + p.getNome());
        } else if (op == 2) {
            p.setItemEspecial(item);
            System.out.println("Item especial adicionado a " + p.getNome());
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    static void simularAcao() {
        if (personagens.isEmpty()) { System.out.println("Nenhum personagem cadastrado."); return; }
        listarNomes();
        int idx = lerInt("Selecione o personagem: ") - 1;
        Personagem p = buscar(idx);
        if (p == null) return;

        System.out.println("1. Atacar");
        System.out.println("2. Usar habilidade especial");
        if (p instanceof Curavel) System.out.println("3. Curar");
        int op = lerInt("Acao: ");

        if (op == 1) {
            System.out.print("Nome do alvo: ");
            String alvo = sc.nextLine().trim();
            p.atacar(alvo);
        } else if (op == 2) {
            p.usarHabilidadeEspecial();
        } else if (op == 3 && p instanceof Curavel) {
            int qtd = lerInt("Quantidade de cura: ");
            ((Curavel) p).curar(qtd);
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    static void listarNomes() {
        for (int i = 0; i < personagens.size(); i++) {
            System.out.println((i + 1) + ". " + personagens.get(i).getNome() + " [" + personagens.get(i).getTipo() + "]");
        }
    }

    static Personagem buscar(int idx) {
        if (idx < 0 || idx >= personagens.size()) {
            System.out.println("Personagem nao encontrado.");
            return null;
        }
        return personagens.get(idx);
    }

    static int lerInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido.");
            }
        }
    }
}
