import java.util.Scanner;

public class SubMenuConfiguracao {
    public static void menuConfiguracao(Locadora l) {
        Scanner in = new Scanner(System.in);
        int opcao;
        double multa = 0;

        do {
            System.out.println("\n       ### Locadora - Sistema de Empréstimos e Devoluções ###");
            System.out.println("\n                  ===================================");
            System.out.println("                  |          Configuracao           |");
            System.out.println("                  ===================================");
            System.out.println("                  |                                 |");
            System.out.println("                  |     1 - Alterar multa           |");
            System.out.println("                  |     2 - Alterar dias professor  |");
            System.out.println("                  |     3 - Alterar dias aluno      |");
            System.out.println("                  |     4 - Alterar dias tecnico adm|");
            System.out.println("                  |     0 - Sair                    |");
            System.out.println("                  ===================================\n");

            System.out.print("                  Opção ->  ");
            opcao = in.nextInt();

            while (opcao < 0 || opcao > 4) {
                System.out.print("                  Opção ->  ");
                opcao = in.nextInt();
                in.close();

            }

            switch (opcao) {
            case 1:
                System.out.println("\n    -> Multa atual: R$ " + l.config.getMulta() + "\n");

                do {
                    System.out.print("Digite a nova multa: ");
                    multa = in.nextDouble();
                } while (multa <= 0);

                System.out.println("\nMulta alterada!\n");
                l.config.setMulta(multa);
                break;
            case 2:
                System.out.println(
                        "\n    -> Quantidade de dias do professor registrados: " + l.config.getDiasProf() + "\n");
                int diasProfessor;
                do {
                    System.out.print("Digite a nova quantidade de dias do professor: ");
                    diasProfessor = in.nextInt();
                } while (diasProfessor <= 0);

                System.out.println("\nQuantidade de dias alterada!\n");
                l.config.setDiasProf(diasProfessor);
                break;
            case 3:
                System.out
                        .println("\n    -> Quantidade de dias do aluno registrados: " + l.config.getDiasAluno() + "\n");
                int diasAluno;
                do {
                    System.out.print("Digite a nova quantidade de dias do aluno:");
                    diasAluno = in.nextInt();
                } while (diasAluno <= 0);

                System.out.println("\nQuantidade de dias alterada!\n");
                l.config.setDiasAluno(diasAluno);
                break;
            case 4:
                System.out
                        .println("\n    -> Quantidade de dias do tecnico registrados: " + l.config.getDiasTec() + "\n");
                int diasTec;
                do {
                    System.out.print("Digite a nova quantidade de dias do tecnico:");
                    diasTec = in.nextInt();
                } while (diasTec <= 0);

                System.out.println("\nQuantidade de dias alterada!\n");
                l.config.setDiasTec(diasTec);
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