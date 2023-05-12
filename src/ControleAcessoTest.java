import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ControleAcessoTest {
    @Test
    public void registrarAcesso_novoCodigo() {
        ControleAcesso controle = new ControleAcesso();

        String codigo = "1234";
        controle.registrarAcesso(codigo);

        assertTrue(controle.getRegistros().containsKey(codigo));
    }

    @Test
    public void registrarAcesso_codigoExistente() {
        ControleAcesso controle = new ControleAcesso();

        String codigo = "1234";
        controle.registrarAcesso(codigo);

        LocalDateTime entrada = controle.getRegistros().get(codigo);

        controle.registrarAcesso(codigo);

        assertEquals(entrada, controle.getRegistros().get(codigo));
    }

    @Test
    public void registrarSaida_codigoExistente() {
        ControleAcesso controle = new ControleAcesso();

        String codigo = "1234";
        controle.registrarAcesso(codigo);

        LocalDateTime entrada = controle.getRegistros().get(codigo);

        controle.registrarSaida(codigo);

        assertFalse(controle.getRegistros().containsKey(codigo));
    }

    @Test
    public void registrarSaida_codigoNaoExistente() {
        ControleAcesso controle = new ControleAcesso();

        String codigo = "1234";
        controle.registrarAcesso(codigo);

        controle.registrarSaida("5678");

        assertTrue(controle.getRegistros().containsKey(codigo));
    }
}
