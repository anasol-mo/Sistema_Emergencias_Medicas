package src;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;

public class SistemaEmergencias {

    private final PriorityBlockingQueue<Emergencia> colaEmergencias;
    private final List<Ambulancia> ambulancias;
    private final EstadisticasSistema estadisticas;

    // Observadores (patrón Observer)
    private final CopyOnWriteArrayList<EmergenciaListener> listeners = new CopyOnWriteArrayList<>();

    public SistemaEmergencias() {
        // Cola de emergencias con prioridad (gravedad, tiempo, ubicación)
        colaEmergencias = new PriorityBlockingQueue<>(10, new PrioridadEmergenciaComparator());

        // Crear ambulancias simuladas (3 por defecto)
        ambulancias = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ambulancias.add(new Ambulancia(i));
        }

        estadisticas = new EstadisticasSistema();
    }

    // Agregar una emergencia nueva y notificar a los observadores
    public void reportarEmergencia(Emergencia emergencia) {
        colaEmergencias.offer(emergencia);
        System.out.println("[Sistema] Reportada nueva emergencia: " + emergencia);

        // Notificar a observadores registrados
        for (EmergenciaListener listener : listeners) {
            listener.onNuevaEmergencia(emergencia);
        }
    }

    // Obtener la siguiente emergencia según prioridad
    public Emergencia obtenerSiguienteEmergencia() throws InterruptedException {
        return colaEmergencias.take(); // bloquea si está vacía
    }

    // Asignar una ambulancia disponible (bloqueo sincronizado)
    public Ambulancia asignarAmbulanciaDisponible() {
        synchronized (ambulancias) {
            for (Ambulancia amb : ambulancias) {
                if (amb.asignar()) {
                    return amb;
                }
            }
        }
        return null; // si ninguna está disponible
    }

    // Liberar una ambulancia después de la atención
    public void liberarAmbulancia(Ambulancia ambulancia) {
        ambulancia.liberar();
    }

    // Obtener estadísticas
    public EstadisticasSistema getEstadisticas() {
        return estadisticas;
    }

    // Obtener cantidad de emergencias pendientes
    public int obtenerCantidadPendientes() {
        return colaEmergencias.size();
    }

    // Obtener la lista de ambulancias (monitor y simulador de fallos)
    public List<Ambulancia> getAmbulancias() {
        return ambulancias;
    }

    // Registrar observadores (ej. monitor)
    public void agregarListener(EmergenciaListener listener) {
        listeners.add(listener);
    }
}