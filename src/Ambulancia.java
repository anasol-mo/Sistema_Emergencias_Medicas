package src;
public class Ambulancia {
    private final int id;
    private boolean disponible;
    private boolean enFallo;

    public Ambulancia(int id) {
        this.id = id;
        this.disponible = true;
        this.enFallo = false;
    }

    public synchronized boolean asignar() {
        if (disponible && !enFallo) {
            disponible = false;
            return true;
        }
        return false;
    }

    public synchronized void liberar() {
        disponible = true;
    }

    public synchronized boolean estaDisponible() {
        return disponible && !enFallo;
    }

    public synchronized boolean estaEnFallo() {
        return enFallo;
    }

    public synchronized void marcarFallo() {
        enFallo = true;
        disponible = false;
    }

    public synchronized void recuperar() {
        enFallo = false;
        disponible = true;
    }

    public int getId() {
        return id;
    }

    @Override
    public synchronized String toString() {
        if (enFallo) {
            return "Ambulancia #" + id + " [EN FALLO]";
        } else {
            return "Ambulancia #" + id + " [" + (disponible ? "Disponible" : "Ocupada") + "]";
        }
    }
}