package src;
public class EstadisticasSistema {
    private int totalEmergenciasAtendidas = 0;
    private long tiempoTotalAtencionMs = 0;
    private int casosSinAmbulanciaInmediata = 0;

    public synchronized void registrarAtencion(long tiempoAtencionMs, boolean esperoAmbulancia) {
        totalEmergenciasAtendidas++;
        tiempoTotalAtencionMs += tiempoAtencionMs;
        if (esperoAmbulancia) {
            casosSinAmbulanciaInmediata++;
        }
    }

    public synchronized int getTotalAtendidas() {
        return totalEmergenciasAtendidas;
    }

    public synchronized double getPromedioAtencion() {
        if (totalEmergenciasAtendidas == 0) return 0;
        return tiempoTotalAtencionMs / (double) totalEmergenciasAtendidas / 1000.0;
    }

    public synchronized int getCasosSinAmbulanciaInmediata() {
        return casosSinAmbulanciaInmediata;
    }
}