package co.edu.poli.contexto2.vista;

import co.edu.poli.contexto2.model.*;
import co.edu.poli.contexto2.servicios.Implementacionoperacioncrud;
import co.edu.poli.contexto2.servicios.Operacioncrud;
import co.edu.poli.contexto2.model.Refrigerado;

public class Principal {

    public static void main(String[] args) {

        // Pruebas originales del contexto (sin modificar)
        Perecedero perecedero1 = new Perecedero("Leche", 2001, "05/03/2026", "Grande",
                20, 1500.0, "Bueno", "Cartón", true, 2.0, "Lácteos SA", 10, "Frío");

        NoPerecedero noPerecedero1 = new NoPerecedero("Arroz", 3001, "10/02/2024", "Grande",
                50, 45.99, "Bueno", "Bolsa", true, 25.5, "Diana", 2, "Bolsa hermética");

        Refrigerado refrigerado1 = new Refrigerado("Leche Refrigerada", 4001, "10/02/2026", "Mediano",
                20, 5.99, "Bueno", "Cartón", true, 1.2, "Alpina",
                15, "Frío seco", 4.0, "Refrigeración industrial");

        System.out.println(perecedero1.calcularDurabilidad(""));
        System.out.println(noPerecedero1.calcularDurabilidad(""));
        System.out.println(refrigerado1.calcularDurabilidad(""));

        //Método abstracto describir
        System.out.println("\n=== Prueba método abstracto describir() ===");
        System.out.println(perecedero1.describir());
        System.out.println(noPerecedero1.describir());
        System.out.println(refrigerado1.describir());

        //Atributo / método final / clase final
        System.out.println("\nCertificacion: " + perecedero1.MARCA_CERTIFICADA);
        System.out.println(perecedero1.obtenerInfo());
        certificado cert = new certificado("CRT-001");
        System.out.println(cert);

        // Variable estática
        System.out.println("\nMoneda inicial: " + Alimento.tipoMoneda);
        Alimento.tipoMoneda = "USD";
        System.out.println("Moneda actualizada: " + Alimento.tipoMoneda);

        //PRUEBAS CRUD
        System.out.println("║        PRUEBAS OPERACIONES CRUD       ║");

        Operacioncrud crud = new Implementacionoperacioncrud();

        //CREAR: casos validos
        System.out.println("\n--- CREAR ---");

        // Posicion 0 del arreglo fijo
        Perecedero yogur = new Perecedero("Yogur", 5001, "20/03/2026", "Pequeño",
                15, 2500.0, "Bueno", "Vaso", true, 0.5, "Colanta", 5, "Refrigeración");
        System.out.println(crud.crear(yogur));

        // Posicion 1 del arreglo fijo
        NoPerecedero pasta = new NoPerecedero("Pasta", 5002, "01/01/2027", "Grande",
                100, 3500.0, "Bueno", "Bolsa", false, 0.5, "Doria", 3, "Empaque al vacío");
        System.out.println(crud.crear(pasta));

        // Arreglo lleno -> pasa al almacen adicional
        Refrigerado mantequilla = new Refrigerado("Mantequilla", 5003, "15/04/2026", "Pequeño",
                10, 4000.0, "Bueno", "Caja", true, 0.25, "Alpina",
                20, "Frío seco", 2.0, "Refrigeración industrial");
        System.out.println(crud.crear(mantequilla));

        // Almacen adicional (segundo elemento extra)
        NoPerecedero avena = new NoPerecedero("Avena", 5004, "01/06/2027", "Grande",
                50, 2000.0, "Bueno", "Bolsa", false, 1.0, "Quaker", 2, "Empaque hermético");
        System.out.println(crud.crear(avena));

        //CREAR: validaciones de error
        System.out.println("\n--- CREAR: validaciones ---");
        System.out.println(crud.crear(null));                              // nulo
        System.out.println(crud.crear(yogur));                             // código duplicado
        Perecedero sinNombre = new Perecedero("", -1, "", "", 0, -5, "", "", false, 0, "", 0, "");
        System.out.println(crud.crear(sinNombre));                         // código inválido

        //LISTAR despues de crear
        System.out.println("\n--- LISTAR (tras crear) ---");
        System.out.println(crud.listar());

        //CONSULTAR: casos validos
        System.out.println("\n--- CONSULTAR ---");
        Alimento encontrado1 = crud.consultar(5001);
        System.out.println("Consulta 5001: " + (encontrado1 != null ? encontrado1.describir() : "null"));

        Alimento encontrado2 = crud.consultar(5003);   // en almacén adicional
        System.out.println("Consulta 5003: " + (encontrado2 != null ? encontrado2.describir() : "null"));

        //CONSULTAR: errores
        System.out.println("\n--- CONSULTAR: validaciones ---");
        Alimento noExiste = crud.consultar(9999);
        System.out.println("Consulta 9999: " + noExiste);

        Alimento idInvalido = crud.consultar(-1);
        System.out.println("Consulta id=-1: " + idInvalido);

        //MODIFICAR: caso valido
        System.out.println("\n--- MODIFICAR ---");
        Perecedero yogurActualizado = new Perecedero("Yogur LIGHT", 5001, "01/04/2026", "Pequeño",
                20, 2800.0, "Excelente", "Vaso", true, 0.5, "Colanta", 7, "Refrigeración");
        System.out.println(crud.modificar(5001, yogurActualizado));

        //Modificar en almacen adicional
        Refrigerado mantequillaBio = new Refrigerado("Mantequilla Bio", 5003, "20/04/2026", "Pequeño",
                10, 4500.0, "Excelente", "Caja", true, 0.25, "Organic",
                25, "Frío seco", 1.5, "Refrigeración industrial");
        System.out.println(crud.modificar(5003, mantequillaBio));

        // MODIFICAR: validaciones de error
        System.out.println("\n--- MODIFICAR: validaciones ---");
        System.out.println(crud.modificar(9999, yogurActualizado));   // no existe
        System.out.println(crud.modificar(5001, null));               // nuevo nulo
        System.out.println(crud.modificar(-5, yogurActualizado));     // id inválido

        //LISTAR tras modificar
        System.out.println("\n--- LISTAR (tras modificar) ---");
        System.out.println(crud.listar());

        //ELIMINAR: caso valido del arreglo
        System.out.println("\n--- ELIMINAR ---");
        System.out.println(crud.eliminar(5001));   // arreglo posición 0

        // Eliminar del almacén adicional
        System.out.println(crud.eliminar(5003));

        //ELIMINAR: validaciones de error
        System.out.println("\n--- ELIMINAR: validaciones ---");
        System.out.println(crud.eliminar(5001));   // ya fue eliminado
        System.out.println(crud.eliminar(-3));     // id invalido

        //LISTAR final
        System.out.println("\n--- LISTAR (estado final) ---");
        System.out.println(crud.listar());

        //Reinsertar en el hueco que quedo
        System.out.println("\n--- CREAR en hueco liberado ---");
        Refrigerado jugo = new Refrigerado("Jugo de Naranja", 6001, "01/04/2026", "Mediano",
                25, 6.99, "Fresco", "Botella", true, 1.0, "Jugos SA",
                7, "Frío húmedo", 3.5, "Refrigeración industrial");
        System.out.println(crud.crear(jugo));      // debe ocupar la posicion 0

        System.out.println("\n--- LISTAR (con hueco rellenado) ---");
        System.out.println(crud.listar());
    }
}