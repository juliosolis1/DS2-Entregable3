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