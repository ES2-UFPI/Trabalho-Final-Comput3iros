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
 }
}