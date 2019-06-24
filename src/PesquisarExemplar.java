import java.util.ArrayList;
import java.util.Scanner;

public class PesquisarExemplar {
    public static Exemplar PesquisaExemp(ArrayList<Exemplar> exemp) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o codigo:");
        String cod=scanner.nextLine();
        scanner.close();
        for(Exemplar a : exemp){
            if(a.getCodigo()==cod){
            Exemplar ena = a;}
            
        }
        return ena;
    
}}