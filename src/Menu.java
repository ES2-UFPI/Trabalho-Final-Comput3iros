public class Menu {

    // menu principal
    private static void menu() {
        int opcao = 0;
        do {
            System.out.println("\n\n### Locadora - Sistema de Empréstimos e Devoluções ###");
            System.out.println("\n                ===================================");
            System.out.println("                  |     1 - Cadastro                |");
            System.out.println("                  |     2 - Empréstimo              |");
            System.out.println("                  |     3 - Devolução               |");
            System.out.println("                  |     4 - Relatórios              |");
            System.out.println("                  |     5 - Pesquisar               |");
            System.out.println("                  |     6 - Alterar Configuração    |");
            System.out.println("                  |     0 - Sair                    |");
            System.out.println("                  ===================================\n");

            opcao = Console.readInt("Opção -> ");
            System.out.print("\n");
            switch (opcao) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 0:
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
            }
        } while (opcao != 0);
    }
}