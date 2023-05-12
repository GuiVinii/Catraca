import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControleAcesso controle = new ControleAcesso();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite o código do crachá: ");
            String codigo = scanner.nextLine();

            if (codigo.isEmpty()) {
                break;
            }

            controle.registrarAcesso(codigo);

            System.out.print("Deseja registrar a saída? (S/N) ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                controle.registrarSaida(codigo);
            }
        }

        System.out.println("\nRegistros:");
        for (String codigo : controle.getRegistros().keySet()) {
            System.out.println(codigo + " - " + controle.getRegistros().get(codigo));
        }
    }
}