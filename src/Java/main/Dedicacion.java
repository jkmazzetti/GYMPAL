package Java.main;

import java.util.Scanner;

public class Dedicacion extends Logro {
	Objetivo objetivo;

	public Dedicacion(Usuario usuario, FireBase notificacion, Objetivo objetivo) {
		super(usuario, notificacion);
		this.objetivo = objetivo;
		this.leyenda = "¡Cumpliste tu objetivo!";
	}

	@Override
	public void notificarLogro() {
		FireBase.notificar("Recibiste un trofeo por cumplir tu objetivo.\n" + this.leyenda);

	}

	@Override
	public void entregarTrofeo() {
		if (this.objetivo.verificarCumplimiento() && !this.entregado) {
			this.notificarLogro();
			this.usuario.recibirLogro(this);
			this.entregado = true;
			sugerirCambio();
		}

	}

	public void sugerirCambio() {
		if (this.objetivo.getDedicacion().estado()) {
			boolean validado=false;
			String respuesta;
			Scanner ingresoDeDatos=new Scanner(System.in);
			while (!validado) {
				System.out.println("¿Desea comenzar a mantener la figura? s/n");
				System.out.print("Su respuesta:");
				respuesta = ingresoDeDatos.nextLine();
				if (respuesta.equals("s")) {
					int margen = 5;
					while (!validado) {
						System.out.println(
								"INGRESE UN MARGEN ENTERO QUE CONSIDERE ACEPTABLE PARA MANTENER SU PESO EN KG. EJEMPLO 5");
						System.out.print("Su respuesta:");
						respuesta = ingresoDeDatos.nextLine();
						margen = Integer.valueOf(respuesta);
						if (margen > 0) {
							validado = true;
							this.objetivo = new Objetivo(new MantenerFigura(this.usuario, margen));
						}
					}
				}else if(respuesta.equals("n")) {
					System.out.println("Su plan de entrenamiento no cambiará.");
					validado=true;
				}
			}
		}
	}

}
