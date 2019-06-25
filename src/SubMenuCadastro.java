import java.util.Scanner;

public class SubMenuCadastro {
    public static void menuCadastro(Locadora l) {
        int opcao = 0;
        Scanner in = new Scanner(System.in);

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
            opcao = in.nextInt();

            while (opcao < 0 || opcao > 3) {
                System.out.print("                  Opção ->  ");
                opcao = in.nextInt();
            }

            switch (opcao) {
            case 1: // Cadastro de Locatario
                in.nextLine();
                String matricula = "";
                do {
                    System.out.println("    -> Matricula: ");
                    matricula = in.nextLine();
                } while ((l.pesquisarLocatario(matricula) != null) || matricula.equals(""));

                System.out.println("    -> Nome: ");
                String nome = in.nextLine();
                System.out.println("    -> Categoria: ");
                String categoria = in.nextLine();
                System.out.println("    -> Senha: ");
                String senha = in.nextLine();

                l.cadastrarLocatario(matricula, nome, categoria, senha);

                break;
            case 2: // Cadastro de Exemplar
                SubMenuExemplar.menuExemplar(l);
                break;
            case 3: // Cadastro de Configuracao
                if (l.config.getMulta() > 0) {
                    System.out.println(
                            "\nJa existe uma configuracao cadastrada, acesse o menu Alterar configuracao se deseja altera-la!\n");
                    break;
                }
                double multa = 0;
                do {
                    System.out.print("Digite o valor para a multa: ");
                    multa = in.nextDouble();
                } while (multa <= 0);

                System.out.println("\nMulta cadastrada!\n");
                l.config.setMulta(multa);

                int dias = 0;
                do {
                    System.out.print("Digite a quantidade de dias do professor: ");
                    dias = in.nextInt();
                } while (dias <= 0);

                System.out.println("\nQuantidade de dias definida!\n");
                l.config.setDiasProf(dias);

                do {
                    System.out.print("Digite a quantidade de dias do aluno:");
                    dias = in.nextInt();
                } while (dias <= 0);

                System.out.println("\nQuantidade de dias definida!\n");
                l.config.setDiasAluno(dias);

                do {
                    System.out.print("Digite a quantidade de dias do tecnico:");
                    dias = in.nextInt();
                } while (dias <= 0);

                System.out.println("\nQuantidade de dias definida!\n");
                l.config.setDiasTec(dias);

                System.out.println("\n\nCONFIGURACAO CADASTRADA!\n");
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