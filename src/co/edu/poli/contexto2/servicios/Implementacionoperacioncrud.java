package co.edu.poli.contexto2.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.poli.contexto2.model.Alimento;

/*
 * Implementación de OperacionCRUD.
 * Estructura de almacenamiento:
 *   - alimentos[2]: arreglo fijo de tamaño 2
 * Todas las búsquedas (consultar / modificar / eliminar) se hacen por codigo (int).
 */
/**
 * Implementación de la interfaz {@code Operacioncrud} para la gestión de
 * objetos {@code Alimento} mediante un arreglo fijo de capacidad 2.
 * <p>
 * Utiliza únicamente el arreglo base como estructura de almacenamiento.
 * Si el arreglo está lleno al intentar insertar, la operación retorna un
 * mensaje de error sin agregar el elemento.
 * </p>
 * <p>
 * Todas las búsquedas (consultar, modificar, eliminar) se realizan
 * por el campo {@code codigo} de tipo {@code int}.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Implementacionoperacioncrud crud = new Implementacionoperacioncrud();
 * crud.crear(new Perecedero(...));
 * System.out.println(crud.listar());
 * }</pre>
 */
public class Implementacionoperacioncrud implements Operacioncrud {

    /** Arreglo fijo de tamaño 2 para almacenar los alimentos. */
    private Alimento[] alimentos;

    /**
     * Crea una nueva instancia de {@code Implementacionoperacioncrud}
     * e inicializa el arreglo de alimentos con capacidad 2.
     */
    public Implementacionoperacioncrud() {
        alimentos = new Alimento[2];
    }

    // CREAR
    /**
     * Inserta el alimento en el primer espacio disponible ({@code null})
     * del arreglo fijo de tamaño 2.
     * <p>
     * Realiza las siguientes validaciones antes de insertar:
     * el alimento no puede ser nulo, el código debe ser mayor que 0,
     * el nombre no puede estar vacío, el costo no puede ser negativo,
     * y no puede existir ya un alimento con el mismo código.
     * </p>
     * <p>
     * Si el arreglo está lleno, retorna un mensaje de error.
     * </p>
     *
     * @param alimento objeto {@code Alimento} a insertar
     * @return mensaje indicando el resultado de la operación como {@code String}
     */
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

        return "ERROR: Arreglo lleno. No se puede insertar el alimento '" +
               alimento.getNombre() + "'.";
    }

    // CONSULTAR
    /**
     * Busca y retorna el alimento cuyo {@code codigo} coincida con el {@code id} recibido.
     * <p>
     * La búsqueda se realiza únicamente en el arreglo fijo.
     * Si el {@code id} es menor o igual a 0, imprime un mensaje de error y retorna {@code null}.
     * </p>
     *
     * @param id código identificador del alimento a consultar; debe ser mayor que 0
     * @return el objeto {@code Alimento} encontrado, o {@code null} si no existe
     */
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

    // MODIFICAR
    /**
     * Reemplaza el alimento con {@code codigo} igual a {@code id} por el nuevo objeto.
     * <p>
     * Realiza validaciones sobre el {@code id} y el {@code nuevoAlimento} antes de modificar.
     * La búsqueda se realiza únicamente en el arreglo fijo.
     * </p>
     *
     * @param id            código identificador del alimento a modificar; debe ser mayor que 0
     * @param nuevoAlimento nuevo objeto {@code Alimento} con los datos actualizados
     * @return mensaje indicando el resultado de la operación como {@code String}
     */
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

    // ELIMINAR
    /**
     * Elimina el alimento cuyo {@code codigo} sea igual a {@code id},
     * estableciendo su posición en {@code null} para liberar el espacio.
     * <p>
     * La búsqueda se realiza únicamente en el arreglo fijo.
     * </p>
     *
     * @param id código identificador del alimento a eliminar; debe ser mayor que 0
     * @return mensaje indicando el resultado de la operación como {@code String}
     */
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

    // LISTAR
    /**
     * Genera y retorna un listado de todos los alimentos almacenados
     * en el arreglo fijo de tamaño 2.
     * <p>
     * Muestra cada posición del arreglo, indicando si está vacía o mostrando
     * la descripción del alimento mediante su método {@code describir()}.
     * </p>
     *
     * @return cadena con el listado completo de alimentos como {@code String}
     */
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

        if (!hayAlgo) {
            sb.append("  (sin alimentos registrados)\n");
        }

        sb.append("============================");
        return sb.toString();
    }

    /**
     * Verifica si ya existe un alimento con el código especificado en el arreglo fijo.
     *
     * @param id código a verificar
     * @return {@code true} si ya existe un alimento con ese código, {@code false} en caso contrario
     */
    // Utilidad privada
    private boolean duplicado(int id) {
        for (Alimento a : alimentos) {
            if (a != null && a.getCodigo() == id) return true;
        }
        return false;
    }
    
    //aca empieza serializar y deserealizar
    public String serializar(String path, String name) {
        try {
            FileOutputStream fos = new FileOutputStream(path + name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(alimentos); // mi arreglo
            oos.close();
            fos.close();
            return "File create!!";
        } catch (IOException ioe) {
            return "Error file " + ioe.getMessage();
        }
    }

    /*
     * Deserializa un arreglo de alimentos desde un archivo binario en la ruta especificada.
     *
     * @param path Ruta del directorio donde se encuentra el archivo.
     * @param name Nombre del archivo a deserializar.
     * @return Arreglo de objetos {@link Alimento} recuperados desde el archivo,
     *         o {@code null} si ocurre un error durante la lectura.
     */
    public Alimento[] deserializar(String path, String name) {
        Alimento[] a = null;
        try {
            FileInputStream fis = new FileInputStream(path + name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            a = (Alimento[]) ois.readObject(); // leer el arreglo
            ois.close();
            fis.close();

            alimentos = a; // nueva linea
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } catch (ClassNotFoundException c) {
            System.err.println(c.getMessage());
        }
        return a;
    }
}