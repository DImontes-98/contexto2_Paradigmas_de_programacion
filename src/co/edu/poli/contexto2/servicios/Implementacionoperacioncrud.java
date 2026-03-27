package co.edu.poli.contexto2.servicios;

import co.edu.poli.contexto2.model.Alimento;
import java.util.ArrayList;

/* Implementación de OperacionCRUD.
 Estructura de almacenamiento:
 *   - alimentos[2]: arreglo fijo de tamaño 2
 *   - almacen: ArrayList que crece infinitamente cuando el arreglo esta lleno
Todas las búsquedas (consultar / modificar / eliminar) se hacen por codigo (int).
 */
public class Implementacionoperacioncrud implements Operacioncrud {

    private Alimento[] alimentos;           // arreglo de tamaño 2
    private ArrayList<Alimento> almacen;    // desbordamiento / crecimiento infinito

    public Implementacionoperacioncrud() {
        alimentos = new Alimento[2];
        almacen   = new ArrayList<>();
    }

    //CREAR 
    @Override
    public String crear(Alimento alimento) {
        // Validaciones previas
        if (alimento == null) {
            return "ERROR: No se puede insertar un alimento nulo.";
        }
        if (alimento.getCodigo() <= 0) {
            return "ERROR: El codigo del alimento debe ser mayor que 0.";
        }
        if (alimento.getNombre() == null || alimento.getNombre().trim().isEmpty()) {
            return "ERROR: El nombre del alimento no puede estar vacío.";
        }
        if (alimento.getCosto() < 0) {
            return "ERROR: El costo no puede ser negativo.";
        }
        if (duplicado(alimento.getCodigo())) {
            return "ERROR: Ya existe un alimento con codigo " + alimento.getCodigo();
        }

        // Buscar el primer null en el arreglo fijo (de izquierda a derecha)
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] == null) {
                alimentos[i] = alimento;
                return "OK: Alimento '" + alimento.getNombre() +
                       "' insertado en posición " + i + " del arreglo.";
            }
        }

        // Arreglo lleno -> se agrega al almacen adicional (ArrayList ilimitado)
        almacen.add(alimento);
        return "OK: Arreglo lleno. Alimento '" + alimento.getNombre() +
               "' agregado al almacén adicional (posición " +
               (almacen.size() - 1) + ").";
    }

    //CONSULTAR
    @Override
    public Alimento consultar(int id) {
        if (id <= 0) {
            System.out.println("ERROR consultar: El id debe ser mayor que 0.");
            return null;
        }

        // Buscar en arreglo fijo
        for (Alimento a : alimentos) {
            if (a != null && a.getCodigo() == id) return a;
        }

        // Buscar en almacen adicional
        for (Alimento a : almacen) {
            if (a != null && a.getCodigo() == id) return a;
        }

        System.out.println("ERROR consultar: No existe alimento con codigo " + id);
        return null;
    }

    // MODIFICAR
    @Override
    public String modificar(int id, Alimento nuevoAlimento) {
        if (id <= 0) {
            return "ERROR modificar: El id debe ser mayor que 0.";
        }
        if (nuevoAlimento == null) {
            return "ERROR modificar: El nuevo alimento no puede ser nulo.";
        }
        if (nuevoAlimento.getNombre() == null || nuevoAlimento.getNombre().trim().isEmpty()) {
            return "ERROR modificar: El nombre del nuevo alimento no puede estar vacío.";
        }
        if (nuevoAlimento.getCosto() < 0) {
            return "ERROR modificar: El costo no puede ser negativo.";
        }

        // Modificar en arreglo fijo
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] != null && alimentos[i].getCodigo() == id) {
                alimentos[i] = nuevoAlimento;
                return "OK: Alimento con codigo " + id + " modificado en posición " + i + " del arreglo.";
            }
        }

        // Modificar en almacén adicional
        for (int i = 0; i < almacen.size(); i++) {
            if (almacen.get(i) != null && almacen.get(i).getCodigo() == id) {
                almacen.set(i, nuevoAlimento);
                return "OK: Alimento con codigo " + id + " modificado en almacén adicional (posición " + i + ").";
            }
        }

        return "ERROR modificar: No existe alimento con codigo " + id;
    }

    //ELIMINAR
    @Override
    public String eliminar(int id) {
        if (id <= 0) {
            return "ERROR eliminar: El id debe ser mayor que 0.";
        }

        // Eliminar en arreglo fijo (se pone null para liberar la posición)
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] != null && alimentos[i].getCodigo() == id) {
                String nombre = alimentos[i].getNombre();
                alimentos[i] = null;
                return "OK: Alimento '" + nombre + "' (codigo=" + id +
                       ") eliminado de posición " + i + " del arreglo.";
            }
        }

        // Eliminar en almacén adicional
        for (int i = 0; i < almacen.size(); i++) {
            if (almacen.get(i) != null && almacen.get(i).getCodigo() == id) {
                String nombre = almacen.get(i).getNombre();
                almacen.remove(i);
                return "OK: Alimento '" + nombre + "' (codigo=" + id +
                       ") eliminado del almacén adicional.";
            }
        }

        return "ERROR eliminar: No existe alimento con codigo " + id;
    }

    // LISTAR 
    @Override
    public String listar() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== LISTADO DE ALIMENTOS ===\n");
        sb.append("-- Arreglo fijo (capacidad 2) --\n");

        boolean hayAlgo = false;
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] != null) {
                sb.append("  [").append(i).append("] ")
                  .append(alimentos[i].describir()).append("\n");
                hayAlgo = true;
            } else {
                sb.append("  [").append(i).append("] (vacío)\n");
            }
        }

        if (!almacen.isEmpty()) {
            sb.append("-- Almacén adicional (").append(almacen.size()).append(" elementos) --\n");
            for (int i = 0; i < almacen.size(); i++) {
                sb.append("  [").append(i).append("] ")
                  .append(almacen.get(i).describir()).append("\n");
            }
            hayAlgo = true;
        }

        if (!hayAlgo && almacen.isEmpty()) {
            sb.append("  (sin alimentos registrados)\n");
        }

        sb.append("============================");
        return sb.toString();
    }

    //Utilidad privada 
    private boolean duplicado(int id) {
        for (Alimento a : alimentos) {
            if (a != null && a.getCodigo() == id) return true;
        }
        for (Alimento a : almacen) {
            if (a != null && a.getCodigo() == id) return true;
        }
        return false;
    }
}