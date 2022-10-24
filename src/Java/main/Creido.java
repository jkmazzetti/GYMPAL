package Java.main;

public class Creido extends Logro {

	public Creido(Usuario usuario, FireBase notificacion) {
		super(usuario, notificacion);
		this.leyenda="¡Dejá de pesarte a cada rato!";
	}

	@Override
	public void notificarLogro() {
		FireBase.notificar("Recibiste un trofeo al creido.\n"+this.leyenda);		
	}

	@Override
	public void entregarTrofeo() {
		if(this.usuario.getMedicionesHistoricas().size()>=4 && !this.entregado) {
			this.notificarLogro();
			this.usuario.recibirLogro(this);
			this.entregado=true;
		}
		
	}

}
