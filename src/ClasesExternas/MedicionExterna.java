package ClasesExternas;

/*
 * Se creó esta clase para poder hacer la ejecucion del programa.
 * 
 */
import java.util.Random;

public class MedicionExterna {
	public String[] obtenerDatosExternos() {
		String[] mediciones = new String[6];
		mediciones[0] = "" + valoresEntreRango(65, 90);// peso
		mediciones[1] = "" + valoresEntreRango(10, 20);// grasa
		mediciones[2] = "" + valoresEntreRango(70, 80);// masa
		mediciones[3] = "" + valoresEntreRango(10, 15);// grasa ideal
		mediciones[4] = "" + valoresEntreRango(75, 80);// masa ideal
		mediciones[5] = java.time.LocalDate.now().toString();// fecha de medicion
		return mediciones;
	}

	private double valoresEntreRango(int min, int max) {
		Random r = new Random();
		return min + (max - min) * r.nextDouble();
	}
}
