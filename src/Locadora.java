import java.util.ArrayList;
import java.util.Date;

public class Locadora {
    private ArrayList<Locatario> locatarios = new ArrayList<Locatario>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();

    public static Configuracao config;

    public void cadastrarLocatario(Locatario l) {
        if (validaLocatario(l) == true) {
            locatarios.add(l);
            System.out.println("\nLocatario cadastrado com sucesso.\n");
        } else {
            System.out.println("\nNão foi possivel cadastrar locatario.\n");
        }
    }

    // varificação dos dados para cadastro de locatario
    public boolean validaLocatario(Locatario l) {
        if ((l.getMatricula().length() < 4) || (l.getSenha().length() < 4) || (l.getCategoria().length() == 0)
                || (l.getCategoria().length() < 4)) {

            // evitar cadastro com matricula igual
            for (int i = 0; i < locatarios.size(); i++) {
                if (locatarios.get(i).getMatricula().equals(l.getMatricula())) {
                    return false;
                }
            }
            return false;
        } else {
            return true;
        }
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
    @SuppressWarnings("deprecation")
    public static double calculaMulta(Date dataDev, Date dataEmp, String categoria) {
        long milisegundosEmUmDia = 86400000;
        int dias_passados = dataDev.getDay() - dataEmp.getDay(); // dataDevolução - dataEmprestimo = dias que passaram

        if (categoria == "aluno") {
            int dias_permitidos = config.getDiasAluno();
            if (dias_passados > dias_permitidos) {
                int dias_multa = dias_passados - dias_permitidos;
                double multa = config.getMulta() * dias_multa;
                return multa;
            } else {
                double multa = 0;
                System.out.println("\nNao teve nenhum valor de multas.");
                return multa;
            }
        }

        if (categoria == "professor") {
            int dias_permitidos = config.getDiasProf();
            if (dias_passados > dias_permitidos) {
                int dias_multa = dias_passados - dias_permitidos;
                double multa = config.getMulta() * dias_multa;
                return multa;
            } else {
                double multa = 0;
                System.out.println("\nNao teve nenhum valor de multas.");
                return multa;
            }
        }

        if (categoria == "tecnico") {
            int dias_permitidos = config.getDiasTec();
            if (dias_passados > dias_permitidos) {
                int dias_multa = dias_passados - dias_permitidos;
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

        if (l == null) {
            System.out.println("Locatario nao encontrado");
            return null;
        }
        if (e == null) {
            System.out.println("Exemplar nao encontrado");
            return null;
        }

        if (!(quantidadeEmprestada(e) < e.getQuantidade())) {// Quantidade emprestada eh menor que a quantidade
                                                             // disponivel
            return null;
        }

        int quantDias = 0;

        Date dtEmprestimo = new Date();

        long milisegundosEmUmDia = 86400000;
        Date dtDevol = new Date(dtEmprestimo.getTime() + (quantDias * milisegundosEmUmDia));

        // multa refente ao emprestimo sendo calculada
        double multa = calculaMulta(dtDevol, dtEmprestimo, l.getCategoria());

        Emprestimo emp = new Emprestimo(e, l, dtEmprestimo, dtDevol);
        addEmprestimo(emp);

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
}