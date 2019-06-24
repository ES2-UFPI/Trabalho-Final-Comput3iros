import java.util.ArrayList;
import java.util.Scanner;

public class PesquisarLocatario {
    public static Locatario PesquisaLoca(ArrayList<Locatario> locatario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a matricula:");
        String mat=scanner.nextLine();
        scanner.close();
        for(Locatario c : locatario){
            if(c.getMatricula()==mat){
            Locatario te = c;}
            
        }
    return te;
}}