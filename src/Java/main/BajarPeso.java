package Java.main;

public class BajarPeso extends EstrategiaDeObjetivo {
	private double pesoIdeal;
	public BajarPeso(Usuario usuario) {
		this.usuario=usuario;
		this.pesoIdeal=calcularPesoIdeal();
		this.info();
	}
	private double calcularPesoIdeal() {
		double pesoIdeal=0;
		if(usuario.getSexo()==Sexo.MASCULINO) {
			pesoIdeal=(usuario.getAltura()-1-(usuario.getAltura()-1.5)/4)*100;
		}else {
			pesoIdeal=(usuario.getAltura()-1-(usuario.getAltura()-1.5)/2.5)*100;
		}
		return pesoIdeal;
	}
	
	@Override
	public Rutina generarRutina() {
		Rutina rutina=null;
		return rutina;
	}
	@Override
	public boolean verificarCumplimiento() {
		boolean cumplido=false;
		if(usuario.getUltimoPesaje()!=null) {
			cumplido=usuario.getUltimoPesaje().obtenerPeso()<=this.pesoIdeal;
		}else {
			cumplido=usuario.getPeso()<=this.pesoIdeal;
		}
		return cumplido;
	}
	public void info() {
		System.out.println("Tu peso ideal es "+this.pesoIdeal+"Kg de acuerdo a tu altura y sexo.");
	}
}
