import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Marcos Gutierrez				17909
 * @author Raul Monzon					17014
 * Clase principal
 */


public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		/*ArrayList para las palabras del diccionario*/
		ArrayList<String> diccionario = new ArrayList<String>();
		/*Asociamos la clase BinaryTree con un atributo*/
		BinaryTree<String, String> palabra = new BinaryTree<String,String>();
		/*Atributos para los datos*/
		String traducido = "";
		
		System.out.println("Bienvenida \n Seleccione el archivo .TXT que tengo el diccionario");
		teclado.nextLine();
		
		/*Escogemos el archivo con el diccionario*/
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("./src"));
		chooser.setDialogTitle("Seleccione el archivo que desea");
		chooser.setFileFilter(new FileNameExtensionFilter("Text files (.txt", "txt"));

		int valor = chooser.showOpenDialog(null);
		if(valor == JFileChooser.APPROVE_OPTION) {
			try {
				/*Leemos el archivo de texto*/
				FileInputStream stream = new FileInputStream(chooser.getSelectedFile().getAbsolutePath());
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
				
				String linea;
				while((linea = reader.readLine()) != null) {
					/*Agregamos la línea al diccionario*/
					diccionario.add(linea);
				}
				
				/*Separamos las lineas del archivo para lograr hacer la asociacion*/
				for(int i = 0; i<diccionario.size(); i++) {
					String datos = diccionario.get(i).substring(i, diccionario.get(i).length() - 1);
					String[] unicornio = datos.split(", ");
					palabra.insert(unicornio[0], unicornio[1]);
				}
			} catch(Exception e) {
				System.err.println("El .txt esta vacio");
			}
		}
		
	}

}
