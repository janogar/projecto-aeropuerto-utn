
package trabajo.aeropuerto;

import java.util.Scanner;
import java.util.Locale;


public class TrabajoAeropuerto {

    // función auxiliar
   static double calcularCostoPorExtra(int cantidadDeseada, int cantidadIncluida, double costoPorUnidadExtra) {
    // Cálculo del costo por extra
    if (cantidadDeseada <= cantidadIncluida) {
        return 0.0;
    } else {
        return (cantidadDeseada - cantidadIncluida) * costoPorUnidadExtra;
    }
}


        
        
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in); // escaner de entrada de teclado
        sc.useLocale(Locale.US); // fuerza a usar punto como separador decimal
        
        //creacion de variables 
        
        // 1. Duración deseada del viaje (días)
        int diasDeseados = sc.nextInt();

        // 2. Cantidad de actividades deseadas
        int actividadesDeseadas = sc.nextInt();

        // 3. Cantidad de paquetes a evaluar
        int N = sc.nextInt();

       double mejorCosto = Double.POSITIVE_INFINITY;
        int mejorIndice = 1; // índice 1-based
        for (int i = 1; i <= N; i++) {
            // 4. Lectura de cada paquete (en el orden indicado)
            double costoBase = sc.nextDouble();
            int diasIncluidos = sc.nextInt();
            double costoDiaExtra = sc.nextDouble();
            int actividadesIncluidas = sc.nextInt();
            double costoActividadExtra = sc.nextDouble();

            // Calcular extras
            double extraDias = calcularCostoPorExtra(diasDeseados, diasIncluidos, costoDiaExtra);
            double extraActividades = calcularCostoPorExtra(actividadesDeseadas, actividadesIncluidas, costoActividadExtra);

            // Costo total del paquete
            double costoTotal = costoBase + extraDias + extraActividades;

            // Selección del mejor paquete (desempate: conservar el menor índice)
            if (costoTotal < mejorCosto) {
                mejorCosto = costoTotal;
                mejorIndice = i;
            }
            // Si costoTotal == mejorCosto, no cambiamos el índice (ya es el menor)
        }

        // Salida: imprimir solo el número del paquete ganador
        System.out.println(mejorIndice);
        
    }
    
}
