import java.util.Scanner;

public class SubMenuCadastro {
    public static void menuCadastro(Locadora l) {
        int opcao;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n       ### Locadora - Sistema de Empréstimos e Devoluções ###");
            System.out.println("\n                  ===================================");
            System.out.println("                  |             Cadastro            |");
            System.out.println("                  ===================================");
            System.out.println("                  |                                 |");
            System.out.println("                  |     1 - Locatário               |");
            System.out.println("                  |     2 - Exemplar                |");
            System.out.println("                  |     3 - Configuração            |");
            System.out.println("                  |     0 - Sair                    |");
            System.out.println("                  ===================================\n");

            System.out.print("                  Opção ->  ");
            opcao = scanner.nextInt();

            while (opcao < 0 || opcao > 3) {
                System.out.print("                  Opção ->  ");
                opcao = scanner.nextInt();
            }

            switch (opcao) {
            case 1: // Cadastro de Locatario
                break;
            case 2: // Cadastro de Exemplar
                SubMenuExemplar.menuExemplar(l);
                break;
            case 3: // Cadastro de Configuracao
                break;
            case 0: // Sair
                scanner.close();
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
            }
        } while (opcao != 0);
    }
}