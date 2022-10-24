package Java.main;

public class TonificarCuerpo extends EstrategiaDeObjetivo {
	private double masaIdeal;
	private double grasaIdeal;

	public TonificarCuerpo(Usuario usuario, AdapterMedicion medicion) {
		this.usuario = usuario;
		this.masaIdeal = medicion.obtenerMasaIdeal();
		this.grasaIdeal = medicion.obtenerGrasaIdeal();
		this.info();
	}

	@Override
	public Rutina generarRutina() {
		Rutina rutina = null;
		return rutina;
	}

	@Override
	public boolean verificarCumplimiento() {
		boolean cumplido = false;
		if (this.usuario.getUltimoPesaje() != null) {
			cumplido = this.usuario.getUltimoPesaje().obtenerMasa() >= this.masaIdeal
					&& this.usuario.getUltimoPesaje().obtenerGrasa() <= this.grasaIdeal;
		}
		return cumplido;
	}

	@Override
	public void info() {
		System.out.println("Para cumplir este objetivo, tu masa debe ser >=" + this.masaIdeal
				+ " y tu grasa corporal debe ser <=" + this.grasaIdeal);
	}

}
