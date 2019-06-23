package functions;

import java.util.ArrayList;

public class Locadora {
    private ArrayList<Locatario> locatarios = new ArrayList<Locatario>();

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

    public ArrayList<Locatario> getLocatarios(){
        return this.locatarios;
    }
}