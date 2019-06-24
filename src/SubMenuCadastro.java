import java.util.Scanner;

public class SubMenuCadastro {
    public static void menuCadastro(Locadora l) {
        int opcao = 0;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n       ### Locadora - Sistema de Empréstimos e Devoluções ###");
            System.out.println("\n                  ===================================");
            System.out.println("                  |             Cadastro            |");
            System.out.println("                  ===================================");
            System.out.println("                  |                                 |");
            System.out.println("                  |     1 - Locatário               |");
            System.out.println("                  |     2 - Exemplar                |");
            System.out.println("                  |     3 - Configuração            |");
            System.out.println("                  |     0 - Sair                    |");
            System.out.println("                  ===================================\n");

            System.out.print("                  Opção ->  ");
            opcao = in.nextInt();

            while (opcao < 0 || opcao > 3) {
                System.out.print("                  Opção ->  ");
                opcao = in.nextInt();
            }

            switch (opcao) {
            case 1: // Cadastro de Locatario
                in.nextLine();
                System.out.println("    -> Matricula: ");
                String matricula = in.nextLine();
                System.out.println("    -> Nome: ");
                String nome = in.nextLine();
                System.out.println("    -> Categoria: ");
                String categoria = in.nextLine();
                System.out.println("    -> Senha: ");
                String senha = in.nextLine();

                l.cadastrarLocatario(matricula, nome, categoria, senha);

                break;
            case 2: // Cadastro de Exemplar
                SubMenuExemplar.menuExemplar(l);
                break;
            case 3: // Cadastro de Configuracao
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