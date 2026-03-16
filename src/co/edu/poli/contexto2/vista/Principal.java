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
    }
}