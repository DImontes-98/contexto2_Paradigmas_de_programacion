package co.edu.poli.contexto2.servicios;

import co.edu.poli.contexto2.model.Alimento;

/**
 * Interfaz que define las operaciones CRUD sobre objetos de tipo {@code Alimento}.
 * <p>
 * Establece el contrato de comportamiento para crear, consultar, modificar,
 * eliminar y listar alimentos dentro del sistema de gestión de inventario.
 * </p>
 *
 * <p>La implementación utiliza un arreglo base de tamaño 2 como almacenamiento
 * primario.</p>
 */
public interface Operacioncrud {

    String crear(Alimento alimento);

    Alimento consultar(int id);

    String modificar(int id, Alimento nuevoAlimento);

    /**
     * Elimina el alimento cuyo {@code codigo} sea igual a {@code id}.
     *
     * @param id código identificador del alimento
     * @return mensaje indicando el resultado
     */
    String eliminar(int id);

    /**
     * Lista todos los alimentos almacenados.
     *
     * @return listado de alimentos en formato {@code String}
     */
    String listar();
}