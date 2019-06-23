import java.util.Scanner;

public class SubMenuExemplar {
    public static void menuExemplar(Locadora l) {
        Scanner in = new Scanner(System.in);

        System.out.println("\n       ### Locadora - Sistema de Empréstimos e Devoluções ###");
        System.out.println("\n                  ===================================");
        System.out.println("                  |             Exemplar            |");
        System.out.println("                  ===================================");
        System.out.println("                  |                                 |");
        System.out.println("                  |     1 - Livro                   |");
        System.out.println("                  |     2 - Artigo                  |");
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
        case 1: // Cadastro de Livro
            System.out.println("    -> Codigo: ");
            String codigo = in.nextLine();
            System.out.println("    -> Titulo: ");
            String titulo = in.nextLine();
            System.out.println("    -> Autor: ");
            String autor = in.nextLine();
            System.out.println("    -> Quantidade: ");
            int quantidade = in.nextInt();
            System.out.println("    -> Volume: ");
            String volume = in.nextLine();
            System.out.println("    -> Quantidade de paginas: ");
            int numPaginas = in.nextInt();

            l.cadastrarExemplar(codigo, titulo, autor, quantidade, volume, numPaginas);

            in.close();
            break;
        case 2: // Cadastro de Artigo
            System.out.println("    -> Codigo: ");
            String codigo = in.nextLine();
            System.out.println("    -> Titulo: ");
            String titulo = in.nextLine();
            System.out.println("    -> Autor: ");
            String autor = in.nextLine();
            System.out.println("    -> Quantidade: ");
            int quantidade = in.nextInt();
            System.out.println("    -> Revista: ");
            String revista = in.nextLine();

            l.cadastrarExemplar(codigo, titulo, autor, quantidade, revista);

            in.close();
            break;
        case 0: // Sair
            break;
        default:
            System.out.println("Opção Inválida!");
            break;
        }
    }
}