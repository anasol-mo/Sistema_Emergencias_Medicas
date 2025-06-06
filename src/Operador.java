package src;
import java.util.Random;

public class Operador implements Runnable {

    private final SistemaEmergencias sistema;
    private final Random random = new Random();

    private final String[] ubicaciones = {"Centro", "Norte", "Sur", "Este", "Oeste"};
    private final String[] descripciones = {"Accidente de tráfico", "Infarto", "Caída grave", "Alergia", "Herida con arma"};

    public Operador(SistemaEmergencias sistema) {
        this.sistema = sistema;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000 + random.nextInt(2000)); // espera 3-5 seg

                Emergencia.Gravedad gravedad = Emergencia.Gravedad.values()[random.nextInt(4)];
                String ubicacion = ubicaciones[random.nextInt(ubicaciones.length)];
                String descripcion = descripciones[random.nextInt(descripciones.length)];

                Emergencia emergencia = new Emergencia(descripcion, ubicacion, gravedad);
                sistema.reportarEmergencia(emergencia);

            } catch (InterruptedException e) {
                System.out.println("[Operador] Hilo interrumpido.");
                break;
            }
        }
    }
}