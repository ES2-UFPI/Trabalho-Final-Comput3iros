package functions;

import java.util.ArrayList;
import java.util.Date;

public class Locadora {
    private ArrayList<Locatario> locatarios = new ArrayList<Locatario>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

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

    public ArrayList<Locatario> getLocatarios() {
        return this.locatarios;
    }

    public void addEmprestimo(Emprestimo em) {
        emprestimos.add(em);
    }

    // Caso não seja possível realizar o empréstimo por todos os exemplares do
    // estoque estarem emprestados, então é retornado null.
    public Emprestimo emprestar(Locatario l, Exemplar ex, Date dtEmp) {
        if (!(quantidadeEmprestada(ex) < ex.getQuantidade())) {
            return null;
        }

        int quantDias = 0;

        long milisegundosEmUmDia = 86400000;
        Date dtDevol = new Date(dtEmp.getTime() + quantDias * milisegundosEmUmDia);
        Emprestimo emp = new Emprestimo();
        emp.setLocatario(l);
        emp.setExemplar(ex);
        emp.setDataEmp(dtEmp);
        emp.setDataDevol(dtDevol);
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