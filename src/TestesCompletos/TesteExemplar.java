package TestesCompletos;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import src.Locadora;
import src.Exemplar;
import src.Livro;
import src.Artigo;

public class TesteExemplar {
    @Test
    public void cadastrarExemplar() {
        System.out.println("Testar cadastro de Exemplar");

        // se o exemplar for um Livro
        Locadora.cadastrarExemplar("123456", "Crime-e-Castigo", "Dostoievsky", 5, "3", 654);
        assertEquals(true, Locadora.getArrayExemplares().get(0) instanceof Livro);
        assertEquals("123456", Locadora.getArrayExemplares().get(0).getCodigo());
        assertEquals("Crime-e-Castigo", Locadora.getArrayExemplares().get(0).getTitulo());
        assertEquals("Dostoievsky", Locadora.getArrayExemplares().get(0).getAutor());
        assertEquals(5, Locadora.getArrayExemplares().get(0).getQuantidade());
        assertEquals("3", (Livro) Locadora.getArrayExemplares().get(0).getVolume());
        assertEquals(654, (Livro) Locadora.getArrayExemplares().get(0).getPaginas());

        // se o exemplar for um Artigo
        Locadora.cadastrarExemplar("40028922", "Star-Wars", "GeorgeLucas", 7, "Recreio");
        assertEquals(true, Locadora.getArrayExemplares().get(1) instanceof Artigo);
        assertEquals("40028922", Locadora.getArrayExemplares().get(1).getCodigo());
        assertEquals("Star-Wars", Locadora.getArrayExemplares().get(1).getTitulo());
        assertEquals("GeorgeLucas", Locadora.getArrayExemplares().get(1).getAutor());
        assertEquals(7, Locadora.getArrayExemplares().get(1).getQuantidade());
        assertEquals("Recreio", (Artigo) Locadora.getArrayExemplares().get(1).getRevista());
    }

    @Test
    public void pesquisarExemplar() {
        System.out.println("\nTestar Pesquisar exemplar por código");

        Exemplar e = Locadora.pesquisarExemplar("123456");
        assertEquals(true, e instanceof Livro); // exemplar é um Livro
        assertEquals("Crime-e-Castigo", e.getTitulo());
        assertEquals("Dostoievsky", e.getAutor());
        assertEquals(5, e.getQuantidade());
        assertEquals("3", ((Livro) e).getVolume());
        assertEquals(654, ((Livro) e).getPaginas());
    }
}