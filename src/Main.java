
import java.util.ArrayList;
import java.util.Scanner;



/**
 * @author Diego Alonzo 20172
 */
public class Main {
 
	/**
	 * Es el main
	 * @param args
	 */
	// C:\Users\Windows 10\Documents\UVG\CODING\Semestre 4\POO\Proyectos\Proyecto2\Others\Rutas2.txt
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		Cities citi = new Cities();
		while (true) {
			String opcion = View.getOption();
			if (opcion.equals("1")) {
				System.out.print("Ingrese la ciudad 1: ");
				String ciudad1 = teclado.nextLine() ;
				System.out.print("Ingrese la ciudad 2: ");
				String ciudad2 = teclado.nextLine() ;
				System.out.println(citi.getRoute(ciudad1, ciudad2));;
			}else if( opcion.equals("2")){
				System.out.print("La ciudad mas centralizada es: " + citi.getCenter() + "\n");
			}else if( opcion.equals("3")){
				System.out.print("Ingrese la ciudad 1: ");
				String ciudad1 = teclado.nextLine() ;
				System.out.print("Ingrese la ciudad 2: ");
				String ciudad2 = teclado.nextLine() ;
				System.out.print("Ingrese el cambio en km: ");
				try {
					String km = teclado.nextLine() ;
					citi.changeRouteStatus(ciudad1, ciudad2,Integer.valueOf(km)) ;
				}catch (Exception e){
					System.out.print("No ingreso una cantidad de km valida\n") ;
				}
				
			}else if( opcion.equals("4")){
				System.out.print("Ingrese la ciudad 1: ") ;
				String ciudad1 = teclado.nextLine() ;
				System.out.print("Ingrese la ciudad 2: ") ;
				String ciudad2 = teclado.nextLine() ;
				citi.changeRouteStatus(ciudad1, ciudad2, null) ;
			}else if(opcion.equals("5")) {
				System.out.print("Gracias por usar nuestro programa\n") ;
				break ;
			}else if (opcion.equals("6")){
				View.printMatrix(citi.getOriginal());
			}
			else if (opcion.equals("7")){
				for (int k = 0 ; k < citi.getCities().size() ; k++ ){
					System.out.println(citi.getCities().get(k));
				}
			}
			else {
				System.out.print("No ingreso una opcion valida, vuelvalo a intentar\n");
			}
		}
		teclado.close();
	}
	

}
