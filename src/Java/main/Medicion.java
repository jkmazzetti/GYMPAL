package Java.main;

import ClasesExternas.MedicionExterna;

public class Medicion extends AdapterMedicion {
	private static Medicion adaptada = null;

	private Medicion() {
		MedicionExterna medicion = new MedicionExterna();
		Medicion adaptada = null;
		peso = Math.round(Double.valueOf(medicion.obtenerDatosExternos()[0]));
		grasa = Math.round(Double.valueOf(medicion.obtenerDatosExternos()[1]));
		masa = Math.round(Double.valueOf(medicion.obtenerDatosExternos()[2]));
		grasaIdeal = Math.round(Double.valueOf(medicion.obtenerDatosExternos()[3]));
		masaIdeal = Math.round(Double.valueOf(medicion.obtenerDatosExternos()[4]));
		fechaDeMedicion = medicion.obtenerDatosExternos()[5];
	}

	@Override
	public AdapterMedicion pesar() {
		adaptada = new Medicion();
		return adaptada;
	}

	@Override
	public double obtenerPeso() {
		if (adaptada == null) {
			adaptada = new Medicion();
		}
		return adaptada.peso;
	}

	@Override
	public double obtenerGrasa() {
		if (adaptada == null) {
			adaptada = new Medicion();
		}
		return adaptada.grasa;
	}

	@Override
	public double obtenerMasa() {
		if (adaptada == null) {
			adaptada = new Medicion();
		}
		return adaptada.masa;
	}

	@Override
	public double obtenerGrasaIdeal() {
		if (adaptada == null) {
			adaptada = new Medicion();
		}
		return adaptada.grasaIdeal;
	}

	@Override
	public double obtenerMasaIdeal() {
		if (adaptada == null) {
			adaptada = new Medicion();
		}
		return adaptada.masaIdeal;
	}

	@Override
	public String obtenerFechaDePesaje() {
		if (adaptada == null) {
			adaptada = new Medicion();
		}
		return adaptada.fechaDeMedicion;
	}
	public static Medicion getMedicion() {
		if(adaptada==null) {
			adaptada= new Medicion();
		}
		return adaptada;
	}

}
