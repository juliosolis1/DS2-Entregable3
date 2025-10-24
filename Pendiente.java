/**
Universidad Tecnológica de Panamá
Facultad de Ingeniería en Sistemas Computacionales
Licenciatura en Desarrollo y Gestión de Software

Asignatura - Desarrollo de Software II

Asignación #3 - Programación con Java

Facilitador: Paulo Picota

Integrantes:
Diego Hernández | 20-70-8359
Alanis Martez | 8-1019-2389
Julio Solís | 8-1011-1457

Grupo: 1GS117

Fecha de entrega: 27 de octubre de 2025
II Semestre | I Año
**/

// Problema #6 - Pendiente
import java.util.Scanner;
import java.util.InputMismatchException;

public class Pendiente {

    // Método principal: aquí inicia la ejecución del programa
    public static void main(String[] args) {
        // Creamos un lector Scanner para capturar datos desde la consola
        Scanner lector = new Scanner(System.in);

        // Declaramos las variables para las coordenadas de los dos puntos
        double x1, y1, x2, y2;

        try {
            // ---------------- Entrada de datos por consola ----------------
            // Pedimos cada coordenada por separado para evitar confusiones
            System.out.println("=== Cálculo de pendiente de una recta a partir de dos puntos ===");
            System.out.print("Ingrese x1: ");
            x1 = lector.nextDouble();

            System.out.print("Ingrese y1: ");
            y1 = lector.nextDouble();

            System.out.print("Ingrese x2: ");
            x2 = lector.nextDouble();

            System.out.print("Ingrese y2: ");
            y2 = lector.nextDouble();

            // ---------------- Cálculo de pendiente y ecuación ----------------
            // Si x1 == x2, el denominador (x2 - x1) es 0 y la pendiente es indefinida (recta vertical)
            if (x1 == x2) {
                // Salidas con el formato solicitado
                System.out.println();
                System.out.println("Para los puntos (" + x1 + "," + y1 + ") y (" + x2 + "," + y2 + ") la pendiente de la recta es: indefinida");
                System.out.println("La recta se mueve hacia: vertical");
                // En una recta vertical la ecuación correcta es x = c
                System.out.println("La fórmula general de la recta es x = " + x1);
            } else {
                // Fórmula de la pendiente m = (y2 - y1) / (x2 - x1)
                double m = (y2 - y1) / (x2 - x1);

                // Para la ecuación y = mx + b, despejamos b = y1 - m*x1
                double b = y1 - (m * x1);

                // Determinamos la dirección según el signo de la pendiente
                String direccion;
                if (m > 0) {
                    direccion = "arriba";   // la recta sube al avanzar en x
                } else if (m < 0) {
                    direccion = "abajo";    // la recta baja al avanzar en x
                } else {
                    direccion = "horizontal"; // m = 0
                }

                // ---------------- Salida a consola con el formato requerido ----------------
                System.out.println();
                System.out.println("Para los puntos (" + x1 + "," + y1 + ") y (" + x2 + "," + y2 + ") la pendiente de la recta es: " + formatea(m));
                System.out.println("La recta se mueve hacia: " + direccion);

                // Mostramos y = mx + b con el signo adecuado para b (evitar "+ -3.00")
                String ecuacion = "y = " + formatea(m) + "x";
                if (b >= 0) {
                    ecuacion += " + " + formatea(b);
                } else {
                    ecuacion += " - " + formatea(Math.abs(b));
                }
                System.out.println("La fórmula general de la recta es " + ecuacion);
            }

        } catch (InputMismatchException ex) {
            // Si el usuario digita algo que no es número, mostramos un mensaje claro y terminamos
            System.out.println("\nEntrada inválida: por favor ingrese solo valores numéricos (use punto decimal si aplica).");
        } finally {
            // Cerramos el Scanner para liberar el recurso
            lector.close();
        }
    }

    // ---------------- Métodos de apoyo ----------------

    /**
      Devuelve un número con 2 decimales en formato de texto.
      Se usa para que los resultados se vean limpios en pantalla.
     **/
    private static String formatea(double valor) {
        return String.format("%.2f", valor);
    }
}
