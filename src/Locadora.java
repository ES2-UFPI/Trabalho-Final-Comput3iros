import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Locadora {
    private ArrayList<Locatario> locatarios = new ArrayList<Locatario>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();

    public static Configuracao config;

    public void cadastrarLocatario(String matricula, String nome, String categoria, String senha) {
        if (matricula.equals("")) {
            System.out.println("\nMatricula não pode ser vazio.");
            return;
        }
        if (nome.equals("")) {
            System.out.println("\nNome não pode ser vazio.");
            return;
        }
        if ((categoria.equals("")) || (categoria != "aluno") || (categoria != "aluno") || (categoria != "aluno")) {
            System.out.println("\nCategoria inválida (aluno, professor ou técnico).");
            return;
        }
        if (senha.equals("")) {
            System.out.println("\nSenha não pode ser vazio.");
            return;
        }

        Locatario l = new Locatario(matricula, nome, categoria, senha);

        this.locatarios.add(l);

        System.out.println("Locatario " + l.getNome() + " adicionado!");
    }

    // Cadastrar Livro
    public void cadastrarExemplar(String codigo, String titulo, String autor, int quantidade, String volume,
            int numPaginas) {
        if (codigo.equals("")) {
            return;
        }
        if (titulo.equals("")) {
            return;
        }
        if (autor.equals("")) {
            return;
        }
        if (quantidade < 1) {
            return;
        }
        if (volume.equals("")) {
            return;
        }
        if (numPaginas < 1) {
            return;
        }

        Exemplar e = this.pesquisarExemplar(codigo);

        if (e != null) {
            System.out.println("Livro ja existente");
            return;
        }

        Livro l = new Livro(codigo, quantidade, titulo, autor, volume, numPaginas);

        this.exemplares.add(l);

        System.out.println("Livro " + l.getTitulo() + " adicionado a Locadora!");
    }

    // Cadastrar Artigo
    public void cadastrarExemplar(String codigo, String titulo, String autor, int quantidade, String revista) {
        if (codigo.equals("")) {
            return;
        }
        if (titulo.equals("")) {
            return;
        }
        if (autor.equals("")) {
            return;
        }
        if (quantidade < 1) {
            return;
        }
        if (revista.equals("")) {
            return;
        }

        Exemplar e = this.pesquisarExemplar(codigo);

        if (e != null) {
            System.out.println("Artigo ja existente");
            return;
        }

        Artigo a = new Artigo(codigo, quantidade, titulo, autor, revista);

        this.exemplares.add(a);

        System.out.println("Artigo " + a.getTitulo() + " adicionado a Locadora!");
    }

    public Locatario pesquisarLocatario(String matricula) {
        for (Locatario l : this.locatarios) {
            if (l.getMatricula() == matricula) {
                return l;
            }
        }
        return null;
    }

    public Exemplar pesquisarExemplar(String codigo) {
        for (Exemplar e : this.exemplares) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<Locatario> getLocatarios() {
        return this.locatarios;
    }

    public void addEmprestimo(Emprestimo em) {
        emprestimos.add(em);
    }

    // Metodo para calcular o valor da Multa dependendo da categoria
    public static double calculaMulta(Date dataDev, Date dataEmp, String categoria) {
        long milisegundosEmUmDia = 86400000;

        long dias = dataDev.getTime() - dataEmp.getTime(); // dataDevolução - dataEmprestimo = dias que passaram
        long dias_passados = (dias / milisegundosEmUmDia); // ficar em dias

        if (categoria.equals("aluno")) {
            long dias_permitidos = config.getDiasAluno(); // vem dias como inteiro
            if (dias_passados > dias_permitidos) {
                long dias_multa = dias_passados - dias_permitidos;
                double multa = config.getMulta() * dias_multa;
                return multa;
            } else {
                double multa = 0;
                System.out.println("\nNao teve nenhum valor de multas.");
                return multa;
            }
        }

        if (categoria.equals("professor")) {
            long dias_permitidos = config.getDiasProf(); // vem dias como inteiro
            if (dias_passados > dias_permitidos) {
                long dias_multa = dias_passados - dias_permitidos;
                double multa = config.getMulta() * dias_multa;
                return multa;
            } else {
                double multa = 0;
                System.out.println("\nNao teve nenhum valor de multas.");
                return multa;
            }
        }

        if (categoria.equals("tecnico")) {
            long dias_permitidos = config.getDiasTec(); // vem dias como inteiro
            if (dias_passados > dias_permitidos) {
                long dias_multa = dias_passados - dias_permitidos;
                double multa = config.getMulta() * dias_multa;
                return multa;
            } else {
                double multa = 0;
                System.out.println("\nNao teve nenhum valor de multas.");
                return multa;
            }
        }
        return 0;
    }

    // Caso não seja possível realizar o empréstimo por todos os exemplares do
    // estoque estarem emprestados, então é retornado null.
    public Emprestimo realizarEmprestimo(String matricula, String codigoEx) {
        Locatario l = this.pesquisarLocatario(matricula);
        Exemplar e = this.pesquisarExemplar(codigoEx);

        long milisegundosEmUmDia = 86400000;

        if (l == null) {
            System.out.println("Locatario nao encontrado.");
            return null;
        }
        if (e == null) {
            System.out.println("Exemplar nao encontrado.");
            return null;
        }

        if (!(quantidadeEmprestada(e) < e.getQuantidade())) {// Quantidade emprestada eh menor que a quantidade
                                                             // disponivel
            return null;
        }
        
        Date data_atual = new Date();
        long dtEmprestimo = data_atual.getTime(); // data atual que ta sendo emprestado
        long dtDevol = 0;

        if (l.getCategoria().equals("aluno")) {
            dtDevol = config.getDiasAluno();
        }
        if (l.getCategoria().equals("professor")) {
            dtDevol = config.getDiasProf();
        }
        if (l.getCategoria().equals("tecnico")) {
            dtDevol = config.getDiasTec();
        }

        long devolucao = data_atual.getTime() * (dtDevol * milisegundosEmUmDia);

        Emprestimo emp = new Emprestimo(e, l, dtEmprestimo, devolucao);
        addEmprestimo(emp);
        
        System.out.println("\nEmpréstimo realizado! Data de devolução:  " + devolucao);

        return emp;
    }

    private int quantidadeEmprestada(Exemplar ex) {
        int cont = 0;
        for (Emprestimo emp : emprestimos) {
            if (emp.getExemplar().getCodigo() == ex.getCodigo() && emp.isDevolvido() == false) {
                cont++;
            }
        }
        return cont;
    }

    public void isDevolvido(Emprestimo em) {
        em.setDevolvido(true);
    }

    // Relatorios
    public void relatorioDeLocatarios() {
        ArrayList<Locatario> arrayLocatarios = new ArrayList<Locatario>(this.locatarios);
        arrayLocatarios.sort(Comparator.comparing(Locatario::getNome));

        System.out.println("\n---------> Locatarios <-----------\n");
        int i = 1;
        for (Locatario l : arrayLocatarios) {
            System.out.println("    Locatario " + i + ":\nNome: " + l.getNome() + "\nMatricula: " + l.getMatricula()
                    + "\nCategoria: " + l.getCategoria() + "\n\n");
        }
    }

    public void relatorioDeExemplares() {
        ArrayList<Exemplar> arrayExemplares = new ArrayList<Exemplar>(this.exemplares);
        arrayExemplares.sort(Comparator.comparing(Exemplar::getTitulo));

        System.out.println("\n---------> Exemplares <-----------\n");

        for (Exemplar e : arrayExemplares) {
            if (e instanceof Livro) {
                int i = 1;
                System.out.println("        Livro");
                System.out.println("    Livro " + i + ":\nTitulo: " + e.getTitulo() + "\nAutor: " + e.getAutor()
                        + "\nCodigo: " + e.getCodigo() + "\nQuantidade: " + e.getQuantidade() + "\nVolume: "
                        + ((Livro) e).getVolume() + "\nQuant de paginas: " + ((Livro) e).getNumPaginas() + "\n\n");
                i += 1;
            } else if (e instanceof Artigo) {
                int i = 1;
                System.out.println("        Artigo");
                System.out.println("    Artigo " + i + ":\nTitulo: " + e.getTitulo() + "\nAutor: " + e.getAutor()
                        + "\nCodigo: " + e.getCodigo() + "\nQuantidade: " + e.getQuantidade() + "\nRevista: "
                        + ((Artigo) e).getRevista() + "\n\n");
                i += 1;
            }
        }
    }

    public void relatorioEmprestimos() {
        Scanner in = new Scanner(System.in);
        int op = 0;

        if (this.emprestimos.isEmpty()) {
            System.out.println("\nNao ha emprestimos para exibir.\n");
            in.close();
            return;
        }

        System.out.println("-> Relatorio de emprestimos geral ou por Locatario? <1 ou 2>");
        do {
            op = in.nextInt();
        } while (op != 1 && op != 2);

        ArrayList<Emprestimo> arrayEmprestimos = new ArrayList<Emprestimo>(this.emprestimos);
        arrayEmprestimos.sort(Comparator.comparing(Emprestimo::getDataEmp));

        if (op == 1) { // Geral
            System.out.println("\n----------> Relatorio de todos os emprestimos <-------------\n");

            for (Emprestimo e : arrayEmprestimos) {
                System.out.println("Nome do locatario: " + e.getLocatario().getNome() + "\nLivro alugado: "
                        + e.getExemplar().getTitulo() + "\nData do emprestimo: " + e.getDataEmp()
                        + "\nData da devolucao: " + e.getDataDevol());
            }
        } else if (op == 2) {
            System.out.println("\n----------> Relatorio de emprestimos de um locatario <-------------\n");

            System.out.print("Digite a matricula: ");
            String matricula = in.nextLine();

            Locatario l = this.pesquisarLocatario(matricula);

            if (l == null) {
                System.out.println("\nLocatario nao encontrado.\n");
                in.close();
                return;
            }

            System.out.println("    Locatario " + l.getNome() + ":\n");

            for (Emprestimo e : arrayEmprestimos) {
                if (e.getLocatario().getMatricula() == l.getMatricula()) {
                    System.out.println("\nLivro alugado: " + e.getExemplar().getTitulo() + "\nData do emprestimo: "
                            + e.getDataEmp() + "\nData da devolucao: " + e.getDataDevol());
                }
            }
        }

        in.close();
    }

    public void relatorioEmprestimosComAtraso() {
        Scanner in = new Scanner(System.in);
        int op = 0;

        if (this.emprestimos.isEmpty()) {
            System.out.println("\nNao ha emprestimos com atraso para exibir.\n");
            in.close();
            return;
        }

        System.out.println("-> Relatorio de emprestimos geral ou por Locatario? <1 ou 2> ");
        do {
            op = in.nextInt();
        } while (op != 1 && op != 2);

        ArrayList<Emprestimo> arrayEmprestimosAtrasados = new ArrayList<Emprestimo>(this.emprestimos);
        arrayEmprestimosAtrasados.sort(Comparator.comparing(Emprestimo::getDataEmp));

        if (op == 1) { // Geral
            System.out.println("\n----------> Relatorio de todos os emprestimos atrasados <-------------\n");

            for (Emprestimo e : arrayEmprestimosAtrasados) {
                if (e.isAtrasado()) {
                    System.out.println("Nome do locatario: " + e.getLocatario().getNome() + "\nLivro alugado: "
                            + e.getExemplar().getTitulo() + "\nData do emprestimo: " + e.getDataEmp()
                            + "\nData da devolucao: " + e.getDataDevol() + "\nMulta: R$ " + "\n\n");
                }
            }
        } else if (op == 2) {
            System.out.println("\n----------> Relatorio de emprestimos de um locatario <-------------\n");

            System.out.print("Digite a matricula: ");
            String matricula = in.nextLine();

            Locatario l = this.pesquisarLocatario(matricula);

            if (l == null) {
                System.out.println("\nLocatario nao encontrado.\n");
                in.close();
                return;
            }

            System.out.println("    Locatario " + l.getNome() + ":\n");

            for (Emprestimo e : arrayEmprestimosAtrasados) {
                if (e.getLocatario().getMatricula() == l.getMatricula() && e.isAtrasado()) {
                    System.out.println("\nLivro alugado: " + e.getExemplar().getTitulo() + "\nData do emprestimo: "
                            + e.getDataEmp() + "\nData da devolucao: " + e.getDataDevol() + "\nMulta: R$ " + "\n\n");
                }
            }
        }

        in.close();
    }
}