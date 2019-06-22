import java.util.Scanner;

public class MenuPrincipal {
    // Menu principal
    public void menu() {

        System.out.println("\n        ### Locadora - Sistema de Empréstimos e Devoluções ###");
        System.out.println("\n                  ===================================");
        System.out.println("                  |     1 - Cadastro                |");
        System.out.println("                  |     2 - Empréstimo              |");
        System.out.println("                  |     3 - Devolução               |");
        System.out.println("                  |     4 - Relatórios              |");
        System.out.println("                  |     5 - Pesquisar               |");
        System.out.println("                  |     6 - Alterar Configuração    |");
        System.out.println("                  |     0 - Sair                    |");
        System.out.println("                  ===================================\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("                  Opção ->  ");
        int opcao = scanner.nextInt();

        while (opcao < 0 || opcao > 6) {
            System.out.print("                  Opção ->  ");
            opcao = scanner.nextInt();
            scanner.close();
        }

        switch (opcao) {
        case 1: // Chamar submenu Cadastro
            SubMenuCadastro.menuCadastro();
            break;
        case 2: // Cadastrar emprestimo
            break;
        case 3: // Cadastrar devolucao
            break;
        case 4: // Cadastrar relatorio
            break;
        case 5: // Pesquisar
            break;
        case 6: // Alterar Configuracao
            break;
        case 0: // Sair
            break;
        default:
            System.out.println("Opção Inválida!");
            break;
        }
    }
}