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
                if (l.getArrayLocatarios().isEmpty()) {
                    System.out.println("\nNao ha Locatarios cadastrados!");
                    break;
                } else if (l.getArrayExemplares().isEmpty()) {
                    System.out.println("\nNao ha Exemplares cadastrados!");
                    break;
                } else if (l.config.getMulta() == 0) {
                    System.out.println("\nNao ha Configuracao cadastrada!");
                    break;
                }

                String matricula = "";
                String codigoEx = "";

                in.nextLine();
                do {
                    System.out.println("\nMatrícula: ");
                    matricula = in.nextLine();
                } while ((l.pesquisarLocatario(matricula) == null) || matricula.equals(""));

                do {
                    System.out.println("\nCódigo do exemplar: ");
                    codigoEx = in.nextLine();
                } while ((l.pesquisarExemplar(codigoEx) == null) || codigoEx.equals(""));

                l.realizarEmprestimo(matricula, codigoEx);
                break;

            case 3: // Cadastrar devolucao
                if (l.getArrayLocatarios().isEmpty()) {
                    System.out.println("\nNao ha Locatarios cadastrados!");
                    break;
                } else if (l.getArrayExemplares().isEmpty()) {
                    System.out.println("\nNao ha Exemplares cadastrados!");
                    break;
                } else if (l.config.getMulta() == 0) {
                    System.out.println("\nNao ha Configuracao cadastrada!");
                    break;
                } else if (l.getArrayEmprestimos().isEmpty()) {
                    System.out.println("\nNao ha Emprestimos cadastrados!");
                    break;
                }

                matricula = "";
                codigoEx = "";

                in.nextLine();
                do {
                    System.out.println("\nMatrícula: ");
                    matricula = in.nextLine();
                } while ((l.pesquisarLocatario(matricula) == null) || matricula.equals(""));

                do {
                    System.out.println("\nCódigo do exemplar: ");
                    codigoEx = in.nextLine();
                } while ((l.pesquisarExemplar(codigoEx) == null) || codigoEx.equals(""));

                l.realizarDevolucao(matricula, codigoEx);
                break;
            case 4: // Menu de relatorios
                SubMenuRelatorio.menuRelatorio(l);
                break;
            case 5: // Pesquisar
                SubMenuPesquisar.menuPesquisar(l);
                break;
            case 6:
                if (l.config.getMulta() == 0) {
                    System.out.println("\nNao ha configuracao cadastrada!\n");
                    break;
                }
                SubMenuConfiguracao.menuConfiguracao(l);
                // Alterar Configuracao
                break;
            case 0: // Sair
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
            }
        } while (opcao != 0);
    }
}