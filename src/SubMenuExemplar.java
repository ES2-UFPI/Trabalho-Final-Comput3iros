import java.util.Scanner;

public class SubMenuExemplar {
    public static void menuExemplar(Locadora l) {
        int opcao;
        do {
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

            System.out.print("                  Opção ->  ");
            opcao = in.nextInt();

            while (opcao < 0 || opcao > 2) {
                System.out.print("                  Opção ->  ");
                opcao = in.nextInt();
            }

            switch (opcao) {
            case 1: // Cadastro de Livro
                in.nextLine();
                String codigo = "";
                do {
                    System.out.println("    -> Codigo: ");
                    codigo = in.nextLine();
                } while ((l.pesquisarExemplar(codigo) != null) || codigo.equals(""));

                System.out.println("    -> Titulo: ");
                String titulo = in.nextLine();
                System.out.println("    -> Autor: ");
                String autor = in.nextLine();
                System.out.println("    -> Volume: ");
                String volume = in.nextLine();
                System.out.println("    -> Quantidade: ");
                int quantidade = in.nextInt();
                System.out.println("    -> Quantidade de paginas: ");
                int numPaginas = in.nextInt();

                l.cadastrarExemplar(codigo, titulo, autor, quantidade, volume, numPaginas);

                break;
            case 2: // Cadastro de Artigo
                in.nextLine();
                System.out.println("    -> Codigo: ");
                codigo = in.nextLine();
                System.out.println("    -> Titulo: ");
                titulo = in.nextLine();
                System.out.println("    -> Autor: ");
                autor = in.nextLine();
                System.out.println("    -> Revista: ");
                String revista = in.nextLine();
                System.out.println("    -> Quantidade: ");
                quantidade = in.nextInt();

                l.cadastrarExemplar(codigo, titulo, autor, quantidade, revista);

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