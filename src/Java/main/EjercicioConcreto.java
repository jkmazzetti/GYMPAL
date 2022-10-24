package Java.main;

public class EjercicioConcreto implements Ejercicio{
	private GrupoMuscular grupoMuscular;
	private int nivelAerobico;
	private Exigencia exigencia;
	private boolean completado;
	private String url;
	private double peso;
	private int repeticiones;
	private int series;
	public EjercicioConcreto(GrupoMuscular grupo, int nivelAerobico, Exigencia exigencia) {
		this.grupoMuscular=grupo;
		this.nivelAerobico=nivelAerobico;
		this.exigencia=exigencia;
		this.completado=false;		
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
		return this.series;
	}
	public int getRepeticiones() {
		return this.repeticiones;
	}
	public double getPeso() {
		return this.peso;
	}
	public GrupoMuscular getGrupoMuscular() {
		return this.grupoMuscular;
	}

}
