import java.util.Scanner;

public class View {
    private static Scanner scan = new Scanner(System.in);
    public static void printAnything(String anything){
        System.out.println(anything);
    }
    /**
	 * Es la clase para imprimir matrices, sirvio como debugger
	 * Esta clase se obtuvo de https://www.programiz.com/dsa/floyd-warshall-algorithm
	 * @param matrix
	 */
	  public static void printMatrix(Integer matrix[][]) {
	    for (int i = 0; i < 32; ++i) {
	      for (int j = 0; j < 32; ++j) {
	        if (matrix[i][j] == 9999)
	          System.out.print("INF ");
	        else
	          System.out.print(matrix[i][j] + "  ");
	      }
	      System.out.println();
	    }
	  }
      public static String getOption(){
        System.out.print("Seleccione una opcion:\n1-Buscar la ruta mas corta entre ciudades\n2-Ciudad mas centralizada\n3-Actualizar la conexion entre dos ciudades\n4-Indicar si hay interrupcion entre ciudades\n5-Salir\n") ;
		String opcion = scan.nextLine() ;
		return opcion;	
      }
    
}
