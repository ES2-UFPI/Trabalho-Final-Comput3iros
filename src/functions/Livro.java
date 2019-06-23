package functions;

public class Livro extends Exemplar{
    
    private String volume;
    private int numPaginas;

    public Livro(String codigo, int quantidade, String titulo, String autor,String volume,int numPaginas) {
        super(codigo, quantidade, titulo, autor);
        this.volume=volume;
        this.numPaginas=numPaginas;
    }

    public String getVolume(){ 
        return volume; 
    }

    public void setVolume(String volume){
        this.volume = volume;
    }
    
    public int getNumPaginas(){
        return numPaginas;
    }
    public void setNumPaginas(int numPaginas){
        this.numPaginas=numPaginas;
    }
}