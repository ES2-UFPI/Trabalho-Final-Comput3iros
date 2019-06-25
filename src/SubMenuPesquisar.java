import java.util.Scanner;

public class SubMenuPesquisar {
    public static void menuPesquisar(Locadora l) {
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

        Scanner in = new Scanner(System.in);
        System.out.print("                  Opção ->  ");
        int opcao = in.nextInt();

        while (opcao < 0 || opcao > 2) {
            System.out.print("                  Opção ->  ");
            opcao = in.nextInt();
        }

        switch (opcao) {
        case 1: // Pesquisa Exemplar
            in.nextLine();
            System.out.println("\nDigite o código do Exemplar para pesquisa ->  ");
            String codigo = in.nextLine();
            Exemplar ex = l.pesquisarExemplar(codigo);

            if (ex == null) {
                System.out.println("\nExemplar nao encontrado/existente!\n");
            } else {
                System.out.println("\n    -> Exemplar pesquisado:");
                if (ex instanceof Livro) {
                    System.out.println("\n   * Livro:\n\nTitulo: " + ex.getTitulo() + "\nCodigo: " + ex.getCodigo()
                            + "\nAutor: " + ex.getAutor() + "\nVolume: " + ((Livro) ex).getVolume() + "\nQuant de Pag: "
                            + ((Livro) ex).getNumPaginas() + "\n");
                } else if (ex instanceof Artigo) {
                    System.out.println("\n   * Artigo:\n\nTitulo: " + ex.getTitulo() + "\nCodigo: " + ex.getCodigo()
                            + "\nAutor: " + ex.getAutor() + "\nVolume: " + ((Artigo) ex).getRevista() + "\n");
                }
            }
            break;

        case 2: // Pesquisa Locatario
            in.nextLine();
            System.out.println("\nDigite a matricula do Locatario para pesquisa ->  ");
            String matricula = in.nextLine();
            Locatario loc = l.pesquisarLocatario(matricula);

            if (loc == null) {
                System.out.println("\nLocatario nao encontrado/existente!\n");
            } else {
                System.out.println("\n    -> Locatario pesquisado:\n\nNome: " + loc.getNome() + "\nMatricula: "
                        + loc.getMatricula() + "\nCategoria: " + loc.getCategoria() + "\n");
            }
            break;
        case 0: // Sair
            break;
        default:
            System.out.println("Opção Inválida!");
            break;
        }
    }
}