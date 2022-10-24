package Java.main;

public class Objetivo {
	private EstrategiaDeObjetivo estrategia;
	private Rutina rutina;
	private Usuario usuario;
	private Constante constante;
	private Dedicacion dedicacion;
	public Objetivo(EstrategiaDeObjetivo estrategia) {
		this.estrategia=estrategia;
		this.usuario=estrategia.getUsuario();	
		this.dedicacion=new Dedicacion(usuario, FireBase.getFireBase(), this);
		this.constante=new Constante(usuario, FireBase.getFireBase(), this);
	}
	public void generarRutina() {
		System.out.println("Generando Rutina...");
		this.rutina=this.estrategia.generarRutina();
	}

	public void cambiarDeObjetivo(EstrategiaDeObjetivo nuevaEstrategia) {
		this.estrategia = nuevaEstrategia;
	}

	public boolean verificarCumplimiento() {
		return this.estrategia.verificarCumplimiento();
	}

	public void reforzarRutina() {
		this.rutina.reforzar();
	}

	public Entrenamiento obtenerEntrenamientoDelDia() {
		Entrenamiento entrenamiento = null;
		return entrenamiento;
	}
	public boolean rutinaCompletada() {
		return this.rutina.rutinaCompletada();
	}
	public Dedicacion getDedicacion() {
		return this.dedicacion;
	}
	public Constante getConstante() {
		return this.constante;
	}
}
