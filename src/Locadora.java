import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Locadora {
    private ArrayList<Locatario> locatarios = new ArrayList<Locatario>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();

    public static Configuracao config = null;

    public void cadastrarLocatario(String matricula, String nome, String categoria, String senha) {
        if (matricula.equals("")) {
            System.out.println("\nMatricula não pode ser vazio.");
            return;
        }
        if (nome.equals("")) {
            System.out.println("\nNome não pode ser vazio.");
            return;
        }
        if ((categoria.equals("")) || (!(categoria.equals("aluno")) && !(categoria.equals("professor"))
                && !(categoria.equals("tecnico")))) {
            System.out.println("\nCategoria inválida (aluno, professor ou técnico).");
            return;
        }
        if (senha.equals("")) {
            System.out.println("\nSenha não pode ser vazio.");
            return;
        }

        Locatario l = new Locatario(matricula, nome, categoria, senha);

        this.locatarios.add(l);

        System.out.println("\n\n--> Locatario " + l.getNome() + " adicionado!");
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
            System.out.println("\nLivro ja existente");
            return;
        }

        Livro l = new Livro(codigo, quantidade, titulo, autor, volume, numPaginas);

        this.exemplares.add(l);

        System.out.println("\n\n  --> Livro " + l.getTitulo() + " adicionado a Locadora!\n");
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
            if (l.getMatricula().equals(matricula)) {
                return l;
            }
        }
        return null;
    }

    public Exemplar pesquisarExemplar(String codigo) {
        for (Exemplar e : this.exemplares) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }

    // Metodo para calcular o valor da Multa dependendo da categoria
    public double calculaMulta(long dataDev, long dataEmp, String categoria) {
        double multa = 0;
        long dias_passados = dataDev - dataEmp;

        if (categoria.equals("aluno")) {
            long dias_permitidos = config.getDiasAluno(); // vem dias como inteiro

            if (dias_passados > dias_permitidos) {
                long dias_multa = dias_passados - dias_permitidos;
                multa = config.getMulta() * dias_multa;
            }
        }

        if (categoria.equals("professor")) {
            long dias_permitidos = config.getDiasProf(); // vem dias como inteiro

            if (dias_passados > dias_permitidos) {
                long dias_multa = dias_passados - dias_permitidos;
                multa = config.getMulta() * dias_multa;
            }
        }

        if (categoria.equals("tecnico")) {
            long dias_permitidos = config.getDiasTec(); // vem dias como inteiro
            if (dias_passados > dias_permitidos) {
                long dias_multa = dias_passados - dias_permitidos;
                multa = config.getMulta() * dias_multa;
            }
        }
        if (multa == 0) {
            System.out.println("\nNao teve nenhum valor de multas.\n");
        }
        return multa;
    }

    public void realizarDevolucao(String matricula, String codigoEx) {
        if (this.config == null) {
            System.out.println("\nNenhuma configuracao cadastrada.\n");
            return;
        }

        Locatario l = this.pesquisarLocatario(matricula);
        Exemplar e = this.pesquisarExemplar(codigoEx);

        if (l == null) {
            System.out.println("\nLocatário não existe.");
            return;
        }
        if (e == null) {
            System.out.println("\nExemplar não existe.");
            return;
        }

        long milisegundosEmUmDia = 86400000;

        Date data = new Date();
        long dia_atual = data.getTime() / milisegundosEmUmDia; // dataDevolução - dataEmprestimo = dias que passaram
        long dataEmp = 0;

        Emprestimo emprestimo = null;
        for (Emprestimo emp : this.emprestimos) {
            if ((emp.getLocatario().getMatricula() == l.getMatricula())
                    && (emp.getExemplar().getCodigo() == e.getCodigo())) {
                dataEmp = emp.getDataEmp();
                emprestimo = emp;
            }
        }

        String categoria = l.getCategoria();
        double multa = this.calculaMulta(dia_atual, dataEmp, categoria);

        if (multa > 0) {
            emprestimo.setIsAtrasado(true);
            System.out.println("\n\nDevolução realizada com multa no valor de R$ " + multa + ".\n");
        } else {
            System.out.println("\n\nDevolução realizada sem multa.\n");
        }

        System.out.println("\nLivro " + e.getTitulo() + " devolvido.\n");
        e.setQuantidade(e.getQuantidade() + 1);
    }

    // Caso não seja possível realizar o empréstimo por todos os exemplares do
    // estoque estarem emprestados, então é retornado null.
    public void realizarEmprestimo(String matricula, String codigoEx) {
        if (this.config == null) {
            System.out.println("\nNenhuma configuracao cadastrada.\n");
            return;
        }

        Locatario l = this.pesquisarLocatario(matricula);
        Exemplar e = this.pesquisarExemplar(codigoEx);

        if (l == null) {
            System.out.println("Locatario nao encontrado.");
            return;
        }
        if (e == null) {
            System.out.println("Exemplar nao encontrado.");
            return;
        }

        if (e.getQuantidade() < 2) { // Deve ter pelo menos um exemplar na locadora.
            System.out.println("A locadora precisa ter pelo menos 1 exemplar, logo nao eh possivel emprestar mais.");
            return;
        }

        long milisegundosEmUmDia = 86400000;

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

        long devolucao = data_atual.getTime() + (dtDevol * milisegundosEmUmDia);

        System.out.println("\n\nExemplar " + e.getTitulo() + " emprestado com sucesso!\n");
        e.setQuantidade(e.getQuantidade() - 1);

        Emprestimo emp = new Emprestimo(e, l, dtEmprestimo, devolucao);
        this.emprestimos.add(emp);
    }

    // Relatorios
    public void relatorioDeLocatarios() {
        if (this.locatarios.isEmpty()) {
            System.out.println("\n\nNao ha Locatarios para exibir!\n\n");
            return;
        }

        ArrayList<Locatario> arrayLocatarios = new ArrayList<Locatario>(this.locatarios);
        arrayLocatarios.sort(Comparator.comparing(Locatario::getNome));

        System.out.println("\n---------> Locatarios <-----------\n");
        int i = 1;
        for (Locatario l : arrayLocatarios) {
            System.out.println("    Locatario " + i + ":\nNome: " + l.getNome() + "\nMatricula: " + l.getMatricula()
                    + "\nCategoria: " + l.getCategoria() + "\n\n");
            i += 1;
        }
    }

    public void relatorioDeExemplares() {
        if (this.exemplares.isEmpty()) {
            System.out.println("\n\nNao ha Exemplares para exibir!\n\n");
            return;
        }

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
        if (this.emprestimos.isEmpty()) {
            System.out.println("\n\nNao ha Emprestimos para exibir!\n\n");
            return;
        }

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
                if (e.getLocatario().getMatricula().equals(l.getMatricula())) {
                    System.out.println("\nLivro alugado: " + e.getExemplar().getTitulo() + "\nData do emprestimo: "
                            + e.getDataEmp() + "\nData da devolucao: " + e.getDataDevol());
                }
            }
        }

        in.close();
    }

    public void relatorioEmprestimosComAtraso() {
        if (this.emprestimos.isEmpty()) {
            System.out.println("\n\nNao ha Emprestimos com atraso para exibir!\n\n");
            return;
        }

        Scanner in = new Scanner(System.in);
        int op = 0;

        if (this.emprestimos.isEmpty()) {
            System.out.println("\nNao ha emprestimos com atraso para exibir.\n");
            in.close();
            return;
        }

        System.out.println("-> Relatorio de emprestimos atrasados geral ou por Locatario? <1 ou 2> ");
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
                if (e.getLocatario().getMatricula().equals(l.getMatricula()) && e.isAtrasado()) {
                    System.out.println("\nLivro alugado: " + e.getExemplar().getTitulo() + "\nData do emprestimo: "
                            + e.getDataEmp() + "\nData da devolucao: " + e.getDataDevol() + "\nMulta: R$ " + "\n\n");
                }
            }
        }

        in.close();
    }

    public void relatorioDeConfiguracoes() {
        if (this.config == null) {
            System.out.println("\nNenhuma configuracao cadastrada.\n");
        }

        System.out.println("\n\nValor da multa: " + this.config.getMulta() + "\nDias prof: " + this.config.getDiasProf()
                + "\nDias aluno: " + this.config.getDiasAluno() + "\nDias tecnico: " + this.config.getDiasTec());
    }
}