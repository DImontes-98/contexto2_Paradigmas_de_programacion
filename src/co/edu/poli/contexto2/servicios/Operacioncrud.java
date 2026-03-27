package co.edu.poli.contexto2.servicios;

import co.edu.poli.contexto2.model.Alimento;

/*Interfaz que define las operaciones crud sobre objetos de tipo Alimento (super super clase).
 */
public interface Operacioncrud {

    /* Inserta el alimento en el primer null del arreglo base (tamaño 2).
     Si el arreglo está lleno, lo agrega al almacén adicional (ArrayList infinito).
     */
    String crear(Alimento alimento);

    /* Busca y retorna el alimento cuyo codigo coincida con el id recibido.
      Busca primero en el arreglo base y luego en el almacén adicional.
     */
    Alimento consultar(int id);
    /* Reemplaza los datos del alimento con el codigo=id por los del nuevo objeto. Busca en el arreglo base y luego en el almacén adicional.
     */
    String modificar(int id, Alimento nuevoAlimento);

    /* Elimina (pone en null o elimina de la lista) el alimento cuyo codigo=id.
     */
    String eliminar(int id);

    /*Lista todos los alimentos almacenados (arreglo + almacén adicional).
     */
    String listar();
}