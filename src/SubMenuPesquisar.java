import java.util.Scanner;

public class SubMenuPesquisar {
    public static void menuPesquisar() {
        System.out.println("\n       ### Locadora - Sistema de Empréstimos e Devoluções ###");
        System.out.println("\n                  ===================================");
        System.out.println("                  |            Pesquisar            |");
        System.out.println("                  ===================================");
        System.out.println("                  |                                 |");
        System.out.println("                  |     1 - Exemplar                |");
        System.out.println("                  |     2 - Locatario               |");
        System.out.println("                  |                                 |");
        System.out.println("                  |     0 - Sair                    |");
        System.out.println("                  ===================================\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("                  Opção ->  ");
        int opcao = scanner.nextInt();

        while (opcao < 0 || opcao > 2) {
            System.out.print("                  Opção ->  ");
            opcao = scanner.nextInt();
            scanner.close();
        }

        Locadora locadora = new Locadora();

        switch (opcao) {
        case 1: // Pesquisa Exemplar
            System.out.println("\nDigite o código do Exemplar para pesquisa ->  ");
            String codigo = scanner.nextLine();
            locadora.pesquisarExemplar(codigo);
            break;

        case 2: // Pesquisa Locatario
            System.out.println("\nDigite a matricula do Locatario para pesquisa ->  ");
            String matricula = scanner.nextLine();
            locadora.pesquisarLocatario(matricula);
            break;

        case 0: // Sair
            break;

        default:
            System.out.println("Opção Inválida!");
            break;
        }
    }
}