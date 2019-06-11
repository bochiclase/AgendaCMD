import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.*;

public class Agenda {

	private Map<String, String> agenda = new HashMap<String, String>();
	private String part1;
	private String part2;

	public void Introducir(String nombre, String numero) {

		if (!agenda.containsKey(nombre)) {
			agenda.put(nombre, numero);
			System.out.println("El numero se guardó en la agenda correctamente");
			System.out.println("");
			nombre = null;
			numero = null;
		} else {
			agenda.put(nombre, numero);
			System.out.println("El numero fue actualizado");
			System.out.println("");
			nombre = null;
			numero = null;

		}

	}

	public void buscar(String bus, String nombre) {

		if (agenda.containsKey(nombre)) {
			System.out.println(nombre + " -> " + agenda.get(nombre));
			System.out.println("");
			bus = null;
			nombre = null;

		}

		else if (!agenda.containsKey(nombre)) {
			System.out.println("El nombre no esta ni se le espera ;) ");
			System.out.println("");
			nombre = null;
			bus = null;
		}

	}

	public void borrare(String borrar, String nombre) {
		String contactos;
		if (agenda.containsKey(nombre)) {
			contactos = agenda.get(nombre);
			agenda.remove(nombre);
			System.out.println("contacto eliminado:" + nombre + "->" + contactos);
			borrar = null;
			nombre = null;
		} else {
			System.out.println("El contacto no se encuentra en la Agenda");
			borrar = null;
			nombre = null;
		}

	}

	public void guardar(String guardar, String ruta) {
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ruta), "UTF-8"));

			// Escribimos linea a linea en el fichero
			for (Map.Entry<String, String> entry : agenda.entrySet()) {

				try {

					out.write(entry.getKey() + " - " + entry.getValue() + "\n");

					System.out.println(
							"EL contacto " + entry.getKey() + " - " + entry.getValue() + " fué guardado con exito");
					guardar = null;
					ruta = null;
				} catch (IOException ex) {
					System.out.println("Mensaje excepcion escritura: " + ex.getMessage());
				}
			}

		} catch (UnsupportedEncodingException | FileNotFoundException ex2) {
			System.out.println("Mensaje error 2: " + ex2.getMessage());
		} finally {
			try {
				out.close();
			} catch (IOException ex3) {
				System.out.println("Mensaje error cierre fichero: " + ex3.getMessage());
			}
		}

	}

	public void cargar(String nombre, String ruta) {
		File fichero = new File("./fichero_Agenda.txt");
		Scanner s = null;
		int pregunta = 0;
		Scanner r = new Scanner(System.in);
	

		fichero = new File(ruta);
		nombre = null;
		ruta = null;

		try {
			// Leemos el contenido del fichero
			s = new Scanner(fichero);

			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); // Guardamos la linea en un String
				String[] partes2 = linea.split("-");
				String nombre2 = partes2[0].trim();
				String numero2 = partes2[1].trim();

				if (!agenda.containsKey(nombre2)) {
					agenda.put(nombre2, numero2);
					System.out.println("El contacto se ha cargado correctamente en la agenda desde el fichero");
					nombre2 = null;
					numero2 = null;
				} else {

					System.out.println("El número ya está en la Agenda");
					System.out.println("¿Qué desea hacer? Escriba el numero de la orden");
					System.out.println("1. Desea guardar " + nombre2 + "-" + agenda.get(nombre2));
					System.out.println("2. Desea guardar " + nombre2 + "-" + numero2);
					System.out.print("> ");

					pregunta = r.nextInt();

					if (pregunta == 1) {
						System.out.println("El teléfono que estaba en la Agenda ha sido guardado con exito");
						nombre2 = null;
						numero2 = null;
				
					} else if (pregunta == 2) {
						agenda.put(nombre2, numero2);
						nombre2 = null;
						numero2 = null;
						System.out.println("Se ha sobrescribido el número que estaba en la Agenda por el del fichero");
					
					}

					else {
						do {
							System.out.println("El número ya está en la Agenda");
							System.out.println("¿Qué desea hacer? Escriba el numero de la orden");
							System.out.println("1. Desea guardar " + nombre2 + "-" + agenda.get(nombre2));
							System.out.println("2. Desea guardar " + nombre2 + "-" + numero2);
							System.out.println("Se esperaba un 1 o un 2");

							System.out.print("> ");
							pregunta = r.nextInt();
							if (pregunta == 1 || pregunta == 2) {
								break;
							}

						} while (pregunta != 2 || pregunta != 1);

						// cargar:./prueba.txt

					}

				}

			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
	}

}
