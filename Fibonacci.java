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

// Problema #3 - Fibonacci
import java.io.*;

public class Fibonacci{
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        //Variables
        int num;
//Declarar variables para la suma de Fibonnaci
int a = 0;
int b = 1;
int c;

System.out.println("Cuantos numeros desea sacar de Fibonnaci?: ");
num = Integer.parseInt(read.readLine());

for(int i = 0; i<=num; i++){
    System.out.println(a+" ");
    //Suma para representar fibonacci en el print
c = a+b;
a = b;
b = c;
//Espacio en blanco para que se lean mejor los numeros
System.out.println(" ");
}
        
    }
}