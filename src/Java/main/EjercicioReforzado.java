package Java.main;

public class EjercicioReforzado implements Ejercicio{

	private boolean completado;
	private int series;
	private int repeticiones;
	private double peso;
	private EjercicioConcreto ejercicio;
	public EjercicioReforzado(EjercicioConcreto ejercicio) {
		this.ejercicio=ejercicio;
	}
	@Override
	public void reforzar(int series, int repeticiones, double peso) {
		this.peso=peso;
		this.repeticiones=repeticiones;
		this.series=series;		
	}
	public void marcarCompletado() {
		this.completado=true;
	}
	public int getSeries() {
		return this.series+this.ejercicio.getSeries();
	}
	public int getRepeticiones() {
		return this.repeticiones+this.ejercicio.getRepeticiones();
	}
	public double getPeso() {
		return this.peso+this.ejercicio.getPeso();
	}
	public GrupoMuscular getGrupoMuscular() {
		return this.ejercicio.getGrupoMuscular();
	}

}
