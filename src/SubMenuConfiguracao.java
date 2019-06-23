import java.util.Scanner;

public class SubMenuConfiguracao {
    public static void menuConfiguracao() {
        System.out.println("\n       ### Locadora - Sistema de Empréstimos e Devoluções ###");
        System.out.println("\n                  ===================================");
        System.out.println("                  |             Configuracao         |");
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
        int opcao = scanner.nextInt();

        while (opcao < 0 || opcao > 4) {
            System.out.print("                  Opção ->  ");
            opcao = scanner.nextInt();
            scanner.close();
        }

        switch (opcao) {
        case 1: // Alterar multa
            break;
        case 2: // Alterar quantidade de dias para professor
            break;
        case 3: // Alterar quantidade de dias para aluno
            break;
        case 4: // Alterar quantidade de dias para tecnico
            break;
        case 0: // Sair
            break;
        default:
            System.out.println("Opção Inválida!");
            break;
        }
    }
}