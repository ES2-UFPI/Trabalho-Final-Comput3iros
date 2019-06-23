import java.util.ArrayList;
import java.util.Scanner;

public class PesquisarExemplar {
    public static Exemplar PesquisaExemp(ArrayList exemplar) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o codigo:");
        String cod=scanner.nextLine();
        for(Exemplar a : exemplar){
            if(a.getCodigo()==cod){
            return a;}
            return null;
        }
    
}}