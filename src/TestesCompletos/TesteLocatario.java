package TestesCompletos;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class TesteLocatario {

    @Test
    public void cadastrarLocatario() {

        Locadora locadora = new Locadora();

        // testando cadastro de um locatario ...

        Locatario locatario = new Locatario();
        locatario.setNome("Mateus");
        locatario.setMatricula("123456");
        locatario.setSenha("tito123");
        locatario.setCategoria("aluno");

        System.out.println("Rodando teste locatario...");
        locadora.cadastrarLocatario(locatario);
        assertEquals("Mateus", locadora.getLocatarios().get(0).getNome());
        assertEquals("123456", locadora.getLocatarios().get(0).getMatricula());
        assertEquals("tito123", locadora.getLocatarios().get(0).getSenha());
        assertEquals("aluno", locadora.getLocatarios().get(0).getCategoria());

        // testando outro locatario ...

        Locatario locatario2 = new Locatario();
        locatario.setNome("Tito");
        locatario.setMatricula("010101");
        locatario.setSenha("mtb000111");
        locatario.setCategoria("aluno");

        System.out.println("Rodando teste locatario 2...");
        locadora.cadastrarLocatario(locatario2);
        assertEquals("Tito", locadora.getLocatarios().get(1).getNome());
        assertEquals("010101", locadora.getLocatarios().get(1).getMatricula());
        assertEquals("mtb000111", locadora.getLocatarios().get(1).getSenha());
        assertEquals("aluno", locadora.getLocatarios().get(1).getCategoria());
    }
}