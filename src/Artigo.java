public class Artigo extends Exemplar{
    private revista; 

    public Artigo(String codigo, int quantidade, String titulo, String autor, String revista) {
        super(codigo, quantidade, titulo, autor);
        this.revista = revista;
    }

    public String getRevista { return this.revista; }

    public void setRevista(String revista){
        this.revista = revista
    }
}