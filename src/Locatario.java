public class Locatario {
    private String matricula;
    private String nome;
    private String categoria;
    private String senha;

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getSenha() {
        return senha;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
}