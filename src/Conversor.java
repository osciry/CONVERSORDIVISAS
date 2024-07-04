import java.util.Scanner;
import ConexionApi.conexionApi;
import DivisasDisponibles.Monedas;

public class Conversor {
    private static final String[] MONEDAS_DISPONIBLES = {
            "MXN", "Peso Mexicano",
            "USD", "Dólar Americano",
            "EUR", "Euro",
            "ARS", "Peso Argentino",
            "COP", "Peso Colombiano",
            "CLP", "Peso Chileno",
            "BRL", "Real Brasileño",
            "VES", "Bolívar Venezolano"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            System.out.println("\n------- Conversor de Divisas ------- ");
            System.out.println("******************************************************");
            System.out.println("Monedas disponibles:");
            for (int i = 0; i < MONEDAS_DISPONIBLES.length; i += 2) {
                System.out.println("- " + MONEDAS_DISPONIBLES[i] + ": " + MONEDAS_DISPONIBLES[i + 1]);
            }

            System.out.println("\nIngrese la moneda de origen (por ejemplo, USD): ");
            System.out.println("******************************************************");
            String monedaBase = scanner.nextLine().toUpperCase();

            System.out.println("Ingrese la moneda de destino (por ejemplo, EUR): ");
            System.out.println("******************************************************");
            String monedaCambio = scanner.nextLine().toUpperCase();

            System.out.println("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            try {
                Monedas cambioDivisas = conexionApi.getCambioDivisas(monedaBase, monedaCambio);
                double cantidadConvertida = cantidad * cambioDivisas.getConversionRate();
                System.out.println("******************************************************");
                System.out.printf("\n%.2f %s son equivalentes a %.2f %s%n", cantidad, monedaBase, cantidadConvertida, monedaCambio);
            } catch (Exception e) {
                System.out.println("\nError al obtener el tipo de cambio: " + e.getMessage());
            }
            System.out.println("******************************************************");
            System.out.println("\n¿Desea realizar otra conversión? (s/n): ");
            String opcion = scanner.nextLine();
            if (!opcion.equalsIgnoreCase("s")) {
                salir = true;
            }
        }

        scanner.close();
        System.out.println("\n¡Hasta luego!");
    }
}
