import java.util.*;

class prim{
	
	//Clase para manejar el archivo
	static arch ar = new arch();
	
	//ArrayList con todos los numeros primos
	static ArrayList<Long> nums_prims = new ArrayList<Long>();
	
	//Si el numero es primo sera true
	static boolean primos;
	
			
	public static void main (String [] main){
		
		//Creamos/Abrimos archivo
		ar.crear_archivo();

		Scanner leer = new Scanner(System.in);
		
		//Leemos el archivo y almacenamos los numeros en el ArrayList
		nums_prims = ar.leer_archivo();
		
		while(true){
			
			//Almacenamos el numero del usuario siempre y cuando no sea negativo o 1
			long a;
			do{
			System.out.print("Ingresa un numero: ");
			a = leer.nextLong();
			}while(a < 0 || a == 1);
			
			/*
			Limpiar pantalla
			
			try {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} catch (Exception e) {
				//No hacer nada
			}
			*/
			
			System.out.println();
			
			//Si el usuario ingresa el 0, el archivo se actualizará con el ArrayList
			if(a == 0){
				ar.escribir_archivo(nums_prims);
				System.out.println("Archivo.txt actualizado");
			}
			else{
				//Si el numero del usuario es mayor al ultimo numero en el ArrayList
				long ultimoNum = nums_prims.get(nums_prims.size()-1);
				if(a > ultimoNum){
					//Llamamos a la función primos_fuera_arreglo() para calcular si a es primo y la cantidad de primos antes
					int nums = primos_fuera_arreglo(a, ultimoNum);
					System.out.println();
					if(primos==true){
						//Si primos se mantuvo verdadero al final
						System.out.println(a + " es primo");
					}else{
						System.out.println(a + " no es primo");
					}
					System.out.println("Total de primos hasta "+a+": "+nums);
				}else{//Si el numero del usuario es menor al ultimo numero en el ArrayList
					//Llamamos a la funcion primos_en_arreglo() que nos devuelve  la cantidad de primos antes de 'a'
					int nums = primos_en_arreglo(a);
					if(primos==true){
						System.out.println(a + " es primo");
					}else{
						System.out.println(a + " no es primo");						
					}
					System.out.println("Total de primos hasta "+a+": "+nums);
				}
			}
			System.out.println();
		}
	}
	
	public static int primos_en_arreglo(long a){
		//Si el ArrayList contiene a 'a'
		if(nums_prims.contains(a)){
			//Decimos que 'a' es primo
			primos = true;
			//Devolvemos la cantidad de primos hasta 'a'
			return nums_prims.indexOf(a)+1;
		}else{
			//De lo contrario
			while(true){
				//Decimos que 'a' no es primo
				primos = false;
				//Le restamos 1 a 'a'
				a--;
				//Preguntamos si ahora si se encuentra en el ArrayList
				if(nums_prims.contains(a)){
					//Devolvemos la cantidad de primos hasta 'a'
					return nums_prims.indexOf(a)+1;
				}
			}
		}
	}
	public static int primos_fuera_arreglo(long n, long ultimoNum){
		//Mientras m sea menor o igual a n
		for(long m = ultimoNum+2;m <= n;m += 2){
			primos=true;
			//Mientras el numero en el ArrayList elevado al cuadrado sea menor o igual a m
			for(int k = 0; Math.pow(nums_prims.get(k),2) <= m;k++){
				//Si m es divisible entre el numero en el ArrayList
				if(m%nums_prims.get(k) == 0){
					//Entonces diremos que no es primo
					primos = false;
					break;
				}
			}
			//En caso de que m sea primo
			if(primos == true){
				//Se imprime en pantalla
				System.out.print(" "+m+" ");
				//Se agrega al ArrayList
				nums_prims.add(m);
			}
		}
		//Se devuelve el numero de primos en el ArrayList
		return nums_prims.size();	
	}
}