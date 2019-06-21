import java.util.ArrayList;

public class Locadora {
    private ArrayList<Locatario> locatarios = new ArrayList<Locatario>();

    public void cadastrarLocatario(Locatario l) {
        if (l.validaLocatario(l) == true) {
            locatarios.add(l);
            System.out.println("\nLocatario cadastrado com sucesso.\n");
        } else {
            System.out.println("\nNão foi possivel cadastrar locatario.\n");
        }
    }
}