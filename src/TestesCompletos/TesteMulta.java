package TestesCompletos;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import java.util.*;

import src.*;

public class TesteCalculaMulta {

    @Test
    public void CalculaMulta() {

        Configuracao config = new Configuracao(1.00, 7, 10, 12);

        Date data = new Date();
        Date dataDev = data.getTime();
        Date dataEmp = data.getTime();
        dataEmp.setMonth(2);
        dataEmp.setYear(2019);
        dataDev.setMonth(3);
        dataDev.setYear(2019); // 1 mes de tempo
        float multa = Locadora.calculaMulta(dataDev, dataEmp, "aluno"); // multa para aluno
        assertEquals("30", multa);

    }

    @Test
    public void CalculaMultaSemValor() {

        Configuracao config = new Configuracao(1.00, 7, 10, 12);

        Date data = new Date();
        Date dataDev = data.getTime();
        Date dataEmp = data.getTime();
        dataEmp.setMonth(2);
        dataEmp.setYear(2019);
        dataDev.setMonth(2);
        dataDev.setYear(2019); // entrege no dia correto
        float multa = Locadora.calculaMulta(dataDev, dataEmp, "aluno"); // multa para aluno
        assertEquals("0", multa); // nao ocorreu multa, foi entregue a tempo

    }

}