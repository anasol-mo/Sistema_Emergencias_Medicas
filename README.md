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

- `Main.java`: Punto de entrada del sistema.
- `SistemaEmergencias.java`: Gestión central de emergencias, ambulancias y observadores.
- `Emergencia.java`: Representa un caso de emergencia con gravedad, ubicación y tiempo.
- `Ambulancia.java`: Recurso compartido con control de estado y fallos.
- `Operador.java`: Genera emergencias aleatorias.
- `Despachador.java`: Asigna ambulancias disponibles según prioridad.
- `MonitorSistema.java`: Imprime el estado del sistema y recibe notificaciones.
- `SimuladorFallas.java`: Induce fallos y recuperaciones en ambulancias.
- `EstadisticasSistema.java`: Registra métricas de rendimiento.
- `EmergenciaListener.java`: Interfaz Observer.
- `PrioridadEmergenciaComparator.java`: Define el orden de atención.

---

## ⚙️ Tecnologías utilizadas

- Concurrencia con `Thread`, `Runnable`, `PriorityBlockingQueue`
- Sincronización con `synchronized`
- Diseño basado en patrones: **Productor-Consumidor**, **Observer**

---
