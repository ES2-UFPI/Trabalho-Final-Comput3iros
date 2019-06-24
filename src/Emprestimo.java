public class Emprestimo {
    private Exemplar exemplar;
    private Locatario locatario;
    private long dataEmp;
    private long dataDevol;
    private boolean isAtrasado;

    public Emprestimo(Exemplar exemplar, Locatario locatario, long dataEmp, Long dataDevol) {
        this.exemplar = exemplar;
        this.locatario = locatario;
        this.dataEmp = dataEmp;
        this.dataDevol = dataDevol;
        this.isAtrasado = false;
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

    public boolean isAtrasado() {
        return isAtrasado;
    }

    public void setIsAtrasado(boolean atrasado) {
        this.isAtrasado = atrasado;
    }
}