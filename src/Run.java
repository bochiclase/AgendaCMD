import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		String teclado;
		Scanner r = new Scanner(System.in);
		String[] partes = new String[1];
		Agenda agenda = new Agenda();
		System.out.println("######### BIENVENIDO A LA AGENDA DE ADRIAN #########");
		do {
			System.out.println("");
			System.out.println("¿QUE DESEA HACER?");
			System.out.println("Para introducir nombre nombre-telefono");
			System.out.println("Para buscar un número buscar:nombre");
			System.out.println("Para borrar un número borrar:numero");
			System.out.println("Para guardar la Agenda guardar:ruta");
			System.out.println("Para cargar la Agenda cargar:ruta");
			System.out.println("Introduce");

			System.out.print("> ");
			teclado = r.next();

			if (teclado.contains("-")) {
				partes = teclado.split("-");
				agenda.Introducir(partes[0], partes[1]);
				partes = null;

			} else if (teclado.contains("buscar:")) {
				partes = teclado.split(":");
				agenda.buscar(partes[0], partes[1]);
				partes = null;
 
				
			} else if (teclado.contains("borrar:")) {
				partes = teclado.split(":");
				agenda.borrare(partes[0], partes[1]);
				partes = null;

			} else if (teclado.contains("guardar:")) {
				partes = teclado.split(":");
				agenda.guardar(partes[0], partes[1]);
				partes = null;

			} else if (teclado.contains("cargar:")) {
				partes = teclado.split(":");
				agenda.cargar(partes[0], partes[1]);
				partes = null;

			} else if (!teclado.contains("fin")) {
				System.out.println("El patrón de busqueda no es correcto");

			}

		} while (!teclado.equals("fin"));

		System.out.println("LA AGENDA FUÉ CERRADA");
	}

}
