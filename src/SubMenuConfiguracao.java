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
                
            }

            switch (opcao) {
            case 1: System.out.println("Multa atual = "+l.config.getMulta());
                    System.out.println("Digite a nova multa : ");
                    double mult=scanner.nextDouble();
                    l.config.setMulta(mult);
                    scanner.close();
                break;
            case 2: 
                break;
            case 3: 
                break;
            case 4: 
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



