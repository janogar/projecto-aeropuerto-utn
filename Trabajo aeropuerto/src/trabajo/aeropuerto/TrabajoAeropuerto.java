/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajo.aeropuerto;

import java.util.Scanner;
import java.util.Locale;


/**
 *
 * @author garci
 */
public class TrabajoAeropuerto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in); // escaner de entrada de teclado
        sc.useLocale(Locale.US); // fuerza a usar punto como separador decimal
        
        double costoBase;
        int diasIncluidos;
        double costoDiaExtra;
        int actividadesIncluidas;
        double costoActividadExtra;
        
        
        double calcularCostoPorExtra(int cantidadDeseada, int cantidadIncluida, double costoPorUnidadExtra);

        // Calculo del costo por extra
        if (cantidadDeseada <= cantidadIncluida){
            calcularCostoPorExtra = 0;
        }
        else if (cantidadDeseada > cantidadIncluida) {
           calcularCostoPorExtra = (cantidadDeseada - cantidadIncluida) * costoPorUnidadExtra;
        }
        
         
        
    }
    
}
