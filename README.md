# 🏥 Simulador de Sistema de Gestión de Emergencias Médicas

Este proyecto simula un sistema concurrente de atención de emergencias médicas desarrollado en Java. El sistema responde a llamadas de emergencia, asigna recursos limitados (ambulancias), y maneja situaciones críticas como saturación de recursos y fallos temporales.

---

## 🚀 Características

- Procesamiento concurrente de emergencias con múltiples hilos (`Operador`, `Despachador`, `Monitor`).
- Priorización de emergencias por gravedad, antigüedad y ubicación.
- Gestión de recursos compartidos (ambulancias) con sincronización (`synchronized`).
- Simulación de fallos temporales en ambulancias y su recuperación automática.
- Comunicación entre subsistemas mediante patrón **Observer**.
- Estadísticas en tiempo real del estado del sistema.

---

## 🧩 Arquitectura del sistema

- `Main.java`: punto de entrada del sistema.
- `SistemaEmergencias.java`: gestión central de emergencias, ambulancias y observadores.
- `Emergencia.java`: representa un caso de emergencia con gravedad, ubicación y tiempo.
- `Ambulancia.java`: recurso compartido con control de estado y fallos.
- `Operador.java`: genera emergencias aleatorias.
- `Despachador.java`: asigna ambulancias disponibles según prioridad.
- `MonitorSistema.java`: imprime el estado del sistema y recibe notificaciones.
- `SimuladorFallas.java`: induce fallos y recuperaciones en ambulancias.
- `EstadisticasSistema.java`: registra métricas de rendimiento.
- `EmergenciaListener.java`: interfaz Observer.
- `PrioridadEmergenciaComparator.java`: define el orden de atención.

---

## ⚙️ Tecnologías utilizadas

- Java 8+ (recomendado Java 11 o superior)
- Concurrencia con `Thread`, `Runnable`, `PriorityBlockingQueue`
- Sincronización con `synchronized`
- Diseño basado en patrones: **Productor-Consumidor**, **Observer**

---
