
package co2;
import java.util.Scanner;
public class CO2 {

    public static void main(String[] args) {
       Scanner x = new Scanner(System.in);
       
       String combus;
       int CO2D = 2640;//CO2 se necesitan 1920 gramos de oxígeno. Si efectuamos la misma operación y sumamos, obtenemos 2640 gramos de CO2 por cada litro de diesel.
       int CO2G =2392;//un motor necesita unos 1740 gramos de oxígeno por litro. Habría que sumar los 652 gramos del combustible a los 1740 gramos de oxígeno.
       int KM;
       int Total;
       System.out.println("Que tipo de combustible utiliza tu carro");
       combus = x.next();
       System.out.println("Cuantos kilometros recorrio?");
       KM = x.nextInt();
       if (combus == "gasolina"){
           Total = (CO2G*6)/100;
        }else{  
           Total = (CO2G*5)/100;
       }
       System.out.println(Total + "gramos de CO2 por cada kilómetro recorrido.");
    }   
    
}
