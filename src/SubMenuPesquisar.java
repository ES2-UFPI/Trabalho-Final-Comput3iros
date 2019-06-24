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
                System.out.println("Codigo : "+e.getCodigo());
                System.out.println("Quantidade : "+e.getQuantidade());
                System.out.println("Titulo : "+e.getTitulo());
                System.out.println("Autor : "+e.getAutor());
        // Pesquisa Exemplar
            break;
        case 2: Locatario t = PesquisarLocatario.PesquisaLoca(locadora.locatarios);
                System.out.println("Matricula : "+t.getMatricula());
                System.out.println("Nome : "+t.getNome());
                System.out.println("Categoria : "+t.getCategoria());
                System.out.println("Senha : "+t.getSenha());
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