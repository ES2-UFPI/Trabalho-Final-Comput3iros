import java.util.Scanner;

public class SubMenuPesquisar {
    public static void menuPesquisar(Locadora locadora) {
        System.out.println("\n       ### Locadora - Sistema de Empréstimos e Devoluções ###");
        System.out.println("\n                  ===================================");
        System.out.println("                  |            Pesquisar            |");
        System.out.println("                  ===================================");
        System.out.println("                  |                                 |");
        System.out.println("                  |     1 - Exemplar                |");
        System.out.println("                  |     2 - Locatario               |");
        System.out.println("                  |                                 |");
        System.out.println("                  |     0 - Sair                    |");
        System.out.println("                  ===================================\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("                  Opção ->  ");
        int opcao = scanner.nextInt();

        while (opcao < 0 || opcao > 2) {
            System.out.print("                  Opção ->  ");
            opcao = scanner.nextInt();
            scanner.close();
        }

        switch (opcao) {
        case 1: Exemplar e =PesquisarExemplar.PesquisaExemp(locadora.exemplares);
                
        // Pesquisa Exemplar
            break;
        case 2: Locatario t = PesquisarLocatario.PesquisaLoca(locadora.locatarios);
        // Pesquisa Locatario
            break;
        case 0: // Sair
            break;
        default:
            System.out.println("Opção Inválida!");
            break;
        }
    }
}