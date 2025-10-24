import java.io.*;

public class Mejordelomejor{
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        //Variables (se declara mayor y menor a 0 para inicializarlas y realizar los mayores y menores)
        int cant,mayor=0,menor=0;
        int total = 0;
        double prom = 0;

//Pedir cantidad de numeros a ingresar
        System.out.println("Cuantos numeros desea ingresar?: ");
        cant = Integer.parseInt(read.readLine());

//declarar el tamaño del arreglo a base de la cantidad de numeros deseadas
 int [] num = new int[cant];

    //Iniciar ciclo de repeticion para ingresar los numeros
        for (int i = 0; i<cant;i++){
         System.out.println("Ingrese el numero#"+(i+1)+": ");
        num[i] = Integer.parseInt(read.readLine());

        //Acumulador para suma total
            total = total + num[i];

//Deckarar el mayor y menor en base al primer numero ingresado
if (i == 0){
    mayor = num[0];
    menor = num[0];
}
else{

            if (num[i]>mayor){
                mayor = num[i];
            }
            if (num[i]<menor){
                menor = num[i];
            }
        }
    }

    //sacar promedio a parte del total y la cantidad deseada de numeros ingresados
prom = total/cant;

System.out.println("La cantidad total de los numeros es: "+total);
System.out.println("El promedio de los numeros es: "+prom);
System.out.println("El mayor de los numeros es: "+mayor);
System.out.println("El menor de los numeros es: "+menor);
    }

}