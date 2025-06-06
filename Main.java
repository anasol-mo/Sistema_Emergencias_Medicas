import src.Despachador;
import src.MonitorSistema;
import src.Operador;
import src.SimuladorFallas;
import src.SistemaEmergencias;

public class Main {
    public static void main(String[] args) {
        SistemaEmergencias sistema = new SistemaEmergencias();

        Thread operador1 = new Thread(new Operador(sistema));
        Thread despachador1 = new Thread(new Despachador(sistema));
        Thread monitor = new Thread(new MonitorSistema(sistema));
        Thread simuladorFallas = new Thread(new SimuladorFallas(sistema));
        simuladorFallas.start();

        operador1.start();
        despachador1.start();
        monitor.start();
        simuladorFallas.start();
    }
}