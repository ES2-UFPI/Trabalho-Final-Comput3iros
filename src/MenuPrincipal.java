import java.util.Scanner;

public class MenuPrincipal {
    // Menu principal
    public static void menu(Locadora l) {
        int opcao;
        do {
            Scanner in = new Scanner(System.in);

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

            System.out.print("                  Opção ->  ");
            opcao = in.nextInt();

            while (opcao < 0 || opcao > 6) {
                System.out.print("                  Opção ->  ");
                opcao = in.nextInt();
            }

            switch (opcao) {
            case 1: // Chamar submenu Cadastro
                SubMenuCadastro.menuCadastro(l);
                break;

            case 2: // Cadastrar emprestimo
                System.out.println("\nMatrícula: ");
                String matricula = in.nextLine();
                System.out.println("\nCódigo do exemplar: ");
                String codigoEx = in.nextLine();

                do {
                    System.out.println("\nMatrícula: ");
                    matricula = in.nextLine();
                } while ((l.pesquisarLocatario(matricula) != null) || matricula.equals(""));

                do {
                    System.out.println("\nCódigo do exemplar: ");
                    codigoEx = in.nextLine();
                } while ((l.pesquisarExemplar(codigoEx) != null) || codigoEx.equals(""));

                l.realizarEmprestimo(matricula, codigoEx);
                break;

            case 3: // Cadastrar devolucao
                break;
            case 4: // Cadastrar relatorio
                System.out.println("\n       ### Locadora - Sistema de Empréstimos e Devoluções ###");
                System.out.println("\n                  ===================================");
                System.out.println("                  |             Relatorios          |");
                System.out.println("                  ===================================");
                System.out.println("                  |                                 |");
                System.out.println("                  |     1 - Locatário               |");
                System.out.println("                  |     2 - Exemplar                |");
                System.out.println("                  |     3 - Emprestimos             |");
                System.out.println("                  |     4 - Emprestimos atrasados   |");
                System.out.println("                  |     0 - Sair                    |");
                System.out.println("                  ===================================\n");

                System.out.print("                  Opção ->  ");
                opcao = in.nextInt();

                switch (opcao) {
                case 1:
                    l.relatorioDeLocatarios();
                    break;
                case 2:
                    l.relatorioDeExemplares();
                    break;
                case 3:
                    l.relatorioEmprestimos();
                    break;
                case 4:
                    l.relatorioEmprestimosComAtraso();
                    break;
                case 0:
                    break;
                }
                break;
            case 5: // Pesquisar
                SubMenuPesquisar.menuPesquisar(l);
                break;
            case 6:
                SubMenuConfiguracao.menuConfiguracao(l);
                // Alterar Configuracao
                break;
            case 0: // Sair
                in.close();
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
            }
        } while (opcao != 0);
    }
}