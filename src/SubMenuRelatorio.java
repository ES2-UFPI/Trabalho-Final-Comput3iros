import java.util.Scanner;

public class SubMenuRelatorio {
    public static void menuRelatorio(Locadora l) {
        int opcao;
        do {
            Scanner in = new Scanner(System.in);

            System.out.println("\n       ### Locadora - Sistema de Empréstimos e Devoluções ###");
            System.out.println("\n                  ===================================");
            System.out.println("                  |             Relatorios          |");
            System.out.println("                  ===================================");
            System.out.println("                  |                                 |");
            System.out.println("                  |     1 - Locatário               |");
            System.out.println("                  |     2 - Exemplar                |");
            System.out.println("                  |     3 - Emprestimos             |");
            System.out.println("                  |     4 - Emprestimos atrasados   |");
            System.out.println("                  |     5 - Configuracoes           |");
            System.out.println("                  |     0 - Sair                    |");
            System.out.println("                  ===================================\n");

            System.out.print("                  Opção ->  ");
            opcao = in.nextInt();

            while (opcao < 0 || opcao > 5) {
                System.out.print("                  Opção ->  ");
                opcao = in.nextInt();
            }

            switch (opcao) {
            case 1: // Relatorios de locatarios
                l.relatorioDeLocatarios();
                break;
            case 2: // Relatorios de Exemplares
                l.relatorioDeExemplares();
                break;
            case 3: // Relatorios de Emprestimos
                l.relatorioEmprestimos();
                break;
            case 4: // Relatorios de Emprestimos com atraso
                l.relatorioEmprestimosComAtraso();
                break;
            case 5: // Relatorios de Configuracoes
                l.relatorioDeConfiguracoes();
                break;
            case 0:
                break;
            }
        } while (opcao != 0);
    }
}