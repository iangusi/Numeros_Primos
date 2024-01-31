import java.util.*;

class TFA{
	
	public static void main (String [] main){

		//Clase para obtener inputs
		Scanner leer = new Scanner(System.in);
		
		while(true){
			//Clase para guardar numero primo y exponente
			prims prim = new prims();
			//ArrayList para guardar la clase de arriba
			ArrayList<prims> nums = new ArrayList<>();
			//Numero del usuario
			long a;
			//Solicitamos numero al usuario mientras sea menor o igual a 1
			do{
				System.out.print("Ingresa un numero: ");
				a = leer.nextLong();
			}while(a <= 1);
			//Guardamos una copia del numero del usuario
			long n = a;
			//Creamos un contador
			int contador = 0;
			while(true){
				//Bandera para seguir en el bucle
				boolean seguir = false;
				//Residuo de la division del num del usuario y 2
				long residuo = a%2;
				//Si el numero es divisible entre 2
				if(residuo == 0){
					//El contador aumenta en 1
					contador++;
					//Hacemos que la clase prim guarde al numero 2
					prim.set_num(2);
					//Cambiamos el valor de 'a' por la división
					a = a/2;
					//Que continue el bucle
					seguir = true;
				}
				//Si el numero ya no es divisible entre 2
				if(seguir == false){
					//Terminamos con el bucle
					break;
				}
			}
			//Si el contador aumentó
			if(contador != 0){
				//Entonces prim ya tiene un numero
				//Solo nos falta agregar el exponente que es el contador
				prim.set_exponente(contador);
				//Agregamos la clase con el num y exponente en el ArrayList
				nums.add(prim);
			}
			//Creamos un bucle a partir del 3 hasta que el numero al cuadrado sea mayor a 'a'
			//Si te preguntas por que paramos entonces puedes buscar que es la Criba de Erastóstenes
			//Damos saltos de dos en dos ya que no nos importan los numeros divisibles entre 2
			for(long j = 3; Math.pow(j,2) <= a; j += 2){
				//Limpiamos los datos que tenia la clase
				prim = new prims();
				//Reiniciamos el contador en 0
				contador = 0;
				while(true){
					//Bandera para seguir en el bucle
					boolean seguir = false;
					//Residuo de la division del num del usuario y j
					long residuo = a%j;
					//Si el numero es divisible entre j
					if(residuo == 0) {
						//El contador aumenta en 1
						contador++;
						//Hacemos que la clase prim guarde al numero j
						prim.set_num(j);
						//Cambiamos el valor de 'a' por la división
						a = a/j;
						//Que continue el bucle
						seguir = true;
					}
					//Si el numero ya no es divisible entre j
					if(seguir == false){
						//Terminamos con el bucle
						break;
					}
				}
				//Si el contador aumentó
				if(contador != 0){
					//Entonces prim ya tiene un numero
					//Solo nos falta agregar el exponente que es el contador
					prim.set_exponente(contador);
					//Agregamos la clase con el num y exponente en el ArrayList
					nums.add(prim);
				}
			}
			//Si a es distinto de 1, significa que es un numero primo que debemos agregar
			if(a != 1){
				//Limpiamos los datos que tenia la clase
				prim = new prims();
				//Hacemos que la clase prim guarde al numero a
				prim.set_num(a);
				//Decimos que el exponente es 1
				prim.set_exponente(1);
				//Agregamos la clase con el num y exponente al ArrayList
				nums.add(prim);
			}
			//Imprimimos el numero que el usuario nos dio
			System.out.print(n +" = ");
			//Imprimimos todos los elementos del ArrayList
			for(int j=0;j<nums.size();j++){
				System.out.print("("+nums.get(j).get_num()+"^"+nums.get(j).get_exponente()+")");
			}
			System.out.println("\n");
		}
	}
}