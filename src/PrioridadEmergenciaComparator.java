package src;
import java.util.Comparator;

public class PrioridadEmergenciaComparator implements Comparator<Emergencia> {

    @Override
    public int compare(Emergencia e1, Emergencia e2) {
        // 1. Prioridad por gravedad (ordinal menor = más grave)
        int gravedadComp = Integer.compare(e1.getGravedad().ordinal(), e2.getGravedad().ordinal());
        if (gravedadComp != 0) return gravedadComp;

        // 2. Luego por antigüedad (más antiguo primero)
        int horaComp = e1.getHoraReporte().compareTo(e2.getHoraReporte());
        if (horaComp != 0) return horaComp;

        // 3. Finalmente por ubicación (definimos prioridad por zonas)
        return getPrioridadZona(e1.getUbicacion()) - getPrioridadZona(e2.getUbicacion());
    }

    private int getPrioridadZona(String zona) {
        zona = zona.toLowerCase();
        switch (zona) {
            case "centro": return 0;
            case "norte": return 1;
            case "sur": return 2;
            case "este": return 3;
            case "oeste": return 4;
            default: return 5;
        }
    }
}