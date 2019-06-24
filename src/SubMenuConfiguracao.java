import java.util.Scanner;

public class SubMenuConfiguracao {
    public static void menuConfiguracao(Locadora l) {
        int opcao;
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

            Scanner scanner = new Scanner(System.in);
            System.out.print("                  Opção ->  ");
            opcao = scanner.nextInt();

            while (opcao < 0 || opcao > 4) {
                System.out.print("                  Opção ->  ");
                opcao = scanner.nextInt();
                scanner.close();
                
            }

            switch (opcao) {
            case 1: System.out.println("Multa atual = "+l.config.getMulta());
                    Scanner pegamul = new Scanner(System.in);
                    double mult;
                    System.out.print("Digite a nova multa :");
                    mult=pegamul.nextDouble();
                    l.config.setMulta(mult);
                    pegamul.close();
                break;
            case 2: System.out.println("Quantidade de dias do professor = "+l.config.getDiasProf());
                    Scanner pegaDiasProfessor = new Scanner(System.in);
                    int DiasProfessor;
                    System.out.print("Digite a nova quantidade de dias do professor:");
                    DiasProfessor=pegaDiasProfessor.nextInt();
                    l.config.setDiasProf(DiasProfessor);
                    pegaDiasProfessor.close();
                break;
            case 3: System.out.println("Quantidade de dias do aluno = "+l.config.getDiasAluno());
                    Scanner pegaDiasAluno = new Scanner(System.in);
                    int DiasAluno;
                    System.out.print("Digite a nova quantidade de dias do aluno:");
                    DiasAluno=pegaDiasAluno.nextInt();
                    l.config.setDiasAluno(DiasAluno);
                    pegaDiasAluno.close();
                break;
            case 4: System.out.println("Quantidade de dias do tecnico = "+l.config.getDiasTec());
                    Scanner pegaDiasTec = new Scanner(System.in);
                    int DiasTec;
                    System.out.print("Digite a nova quantidade de dias do tecnico:");
                    DiasTec=pegaDiasTec.nextInt();
                    l.config.setDiasTec(DiasTec);
                    pegaDiasTec.close();
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



