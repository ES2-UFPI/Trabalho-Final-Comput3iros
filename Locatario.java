public class Locatario {
    private String matricula;
    private String nome;
    private String categoria;
    private String senha;
    
    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public String getSenha() { return senha; }

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
}