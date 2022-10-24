package Java.main;

public class Constante extends Logro {
	Objetivo objetivo;
	public Constante(Usuario usuario, FireBase notificacion, Objetivo objetivo) {
		super(usuario, notificacion);
		this.objetivo=objetivo;
		this.leyenda="¡Realizaste todos los ejercicios!";
	}
	@Override
	public void notificarLogro() {
		FireBase.notificar("Recibiste un trofeo por hacer todos los ejercicios.\n"+this.leyenda);
		
	}
	@Override
	public void entregarTrofeo() {
		if(this.objetivo.rutinaCompletada() && !this.entregado) {
			this.notificarLogro();
			this.usuario.recibirLogro(this);
			this.entregado=true;
		}
	}

}
