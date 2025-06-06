package src;
import java.util.List;

public class MonitorSistema implements Runnable {

    private final SistemaEmergencias sistema;

    public MonitorSistema(SistemaEmergencias sistema) {
        this.sistema = sistema;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(4000); // cada 4 segundos imprime el estado

                System.out.println("\n========== ESTADO DEL SISTEMA ==========");
                System.out.println("🆘 Emergencias pendientes: " + sistema.obtenerCantidadPendientes());

                List<Ambulancia> ambulancias = sistema.getAmbulancias();
                for (Ambulancia amb : ambulancias) {
                    System.out.println("🚑 " + amb);
                }

                System.out.println("========================================\n");

                EstadisticasSistema est = sistema.getEstadisticas();
                System.out.println("📊 Total emergencias atendidas: " + est.getTotalAtendidas());
                System.out.printf("⏱️ Tiempo promedio de atención: %.2f seg\n", est.getPromedioAtencion());
                System.out.println("🚨 Casos sin ambulancia inmediata: " + est.getCasosSinAmbulanciaInmediata());

            } catch (InterruptedException e) {
                System.out.println("[Monitor] Hilo interrumpido.");
                break;
            }
        }
    }
}