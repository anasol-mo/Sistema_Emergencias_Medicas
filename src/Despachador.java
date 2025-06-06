package src;

public class Despachador implements Runnable {

    private final SistemaEmergencias sistema;

    public Despachador(SistemaEmergencias sistema) {
        this.sistema = sistema;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Obtener la siguiente emergencia en orden de prioridad
                Emergencia emergencia = sistema.obtenerSiguienteEmergencia();

                long inicioAtencion = System.currentTimeMillis();
                boolean esperoAmbulancia = false;
                Ambulancia ambulancia = null;

                // Esperar hasta encontrar una ambulancia disponible
                while (ambulancia == null) {
                    ambulancia = sistema.asignarAmbulanciaDisponible();
                    if (ambulancia == null) {
                        esperoAmbulancia = true;
                        System.out.println("[Despachador] Esperando ambulancia para emergencia #" + emergencia.getId());
                        Thread.sleep(1000); // espera 1 segundo antes de reintentar
                    }
                }

                System.out.println("[Despachador] Emergencia #" + emergencia.getId() + " atendida por " + ambulancia);

                // Simula el tiempo que toma atender la emergencia (5 segundos)
                Thread.sleep(5000);

                // Liberar la ambulancia después de la atención
                sistema.liberarAmbulancia(ambulancia);

                long finAtencion = System.currentTimeMillis();

                // Registrar estadísticas de la atención
                sistema.getEstadisticas().registrarAtencion(finAtencion - inicioAtencion, esperoAmbulancia);

                System.out.println("[Despachador] Ambulancia #" + ambulancia.getId() + " disponible nuevamente.");

            } catch (InterruptedException e) {
                System.out.println("[Despachador] Hilo interrumpido.");
                break;
            }
        }
    }
}