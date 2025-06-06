package src;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Emergencia {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    public enum Gravedad {
        CRITICO, GRAVE, MODERADO, LEVE
    }

    private final int id;
    private final String descripcion;
    private final String ubicacion;
    private final Gravedad gravedad;
    private final LocalDateTime horaReporte;

    public Emergencia(String descripcion, String ubicacion, Gravedad gravedad) {
        this.id = idGenerator.getAndIncrement();
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.gravedad = gravedad;
        this.horaReporte = LocalDateTime.now();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Gravedad getGravedad() {
        return gravedad;
    }

    public LocalDateTime getHoraReporte() {
        return horaReporte;
    }

    @Override
    public String toString() {
        return "Emergencia #" + id + " [" + gravedad + "] en " + ubicacion +
                " (" + descripcion + ") a las " + horaReporte;
    }
}