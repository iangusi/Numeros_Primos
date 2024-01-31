import java.io.*;
import java.util.*;

public class arch{

	//Variable para crear/abrir un archivo
	File archivo;
	
	public void crear_archivo(){
		try{
			//Creamos/abrimos el archivo "archivo.txt"
			archivo = new File("archivo.txt");
			//Si es la primera vez que abrimos el archivo
			if(archivo.createNewFile()){
				System.out.println("Archivo listo");
			}
		}catch(IOException e){
			//En caso de un error, imprimimos el error
			System.out.println("ERROR "+e);
		}
	}
	
	public ArrayList<Long> leer_archivo(){
		
		//Creamos un ArrayList que guardará los números primos dentro de archivo.txt
		ArrayList<Long> nums_prims = new ArrayList<Long>();
		
		try{
			FileReader leer = new FileReader(archivo);
			BufferedReader lector = new BufferedReader(leer);
			//Leemos la primera linea del archivo
			String num = lector.readLine();
			//Si el archivo esta vacio
			if(num == null){
				//Agregamos unicamente el número 2 y 3 al ArrayList
				nums_prims.add(2L);
				nums_prims.add(3L);
			}
			//Mientras el archivo tenga alguna linea que leer
			while(num != null){
				//Agregaremos el numero al ArrayList
				nums_prims.add(Long.parseLong(num));
				//Pasaremos a la siguiente linea
				num = lector.readLine();
			}
			//Cerramos la lectura
			lector.close();
			leer.close();
		}catch(IOException e){
			//En caso de un error, imprimimos el error
			System.out.println("ERROR "+e);
		}
		//Devolvemos el ArrayList
		return nums_prims;
	}
	
	public void escribir_archivo(ArrayList<Long> nums_prims){
		try{
			//Pasamos los numeros del ArrayList al archivo.txt
			FileWriter escribir = new FileWriter(archivo);
			for(int j = 0;j < nums_prims.size();j++){
				escribir.write(""+nums_prims.get(j)+"\n");
			}
			//Cerramos la escritura
			escribir.close();
		}catch(IOException e){
			//En caso de un error, imprimimos el error
			System.out.println("ERROR "+e);
		}
	}
}