package TestesCompletos;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.Calendar;
import java.util.List;
import src.*;


public class TestesEmprestimo{
    @Test
    public void FazEmprestimo(){
        Locadora a = new Locadora();
        a.config = new Configuracao(1.00, 7, 10, 12);
        Locatario l = new Locatario("123","Pedro","aluno","123456");
        Exemplar e = new Exemplar("13",30,"Algoritmos","Cormen");
        a.realizarEmprestimo(l.getMatricula(),e.getCodigo());
        assertThat(l,equalTo(a.getArrayEmprestimos().get(0).getLocatario()));
        assertThat(e,equalTo(a.getArrayEmprestimos().get(0).getExemplar()));



       
        a.config = new Configuracao(3.00, 10, 12, 15);
        Locatario l1 = new Locatario("333","Avelino","professor","654321");
        Exemplar e1 = new Exemplar("123",20,"Sistemas Operacionais","Tanenbaum");
        a.realizarEmprestimo(l1.getMatricula(),e1.getCodigo());
        assertThat(l1,equalTo(a.getArrayEmprestimos().get(1).getLocatario()));
        assertThat(e1,equalTo(a.getArrayEmprestimos().get(1).getExemplar()));


        a.config = new Configuracao(4.50, 12, 15, 18);
        Locatario l2 = new Locatario("4444","Zaza","tecnico","1212");
        Exemplar e2 = new Exemplar("556",15,"C-progressivo","Caelum");
        a.realizarEmprestimo(l2.getMatricula(),e1.getCodigo());
        assertThat(l2,equalTo(a.getArrayEmprestimos().get(2).getLocatario()));
        assertThat(e2,equalTo(a.getArrayEmprestimos().get(2).getExemplar()));
 }
}