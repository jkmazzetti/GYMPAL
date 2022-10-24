package Java.main;

import java.text.ParseException;

public class main {

	public static void main(String[] args) throws ParseException{
		Usuario usuario = Login.ingreso();
		usuario.completarDatos();
		usuario.elegirObjetivo();
		usuario.comenzarEntrenamientoDelDia();
	}

}
