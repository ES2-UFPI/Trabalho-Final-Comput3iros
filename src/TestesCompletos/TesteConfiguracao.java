package TestesCompletos;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TesteConfiguracao {

    @Test
    public void testGetMultaEqual() {
        Configuracao configuracao = new Configuracao(3.50, 7, 10, 12);
        assertEquals(3.50, configuracao.getMulta()); // valor da multa vai ser o mesmo passado

    }

    @Test
    public void testGetDiasAluno() {
        Configuracao configuracao = new Configuracao(3.50, 7, 10, 12);
        assertEquals(7, configuracao.getDiasAluno()); // dias para Alunos: 7 dias

    }

    @Test
    public void testGetDiasProf() {
        Configuracao configuracao = new Configuracao(3.50, 7, 10, 12);
        assertEquals(10, configuracao.getDiasProf()); // dias para Professor: 10 dias

    }

    @Test
    public void testGetDiasTec() {
        Configuracao configuracao = new Configuracao(3.50, 7, 10, 12);
        assertEquals(12, configuracao.getDiasTec()); // dias para Técnico: 12 dias

    }

}