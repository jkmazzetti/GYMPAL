package Java.main;

import ClasesExternas.MedicionExterna;

public abstract class AdapterMedicion {

	protected double peso;
	protected double grasa;
	protected double masa;
	protected double grasaIdeal;
	protected double masaIdeal;
	protected String fechaDeMedicion;
	protected MedicionExterna medicion;

	public abstract AdapterMedicion pesar();

	public abstract double obtenerPeso();

	public abstract double obtenerGrasa();

	public abstract double obtenerMasa();

	public abstract double obtenerGrasaIdeal();

	public abstract double obtenerMasaIdeal();

	public abstract String obtenerFechaDePesaje();
}
