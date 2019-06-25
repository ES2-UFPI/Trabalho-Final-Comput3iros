package TestesCompletos;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.*;

import src.*;

public class FazDevolucao() {
    
    @Test
    public void RealizarDevolucao() {
        Locatario l = new Locatario("010101", "Mateus", "aluno", "12345678");
        Exemplar e = new Exemplar("333", "5", "Crime-e-Castigo", "Dostoievsky");

        Locadora loc = new Locadora();
        loc.realizarDevolucao(l.getMatricula(),e.getCodigo());
        assertThat(l,equalTo(a.getArrayEmprestimos().get(0).getLocatario()));
        assertThat(e,equalTo(a.getArrayEmprestimos().get(0).getExemplar()));
    }
}