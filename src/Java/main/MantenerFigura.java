package Java.main;

public class MantenerFigura extends EstrategiaDeObjetivo {
	private int margen;
	private double pesoInicial;

	public MantenerFigura(Usuario usuario, int margen) {
		this.usuario = usuario;
		this.margen = margen;
		if (this.usuario.getMedicionesHistoricas() != null) {
			this.pesoInicial = this.usuario.getUltimoPesaje().obtenerPeso();
		} else {
			this.pesoInicial = this.usuario.getPeso();
		}
		this.info();
	}

	@Override
	public Rutina generarRutina() {
		return null;
	}

	@Override
	public boolean verificarCumplimiento() {
		boolean cumplido = false;
		if (this.usuario.getUltimoPesaje() != null) {
			cumplido = this.usuario.getUltimoPesaje().obtenerPeso() <= this.pesoInicial + this.margen
					|| this.usuario.getUltimoPesaje().obtenerPeso() >= this.pesoInicial - this.margen;
		}
		return cumplido;
	}

	@Override
	public void info() {
		System.out.println(
				"Para cumplir este objetivo, tu peso debe oscilar entre " + Math.round((this.pesoInicial - this.margen))
						+ "Kg y " + Math.round((this.pesoInicial + this.margen)) + "Kg.");
	}

}
