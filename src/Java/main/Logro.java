package Java.main;

public abstract class Logro {
	protected FireBase notificacion;
	protected Usuario usuario;
	protected String leyenda;
	protected boolean entregado;

	public Logro(Usuario usuario, FireBase notificacion) {
		this.usuario = usuario;
		this.notificacion = notificacion;
	}
	public boolean estado() {
		return this.entregado;
	}

	public abstract void notificarLogro();

	public abstract void entregarTrofeo();
	
}
