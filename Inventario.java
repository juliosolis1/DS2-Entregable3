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

// Problema #4 - Inventario
import javax.swing.JOptionPane;

public class Inventario {

    // ------------------------- DATOS INICIALES DEL INVENTARIO -------------------------
    // Arreglo con los nombres de los items que vende la tienda
    static String[] items = { "Zapatos", "Carteras", "Vestidos", "Sombreros" };

    // Arreglo con los precios de cada item
    static double[] precios = { 25.00, 15.50, 150.75, 5.00 };

    // Arreglo con las cantidades disponibles de cada item
    static int[] cantidades = { 150, 100, 2, 10 };

    public static void main(String[] args) {

        // ------------------------- CICLO PRINCIPAL -------------------------
        // Usamos un ciclo do-while para mantener el programa ejecutándose
        // hasta que el cliente elija explícitamente la opción de salir.
        int opcion = -1; // variable de control del menú

        do {
            // 1) Mostrar inventario actualizado y menú de opciones
            String mensajeMenu = construirInventarioComoTexto() +
                    "\n\n¿Qué desea comprar?\n" +
                    "1) Zapatos\n" +
                    "2) Carteras\n" +
                    "3) Vestidos\n" +
                    "4) Sombreros\n" +
                    "5) Salir";

            String entrada = JOptionPane.showInputDialog(null, mensajeMenu, "Menú de compras",
                    JOptionPane.QUESTION_MESSAGE);

            // Si el usuario presiona Cancelar o cierra la ventana, interpretamos que desea salir
            if (entrada == null) {
                opcion = 5;
            } else {
                try {
                    opcion = Integer.parseInt(entrada);
                } catch (NumberFormatException ex) {
                    // Si escribe algo que no es número, mostramos un aviso y continuamos el ciclo
                    JOptionPane.showMessageDialog(null,
                            "Entrada inválida. Por favor, ingrese un número del 1 al 5.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                    continue; // volvemos a mostrar el menú
                }
            }

            // 2) Procesar la opción seleccionada usando switch (estructura vista en clase)
            switch (opcion) {
                case 1:
                case 2:
                case 3:
                case 4:
                    // El índice del arreglo es opción-1 (porque los arreglos inician en 0)
                    int indice = opcion - 1;

                    // Solicitamos la cantidad a comprar
                    Integer cantidadSolicitada = solicitarCantidad("¿Cuántas unidades de " + items[indice] + " desea comprar?");
                    if (cantidadSolicitada == null) {
                        // Si el usuario canceló en la cantidad, no hacemos nada y volvemos al menú
                        break;
                    }

                    // Validaciones básicas de la cantidad
                    if (cantidadSolicitada <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "La cantidad debe ser mayor que cero.",
                                "Cantidad inválida", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    // Verificar si hay suficiente inventario
                    if (cantidadSolicitada > cantidades[indice]) {
                        JOptionPane.showMessageDialog(null,
                                "No hay suficiente inventario.\n" +
                                "Disponible: " + cantidades[indice] + " unidad(es).",
                                "Inventario insuficiente", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    // Calcular costo total = precio * cantidad
                    double total = precios[indice] * cantidadSolicitada;

                    // Confirmar la compra con el cliente
                    int confirma = JOptionPane.showConfirmDialog(null,
                            "Detalle de compra:\n" +
                            "Item: " + items[indice] + "\n" +
                            "Precio unitario: B/. " + formatearMoneda(precios[indice]) + "\n" +
                            "Cantidad: " + cantidadSolicitada + "\n" +
                            "TOTAL A PAGAR: B/. " + formatearMoneda(total) +
                            "\n\n¿Confirmar compra?",
                            "Confirmación de compra", JOptionPane.YES_NO_OPTION);

                    if (confirma == JOptionPane.YES_OPTION) {
                        // Descontar del inventario
                        cantidades[indice] -= cantidadSolicitada;

                        // Mostrar inventario actualizado (requisito del enunciado)
                        JOptionPane.showMessageDialog(null,
                                "Compra realizada con éxito.\n\n" +
                                "Inventario actualizado:\n" + construirInventarioComoTexto(),
                                "Resumen", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Compra cancelada.",
                                "Información", JOptionPane.INFORMATION_MESSAGE);
                    }

                    break;

                case 5:
                    // Opción para salir de la aplicación
                    JOptionPane.showMessageDialog(null,
                            "Gracias por su visita. ¡Hasta luego!",
                            "Salir", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    // Manejo cuando el número no está entre 1 y 5
                    JOptionPane.showMessageDialog(null,
                            "Opción no válida. Elija un número del 1 al 5.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }

        } while (opcion != 5); // condición de salida del ciclo
    }

    // ------------------------- MÉTODOS DE APOYO -------------------------

    // Construye el inventario en forma de texto para mostrar en JOptionPane
    private static String construirInventarioComoTexto() {
        // Nota: Usamos un String simple con saltos de línea, acorde a lo visto en clase.
        String texto = "INVENTARIO ACTUAL\n" +
                       "------------------------------------\n" +
                       String.format("%-12s %-10s %-10s\n", "Item", "Precio", "Cantidad");

        for (int i = 0; i < items.length; i++) {
            // Imprimimos cada fila alineada: item, precio y cantidad
            texto += String.format("%-12s B/. %-7s %-10d\n",
                    items[i], formatearMoneda(precios[i]), cantidades[i]);
        }
        return texto;
    }

    // Solicita cantidad al usuario y devuelve Integer (o null si canceló)
    private static Integer solicitarCantidad(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(null, mensaje, "Cantidad", JOptionPane.QUESTION_MESSAGE);
            if (entrada == null) {
                // Usuario presionó Cancelar
                return null;
            }
            try {
                int cant = Integer.parseInt(entrada);
                return cant;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Debe ingresar un número entero válido.",
                        "Entrada inválida", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    // Da formato sencillo a valores monetarios con 2 decimales
    private static String formatearMoneda(double valor) {
        // String.format es parte de la librería estándar de Java.
        return String.format("%.2f", valor);
    }
}