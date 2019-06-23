package functions;

import java.util.Date;

public class Emprestimo {
    private Exemplar exemplar;
    private Locatario locatario;
    private Date dataEmp;
    private Date dataDevol;
    private boolean isDevolvido;

    public Emprestimo(Exemplar exemplar, Locatario locatario, Date dataEmp, Date dataDevol) {
        this.exemplar = exemplar;
        this.locatario = locatario;
        this.dataEmp = dataEmp;
        this.dataDevol = dataDevol;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Date getDataEmp() {
        return dataEmp;
    }

    public void setDataEmp(Date dataEmp) {
        this.dataEmp = dataEmp;
    }

    public Date getDataDevol() {
        return dataDevol;
    }

    public void setDataDevol(Date dataDevol) {
        this.dataDevol = dataDevol;
    }

    public boolean isDevolvido() {
        return isDevolvido;
    }

    public void setDevolvido(boolean devol) {
        this.isDevolvido = devol;
    }
}