package Java.main;

public class MedicionHistorica {
	private double peso;
	private double grasa;
	private double masa;
	public MedicionHistorica(double peso, double grasa, double masa) {
		this.peso=peso;
		this.grasa=grasa;
		this.masa=masa;
	}
	public double obtenerPeso() {
		return this.peso;
	}
	public double obtenerGrasa() {
		return this.grasa;
	}
	public double obtenerMasa() {
		return this.masa;
	}
}
