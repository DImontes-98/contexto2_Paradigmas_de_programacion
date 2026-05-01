package co.edu.poli.contexto2.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.poli.contexto2.model.Alimento;

public class Implementacionoperacioncrud implements Operacioncrud {

    private Alimento[] alimentos;

    public Implementacionoperacioncrud() {
        alimentos = new Alimento[2];
    }

    @Override
    public String crear(Alimento alimento) {
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

        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] == null) {
                alimentos[i] = alimento;
                return "OK: Alimento '" + alimento.getNombre() +
                       "' insertado en posición " + i + " del arreglo.";
            }
        }

        // Arreglo lleno: duplicar capacidad
        Alimento[] nuevo = new Alimento[alimentos.length * 2];
        for (int i = 0; i < alimentos.length; i++) {
            nuevo[i] = alimentos[i];
        }
        alimentos = nuevo;

        // Insertar en el nuevo espacio
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] == null) {
                alimentos[i] = alimento;
                return "OK: Alimento '" + alimento.getNombre() +
                       "' insertado. Arreglo duplicado a capacidad " + alimentos.length;
            }
        }

        return "ERROR: No se pudo insertar.";
    }

    @Override
    public Alimento consultar(int id) {
        if (id <= 0) {
            System.out.println("ERROR consultar: El id debe ser mayor que 0.");
            return null;
        }

        for (Alimento a : alimentos) {
            if (a != null && a.getCodigo() == id) return a;
        }

        System.out.println("ERROR consultar: No existe alimento con codigo " + id);
        return null;
    }

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

        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] != null && alimentos[i].getCodigo() == id) {
                alimentos[i] = nuevoAlimento;
                return "OK: Alimento con codigo " + id + " modificado en posición " + i + " del arreglo.";
            }
        }

        return "ERROR modificar: No existe alimento con codigo " + id;
    }

    @Override
    public String eliminar(int id) {
        if (id <= 0) {
            return "ERROR eliminar: El id debe ser mayor que 0.";
        }

        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] != null && alimentos[i].getCodigo() == id) {
                String nombre = alimentos[i].getNombre();
                alimentos[i] = null;
                return "OK: Alimento '" + nombre + "' (codigo=" + id +
                       ") eliminado de posición " + i + " del arreglo.";
            }
        }

        return "ERROR eliminar: No existe alimento con codigo " + id;
    }

    @Override
    public String listar() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== LISTADO DE ALIMENTOS ===\n");
        sb.append("-- Arreglo (capacidad " + alimentos.length + ") --\n");

        boolean hayAlgo = false;
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] != null) {
                sb.append("  [").append(i).append("] ")
                  .append(alimentos[i].describir()).append("\n");
                hayAlgo = true;
            }
        }

        if (!hayAlgo) {
            sb.append("  (sin alimentos registrados)\n");
        }

        sb.append("============================");
        return sb.toString();
    }

    private boolean duplicado(int id) {
        for (Alimento a : alimentos) {
            if (a != null && a.getCodigo() == id) return true;
        }
        return false;
    }

    public String serializar(String path, String name) throws IOException {
        FileOutputStream fos = new FileOutputStream(path + name);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(alimentos);
        oos.close();
        fos.close();
        return "File create!!";
    }

    public Alimento[] deserializar(String path, String name) throws IOException, ClassNotFoundException {
        Alimento[] a = null;
        FileInputStream fis = new FileInputStream(path + name);
        ObjectInputStream ois = new ObjectInputStream(fis);
        a = (Alimento[]) ois.readObject();
        ois.close();
        fis.close();
        alimentos = a;
        return a;
    }

    public Alimento[] getAlimentos() {
        return alimentos;
    }
}