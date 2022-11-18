import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Cities {
	private Integer adyacency[][], routes[][], original[][], originalRoutes[][];
	private ArrayList<String> cities = new ArrayList<>();
	private final static int INF = 9999, nV = 32;
	/**
	Method to get the adyacency matrix
	 */
	public Integer[][] getAdyacency() {
		return adyacency;
	}
	/**
	Method to get the infinite value */
	public static int getInf() {
		return INF;
	}
	/**
	Method to get the new */
	public static int getNv() {
		return nV;
	}
	/**
	Method to get the original routes in the matrix */
	public Integer[][] getOriginalRoutes() {
		return originalRoutes;
	}
	/**Method to get the routes */
	public Integer[][] getRoutes() {
		return routes;
	}
	/**
	 * Es la clase constructora de ciudadess
	 * @param adyacency
	 * @param ciudades
	 * @param ruta
	 */
	public Cities(){
		String texto = readDB();
		loadCities(texto);
		loadWays(texto);
		loadRoutes();
		floydWarshall();
	}
	/**
	 * Es para leer la base de datos
	 * @return
	 */
	private String readDB(){ 
        String texto = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Windows 10\\Documents\\UVG\\CODING\\Semestre 4\\POO\\Proyectos\\Proyecto2\\Others\\Rutas2.txt"));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){ 
                temp = temp + bfRead+"\n"; 
            }

            bf.close();
            texto = temp;
            
        }catch(Exception e){ 
        }
        return texto;
       
    }
	/**
	 * Es para cargar los caminos
	 * @param texto
	 */
	private void loadWays(String texto){
		this.adyacency = new Integer[this.cities.size()][this.cities.size()];
			for(int i=0;i<this.adyacency.length;i++) 
			{
				this.adyacency[i][i]=0;
			}
			int contador=0;
			int l=0;
			int j=0;
			String ciudad="";
			for ( int i = 0 ; i < texto.length() ; i++ ) {
				if ( Character.isAlphabetic((texto.charAt(i))) || (Character.isDigit((texto.charAt(i)))) || ((String.valueOf(texto.charAt(i))).equals("-")) ) {
					ciudad = ciudad + texto.charAt(i) ;// Le suma los caracteres a la palabra -> A->An->Ant->Anti->Antig->Antigu->Antigua
				}
				else if ( !Character.isAlphabetic((texto.charAt(i))) ) 
				{
					if ( contador == 0 ) {	// En caso de que el contador sea 0
						l = this.cities.indexOf(ciudad); // Se obtiene el index de la ciudad
						contador++ ;	// Le suma 1 al contador
						ciudad = "" ;	// Reset de ciudad
					}
					else if( contador == 1 ) {	// Si el contador es 1
						j=this.cities.indexOf(ciudad);	// j es el index de la ciudad 1
						contador++;	// Se suma 1 al contador
						ciudad="";	// Reset de ciudad
					}
					else if(contador==2) {
						this.adyacency[l][j]= Integer.parseInt(ciudad);
						this.adyacency[j][l]= Integer.parseInt(ciudad);
						ciudad="";
						contador=0;
						l=0;
						j=0;
					}		
				}
			}
			for(int i=0;i<this.adyacency.length;i++) {
				for ( int k = 0 ; k < this.adyacency.length ; k ++ ) {
					if ( this.adyacency [k][i] == null ) 
					{
						this.adyacency[k][i] = 1000000000 ;
					}
				}
			}
		}
		/**
		 * Es para cargar las rutas en la matriz de ruta
		 */
		private void loadRoutes(){
			this.routes = new Integer[this.cities.size()][this.cities.size()];
			for ( int i = 0 ; i < this.cities.size(); i++ ) {
				for (int k = 0 ; k < this.cities.size() ; k++ ) {
					this.routes[k][i] = i ; // It fills with i all the column
					if ( k == i) {
						this.routes [k][i] = 0 ; //matriz[fila][columna]
					}
				}
			}
		}
		/**
		 * Es para almacenar los nodos o ciudades disponibles
		 * @param texto
		 */
		private void loadCities(String texto){
			String ciudad = "";
			for(int i=0;i<texto.length();i++) {
				if(Character.isAlphabetic((texto.charAt(i)))||((String.valueOf(texto.charAt(i))).equals("-"))) {
					ciudad=ciudad+texto.charAt(i);
				}
				else if(!Character.isAlphabetic((texto.charAt(i)))) {
					if(!(Character.isDigit((texto.charAt(i))))) {
						if(!((String.valueOf(texto.charAt(i))).equals("\n"))) {
							if(this.cities==null || !(this.cities.contains(ciudad))) {	
								this.cities.add(ciudad);
							}
							ciudad="";
						}
					}
				}
			}
		}
	/**
	 * Es el metodo para generar el algoritmo floydWarshall y que quede asi la matriz
	 * Se obtuvo de https://www.programiz.com/dsa/floyd-warshall-algorithm
	 */
	private void floydWarshall() {	    
	    // Adding vertices individually
	    for (int k = 0; k < nV; k++) {
	      for (int i = 0; i < nV; i++) {
	        for (int j = 0; j < nV; j++) {
	          if (getAdyacency()[i][k] + getAdyacency()[k][j] < getAdyacency()[i][j]) {
	            getAdyacency()[i][j] = getAdyacency()[i][k] + getAdyacency()[k][j];
	          	getRoutes()[i][j] = k ; // Esto es para agregar la matriz de rutas
	          }
	        }
	      }
	    }
	  }
	
	  /**
	   * Es la clase para obtener el id de la ciudad
	   * @param city
	   * @return
	   */
	  private Integer getCity(String city) {
	    	if (getCities().indexOf(city)!=-1) {
	    		return getCities().indexOf(city);
	    	}
	    	return null;
	    }
		/**
		 * Es para cambiar el estado de la ruta
		 * @param city1
		 * @param city2
		 * @param espera
		 */
	  public void changeRouteStatus(String city1, String city2, Integer espera) {
		  Integer id1 = getCity(city1);
		  Integer id2 = getCity(city2);
		  if ( id1 != null && id2 != null && espera != null ) {	// En el caso de que se tenga que no hay interrupcion de trafico
			  getAdyacency()[id1][id2] = espera ;
			  getAdyacency()[id2][id1] = espera ;
			  floydWarshall();
		  }
		  else if ( id1 != null && id2 != null && espera == null  ) {
			  getAdyacency()[id1][id2] = 1000000000 ;
			  getAdyacency()[id2][id1] = 1000000000 ; // Infinito entre ellos
			  floydWarshall();
		  }
		  else {
			  System.out.print("No existe la ciudad ingresada\n");
		  }
		  
	  }
	  /**
	   * Es el metodo para obtener la ciudad que esta en el centro del grafo o del nodo central
	   * @return String
	   */
	  public String getCenter() {
		  ArrayList<Integer> maxValue = new ArrayList<>();
		  ArrayList<Integer> maxId = new ArrayList<>();
		  for ( int k = 0 ; k < getCities().size() ; k++ ) {
			  ArrayList<Integer> valores = new ArrayList<>();
			  for ( int i = 0 ; i < getCities().size() ; i++ ) {
				  valores.add(getAdyacency()[i][k]) ; //Se add cada valor de la columna
			  }
			  maxValue.add(Collections.max(valores)) ; // Se add el value max de la columna
			  maxId.add(valores.indexOf(Collections.max(valores))) ;
		  }
		  for ( int k = 0 ; k < maxValue.size() ; k ++ ) {
			  if ( maxValue.get(k) == Collections.min(maxValue) ) {
				  return getCities().get(maxId.get(k))  ; //Retorna el nombre de la ciudad que es centro
			  }
		  }
		  return null;
	  }
	  /**
	   * Es el metodo para imprimir la ruta existente entre dos ciudades
	   * @param city1
	   * @param city2
	   */
	  public String getRoute(String city1, String city2) {
		  if (city1.equals(city2)) {
			  return (city1+"->"+city2+"->"+0+"\n");
		  }
		  else if (getCity(city1)!=null && getCity(city2)!=null){
			ArrayList<String>  ruta = new ArrayList<>() ;
			Integer id1 = getCity(city1) ;
			Integer id2 = getCity(city2) ;
			Integer de = this.routes[id1][id2] ;
			ruta.add(city2) ;
			ruta.add(getCities().get(de));
			while (de != this.routes[id1][de] ) {
				de = this.routes[id1][de] ;
				ruta.add(getCities().get(de)) ;
			}
			ruta.add(city1) ;
			for (int k = ruta.size()-1  ; k >= 0 ; k -- ) {
				System.out.print( ruta.get(k) + "->" );
			}
			  return(getAdyacency()[id1][id2]+"\n");
		  }else {
			  return("Alguna de las ciudades ingresadas no existe\n");
		  }
	  }
	/**
	 * Es para obtener la lista de ciudades
	 */
	  public ArrayList<String> getCities() {
		return cities;
	}
	/**
	 * Es para retornar la matriz original
	 * @return
	 */
	public Integer[][] getOriginal() {
		return original;
	}
	public ArrayList<String> getRouteArrayList(String city1, String city2) {
		ArrayList<String> route = new ArrayList<>();
		if (city1.equals(city2)) {
			route.add(city1);
			route.add("0");
			route.add(city2);
			return (route);
		}
		else if (getCity(city1)!=null && getCity(city2)!=null){
		  Integer id1 = getCity(city1) ;
		  Integer id2 = getCity(city2) ;
		  Integer de = this.routes[id1][id2] ;
		  route.add(city2) ;
		  route.add(getCities().get(de));
		  while (de != this.routes[id1][de] ) {
			  de = this.routes[id1][de] ;
			  route.add(getCities().get(de)) ;
		  }
		  route.add(city1) ;
		  route.add(String.valueOf(getAdyacency()[id1][id2]));
		  return route;
		}else {
			return(null);
		}
	}
	/**
	 * Es para retornar la distancia total entre ciudades
	 * @return string
	 */
	public String routeAndDistance(ArrayList<String> des){
		int distance = 0;
		String all = "";
		for (int k = 0 ; k < des.size()-2 ; k ++){
			int id1 = getCity(des.get(k));
			int id2 = getCity(des.get(k+1));
			all += des.get(k)+"->"+getAdyacency()[id1][id2]+"->";
			distance += getAdyacency()[id1][id2];
		}
		all+=des.get(des.size()-1);
		return all+"\nDistancia total: "+String.valueOf(distance)+"\n";
	}

	/**
	 * Es para retornar la distancia entre ciudadades
	 * @return distance
	 */
	public int distance(ArrayList<String> des){
		int distance = 0;
		for (int k = 0 ; k < des.size()-2 ; k ++){
			int id1 = getCity(des.get(k));
			int id2 = getCity(des.get(k+1));
			distance += getAdyacency()[id1][id2];
		}
		return (distance);
	}

	/**
	 * Imprime los valores actuales presentes
	 */
	public void printMatrix(Integer[][] Matrix){
		for (int k = 0 ; k < Matrix.length ; k++ ){
			for (int j = 0 ; j < Matrix[k].length ; j++){
				System.out.print(String.valueOf(Matrix[k][j])+"     ");
			}
			System.out.print("\n");
		}
	}
}