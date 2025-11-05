
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
//------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        
        //El codigo de la app debe ir aqui abajo;
        Scanner sc = new Scanner(System.in); // escaner de entrada de teclado
        sc.useLocale(Locale.US); // fuerza a usar punto como separador decimal
        
        // Mensaje de inicializacion de Aplicación
        System.out.println("Bienvenido al Buscador de Viajes");

        //creacion de variables 
        
        // 1. Duración deseada del viaje (días)
        System.out.print("Ingrese la duracion deseada del viaje (en dias): ");
        int diasDeseados = sc.nextInt();

        // 2. Cantidad de actividades deseadas
        System.out.print("Ingrese la cantidad de actividades que desea realizar: ");
        int actividadesDeseadas = sc.nextInt();

        // 3. Cantidad de paquetes a evaluar
        System.out.print("Ingrese la cantidad de paquetes que desea comparar: ");
        int cantPaquetes = sc.nextInt();
        
        /*
        Asignamos un valor "grande"(Double.POSITIVE_INFINITY) para asegurar cualquiera sea el costo que tome, 
        siempre sea menor que el valor inicial. mejorCosto, es la variable que devolvera el mejor paquete para Gaston.
         */
        double mejorCosto = Double.POSITIVE_INFINITY;         
        
        int mejorIndice = 1; // índice 1-based
        for (int i = 1; i <= cantPaquetes; i++) {
            // 4. Lectura de cada paquete (en el orden indicado)
            System.out.print("Especifique costo base mensual del paquete: ");
            double costoBase = sc.nextDouble();
            System.out.print("Especifique duración maxima de días incluidos: ");
            int diasIncluidos = sc.nextInt();
            System.out.print("Especifique costo por día adicional: ");
            double costoDiaExtra = sc.nextDouble();
            System.out.print("Especifique cantidad de actividades incluidas: ");
            int actividadesIncluidas = sc.nextInt();
            System.out.print("Especifique costo por actividad adicional: ");
            double costoActividadExtra = sc.nextDouble();

            // Calcular extras: llamamos la funcion calcularCostosPorExtra y guardamos el resultado retornado en una variable.
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
        sc.close();
        System.out.println(mejorIndice);
    }
    
}
