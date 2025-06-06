package src;
import java.util.List;
import java.util.Random;

public class SimuladorFallas implements Runnable {

    private final SistemaEmergencias sistema;
    private final Random random = new Random();

    public SimuladorFallas(SistemaEmergencias sistema) {
        this.sistema = sistema;
    }

    @Override
    public void run() {
        List<Ambulancia> ambulancias = sistema.getAmbulancias();

        while (true) {
            try {
                Thread.sleep(10000 + random.nextInt(10000)); // cada 10-20 seg

                Ambulancia amb = ambulancias.get(random.nextInt(ambulancias.size()));

                synchronized (amb) {
                    if (!amb.estaEnFallo()) {
                        amb.marcarFallo();
                        System.out.println("[FALLO] Ambulancia #" + amb.getId() + " ha fallado.");

                        // Restaurar tras 10 segundos
                        new Thread(() -> {
                            try {
                                Thread.sleep(10000);
                                amb.recuperar();
                                System.out.println("[RECUPERADA] Ambulancia #" + amb.getId() + " está nuevamente operativa.");
                            } catch (InterruptedException ignored) {}
                        }).start();
                    }
                }

            } catch (InterruptedException e) {
                break;
            }
        }
    }
}