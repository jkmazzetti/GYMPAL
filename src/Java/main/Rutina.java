package Java.main;

import java.util.Map;

public class Rutina {
	private boolean reforzada = false;
	private boolean completada = false;
	private int duracionEnSemanas = 4;
	private Map<Integer, Entrenamiento> planMensual;

	public void reforzar() {
		System.out.println("Generando rutina, aguarde por favor...");
		if (this.reforzada) {
			System.out.println("Reforzando rutina, aguarde por favor...");
		}

	}
	public boolean rutinaCompletada() {
		return this.completada;
	}
	public void setRefuerzo() {
		this.reforzada=true;
	}

}
