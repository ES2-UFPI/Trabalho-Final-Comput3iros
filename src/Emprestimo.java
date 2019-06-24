import java.util.Date;

public class Emprestimo {
    private Exemplar exemplar;
    private Locatario locatario;
    private long dataEmp;
    private long dataDevol;
    private boolean isDevolvido;

    public Emprestimo(Exemplar exemplar, Locatario locatario, long dataEmp, Long dataDevol) {
        this.exemplar = exemplar;
        this.locatario = locatario;
        this.dataEmp = dataEmp;
        this.dataDevol = dataDevol;
        this.isDevolvido = false;
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

    public long getDataEmp() {
        return dataEmp;
    }

    public void setDataEmp(long dataEmp) {
        this.dataEmp = dataEmp;
    }

    public long getDataDevol() {
        return dataDevol;
    }

    public void setDataDevol(Long dataDevol) {
        this.dataDevol = dataDevol;
    }

    public boolean isDevolvido() {
        return isDevolvido;
    }

    public void setDevolvido(boolean devol) {
        this.isDevolvido = devol;
    }

    public boolean isAtrasado() {
        Date data = new Date();
        long dataAtual = data.getTime();
        if (dataAtual > dataDevol) { // Se estiver atrasado (dataAtual > dataDevol)
            return true;
        }
        return false;
    }
}