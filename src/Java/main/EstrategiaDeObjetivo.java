package Java.main;

public abstract class EstrategiaDeObjetivo {
	protected Logro logro;
	protected Usuario usuario;
	public abstract Rutina generarRutina();
	public abstract boolean verificarCumplimiento();
	public abstract void info();
	public Logro getLogro() {
		return this.logro;
	}
	public Usuario getUsuario() {
		return this.usuario;
	}
}
