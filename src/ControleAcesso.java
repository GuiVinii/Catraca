import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ControleAcesso {
    private Map<String, LocalDateTime> registros;

    public ControleAcesso() {
        this.registros = new HashMap<>();
    }

    public void registrarAcesso(String codigo) {
        LocalDateTime agora = LocalDateTime.now();

        if (registros.containsKey(codigo)) {
            System.out.println("Obrigado pela visita");
        } else {
            registros.put(codigo, agora);
            System.out.println("Bem-vindo, acesso liberado");
        }
    }

    public void registrarSaida(String codigo) {
        LocalDateTime agora = LocalDateTime.now();

        if (registros.containsKey(codigo)) {
            LocalDateTime entrada = registros.get(codigo);
            long minutosDePermanencia = entrada.until(agora, java.time.temporal.ChronoUnit.MINUTES);
            System.out.println("Tempo de permanência: " + minutosDePermanencia + " minutos");
            registros.remove(codigo);
        } else {
            System.out.println("Este código não possui registro de entrada.");
        }
    }

    public Map<String, LocalDateTime> getRegistros() {
        return registros;
    }

    public void setRegistros(Map<String, LocalDateTime> registros) {
        this.registros = registros;
    }
}
