package functions;

public class Exemplar{
    private String codigo;
    private int quantidade;
    private String titulo;
    private  String autor;

    public Exemplar(String codigo,int quantidade,String titulo,String autor){
        this.codigo=codigo;
        this.quantidade=quantidade;
        this.titulo=titulo;
        this.autor=autor;
    }

    public String getCodigo(){
        return codigo;
    } 
    public void setCodigo(String codigo){
        this.codigo=codigo;
    } 

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade=quantidade;
    }

    public String getTitulo(){
        return titulo;
    } 
    public void setTitulo(String titulo){
        this.titulo=titulo;
    } 

    public String getAutor(){
        return autor;
    } 
    public void setAutor(String autor){
        this.autor=autor;
    } 
    

}