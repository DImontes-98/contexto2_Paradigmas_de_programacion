package co.edu.poli.contexto2.vista;

import co.edu.poli.contexto2.model.*;
import co.edu.poli.contexto2.servicios.Refrigerado;

public class Principal {
    public static void main(String[] args) {

     
        Alimento alimentoBase = new Alimento("Manzana", 1001, "01/03/2026", "Mediano",
                                             10, 200.0, "Fresco", "Caja", true, 1.5, "Frutera X");

        Perecedero perecedero1 = new Perecedero("Leche", 2001, "05/03/2026", "Grande",
                                                20, 1500.0, "Bueno", "Cartón",
                                                true, 2.0, "Lácteos SA",
                                                10, "Frío");

        NoPerecedero noPerecedero1 = new NoPerecedero("Arroz", 3001, "10/02/2024", "Grande",
                                                      50, 45.99, "Bueno", "Bolsa",
                                                      true, 25.5, "Diana",
                                                      2, "Bolsa hermética");

        Refrigerado refrigerado1 = new Refrigerado("Leche Refrigerada", 4001, "10/02/2026", "Mediano",
                                                   20, 5.99, "Bueno", "Cartón",
                                                   true, 1.2, "Alpina",
                                                   15, "Frío seco",
                                                   4.0, "Refrigeración industrial");

        System.out.println(perecedero1.calcularDurabilidad(""));   
        System.out.println(noPerecedero1.calcularDurabilidad("")); 
        System.out.println(refrigerado1.calcularDurabilidad("")); 
       
        
        
        NoPerecedero arrozExtra = new NoPerecedero("Arroz Integral", 3002, "12/03/2025", "Mediano",
                                                   30, 35.50, "Excelente", "Bolsa",
                                                   true, 20.0, "La Mejor",
                                                   3, "Bolsa Sellada");
        System.out.println(arrozExtra);

        
        Refrigerado jugoRefrigerado = new Refrigerado("Jugo de Naranja", 4002, "01/04/2026", "Mediano",
                                                      25, 6.99, "Fresco", "Botella",
                                                      true, 1.0, "Jugos SA",
                                                      7, "Frío húmedo",
                                                      3.5, "Refrigeración industrial");
        System.out.println(jugoRefrigerado);

        System.out.println("Moneda inicial: " + Alimento.tipoMoneda);

        Alimento.tipoMoneda = "USD"; 
        System.out.println("Moneda actualizada: " + Alimento.tipoMoneda);

     
        System.out.println("AlimentoBase ve: " + alimentoBase.tipoMoneda);
        System.out.println("NoPerecedero ve: " + noPerecedero1.tipoMoneda);
        System.out.println("Refrigerado ve: " + refrigerado1.tipoMoneda);

      
        Alimento[] alimentosRegistro1 = {perecedero1, noPerecedero1};
        Tripulante trip1 = new Tripulante("Daniel Idarraga", "12/05/2020", "T1", 1, "Activo", true, 75.5);
        Registro registro1 = new Registro("Registro Diario 1", "16/02/2026", "R001", 25, true, alimentosRegistro1, trip1);

        Alimento[] alimentosRegistro2 = {refrigerado1, arrozExtra};
        Tripulante trip2 = new Tripulante("Nicolas Vazquez", "08/09/2019", "T2", 1, "Activo", true, 62.0);
        Registro registro2 = new Registro("Registro Diario 2", "16/02/2026", "R002", 15, false, alimentosRegistro2, trip2);

        System.out.println(registro1);
        System.out.println(registro2);
        
     // 1. Arreglo de 5 posiciones
        Alimento[] arreglo = new Alimento[5];

        // objetos de subclase (3)
        arreglo[0] = new Perecedero("Yogur", 5001, "20/03/2026", "Pequeño",
                        15, 2500.0, "Bueno", "Vaso",
                        true, 0.5, "Colanta",
                        5, "Refrigeracion");

        arreglo[1] = new NoPerecedero("Pasta", 5002, "01/01/2027", "Grande",
                        100, 3500.0, "Bueno", "Bolsa",
                        false, 0.5, "Doria",
                        3, "Empaque al vacío");

        arreglo[2] = new Refrigerado("Mantequilla", 5003, "15/04/2026", "Pequeño",
                        10, 4000.0, "Bueno", "Caja",
                        true, 0.25, "Alpina",
                        20, "Frío seco",
                        2.0, "Refrigeracion industrial");

        // sobre escritura
        System.out.println("\nSobrescritura de metodos");
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                System.out.println("Posicion " + i + ": " + arreglo[i].calcularDurabilidad(""));
            } else {
                System.out.println("Posicion " + i + ": (vacia)");
            }
        }
     // Invocar recibir el parametro
        System.out.println("\n recibir un parametro");
        mostrarDurabilidad(new Perecedero("Yogur", 5001, "20/03/2026", "Pequeño",
                        15, 2500.0, "Bueno", "Vaso",
                        true, 0.5, "Colanta",
                        5, "Refrigeracion"));

        // Invocar para retornar supersuperclase
        System.out.println("\n retornar superclase");
        Alimento resultado = crearAlimento(2);
        System.out.println(resultado.calcularDurabilidad(""));
        
     // Cambio 1: Atributo final - no se puede cambiar su valor
        System.out.println("Certificacion: " + perecedero1.MARCA_CERTIFICADA);

        // cambio 2: Metodo final - no se puede sobrescribir
        System.out.println(perecedero1.obtenerInfo());

        // cambio 3: Clase final - no se puede heredar
        certificado cert = new certificado("CRT-001");
        System.out.println(cert);
    }
 // recibir un parametro
    public static void mostrarDurabilidad(Alimento a) {
        System.out.println("Durabilidad: " + a.calcularDurabilidad(""));
    }

    // retornar supersuperclase
    public static Alimento crearAlimento(int tipo) {
        if (tipo == 1) {
            return new Perecedero("Queso", 6001, "25/03/2026", "Pequeño	",
                    10, 3000.0, "Bueno", "Bolsa",
                    true, 0.3, "Alpina",
                    8, "Frío");
        } else if (tipo == 2) {
            return new NoPerecedero("Avena", 6002, "01/06/2027", "Grande",
                    50, 2000.0, "Bueno", "Bolsa",
                    false, 1.0, "Quaker",
                    2, "Empaque hermetico");
        } else {
            return new Refrigerado("Crema", 6003, "10/04/2026", "Pequeño",
                    5, 4500.0, "Bueno", "Caja",
                    true, 0.2, "Colanta",
                    10, "Frío humedo",
                    3.0, "Refrigeracion industrial");
        }
    }
}