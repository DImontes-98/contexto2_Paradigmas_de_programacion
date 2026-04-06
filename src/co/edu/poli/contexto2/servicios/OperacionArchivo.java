package co.edu.poli.contexto2.servicios;

import co.edu.poli.contexto2.model.Alimento;

/**
 * Interfaz que define las operaciones de persistencia de objetos {@code Alimento}
 * mediante serialización y deserialización en archivos del sistema.
 * <p>
 * Permite guardar y recuperar arreglos de alimentos desde rutas específicas
 * del sistema de archivos, facilitando la persistencia de datos entre sesiones.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * OperacionArchivo op = new ImplementacionArchivo();
 * op.serializar(alimentos, "/datos", "inventario");
 * Alimento[] recuperados = op.deserializar("/datos", "inventario");
 * }</pre>
 */
public interface OperacionArchivo {

    /**
     * Serializa un arreglo de objetos {@code Alimento} y los guarda en un archivo
     * en la ruta y con el nombre especificados.
     *
     * @param estudiantes arreglo de {@code Alimento} a serializar y guardar
     * @param path        ruta del directorio donde se almacenará el archivo
     * @param name        nombre del archivo de destino (sin extensión)
     * @return mensaje indicando el resultado de la operación como {@code String}
     */
    public String serializar(Alimento[] estudiantes, String path, String name);

    /**
     * Deserializa y recupera un arreglo de objetos {@code Alimento} desde un archivo
     * ubicado en la ruta y con el nombre especificados.
     *
     * @param path ruta del directorio donde se encuentra el archivo
     * @param name nombre del archivo a leer (sin extensión)
     * @return arreglo de {@code Alimento} recuperado del archivo,
     *         o {@code null} si ocurre un error durante la lectura
     */
    public Alimento[] deserializar(String path, String name);
}