package Java.main;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.List;
import java.util.Scanner;

public class Usuario {
	String nombre;
	Sexo sexo;
	String fechaDeNacimiento;
	double altura;
	double peso;
	Objetivo objetivo;
	List<MedicionHistorica> historialDeMediciones;
	Entrenamiento EntrenamientoDelDia;
	List<Logro> logros = new ArrayList();
	Creido creido;
	AdapterMedicion medicion;
	AdapterLogin login;

	public Usuario(String nombre, Sexo sexo, String fechaDeNacimiento, double altura) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.altura = altura;
		this.creido = new Creido(this, FireBase.getFireBase());
		this.medicion = Medicion.getMedicion();
	}

	@SuppressWarnings("deprecation")
	public int edad() throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formato.parse(this.fechaDeNacimiento);
		int year = Year.now().getValue();
		return year - (fecha.getYear() + 1900);
	}

	public void pesar() {
		historialDeMediciones
				.add(new MedicionHistorica(medicion.obtenerPeso(), medicion.obtenerGrasa(), medicion.obtenerMasa()));
		this.creido.entregarTrofeo();
		this.objetivo.getConstante().entregarTrofeo();
		this.objetivo.getDedicacion().entregarTrofeo();
	}

	public boolean verficarCumplimiento() {
		boolean cumplido = true;
		return cumplido;
	}

	public void registrarEjerciciosRealizados() {
		System.out.println("Registrá tus actividad");
	}

	public void comenzarEntrenamientoDelDia() {
		System.out.println("Listo para comenzar!");
	}

	public void ingresar() {
		this.login.ingresar();
	}

	public void completarDatos() throws ParseException {
		boolean validado = false;
		@SuppressWarnings("resource")
		Scanner ingresoDeDatos = new Scanner(System.in);
		String respuesta;
		while (!validado) {
			System.out.println("ELIJA SU SEXO BIOLOGICO\n1.MASCULINO\n2.FEMENINO");
			System.out.print("Su respuesta:");
			respuesta = ingresoDeDatos.nextLine();
			if (respuesta.equals("1")) {
				this.sexo = Sexo.MASCULINO;
				validado = true;
			} else if (respuesta.equals("2")) {
				this.sexo = Sexo.FEMENINO;
				validado = true;
			}
		}
		validado = false;
		while (!validado) {
			System.out.println("INGRESE SU FECHA DE NACIMIENTO. EJEMPLO 31/12/1980");
			System.out.print("Su respuesta:");
			respuesta = ingresoDeDatos.nextLine();
			if (!respuesta.equals("")) {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Date fecha = formato.parse(respuesta);
				this.fechaDeNacimiento = formato.format(fecha);
				validado = true;
			}
		}
		validado = false;
		while (!validado) {
			System.out.println("INGRESE SU ESTATURA EN METROS. EJEMPLO 1.8");
			System.out.print("Su respuesta:");
			respuesta = ingresoDeDatos.nextLine();
			if (!respuesta.equals("")) {
				try {
					this.altura = Double.valueOf(respuesta);
					validado = true;
				} catch (Exception e) {
					System.out.println("Dato inválido...");
				}
			}
		}
		validado = false;
		while (!validado) {
			System.out.println("INGRESE SU PESO EN KG. EJEMPLO 70.5");
			System.out.print("Su respuesta:");
			respuesta = ingresoDeDatos.nextLine();
			if (!respuesta.equals("")) {
				try {
					this.peso = Double.valueOf(respuesta);
					validado = true;
				} catch (Exception e) {
					System.out.println("Dato inválido...");
				}
			}
		}
	}

	public void elegirObjetivo() {
		boolean validado = false;
		@SuppressWarnings("resource")
		Scanner ingresoDeDatos = new Scanner(System.in);
		String respuesta;
		while (!validado) {
			System.out.println(
					"ELIJA UN OBJETIVO PARA COMENZAR\n1.Bajar de peso\n2.Tonificar el cuerpo\n3.Mantener la figura");
			System.out.print("Su respuesta:");
			respuesta = ingresoDeDatos.nextLine();
			if (respuesta.equals("1")) {
				this.objetivo = new Objetivo(new BajarPeso(this));
				validado = true;
			} else if (respuesta.equals("2")) {
				this.objetivo = new Objetivo(new TonificarCuerpo(this, this.medicion));
				validado = true;
			} else if (respuesta.equals("3")) {
				int margen = 5;
				while (!validado) {
					System.out.println(
							"INGRESE UN MARGEN ENTERO QUE CONSIDERE ACEPTABLE PARA MANTENER SU PESO EN KG. EJEMPLO 5");
					System.out.print("Su respuesta:");
					respuesta = ingresoDeDatos.nextLine();
					margen = Integer.valueOf(respuesta);
					if (margen > 0) {
						validado = true;
						this.objetivo = new Objetivo(new MantenerFigura(this, margen));
					}
				}
			}
		}
		this.objetivo.getDedicacion().entregarTrofeo();
		
		this.objetivo.generarRutina();
	}

	public Sexo getSexo() {
		return this.sexo;
	}

	public double getAltura() {
		return this.altura;
	}

	public MedicionHistorica getUltimoPesaje() {
		MedicionHistorica medicionHistorica = null;
		if (this.historialDeMediciones != null) {
			medicionHistorica = this.historialDeMediciones.get(this.historialDeMediciones.size() - 1);
		}
		return medicionHistorica;
	}

	public void recibirLogro(Logro nuevo) {
		this.logros.add(nuevo);
	}

	public List<MedicionHistorica> getMedicionesHistoricas() {
		return this.historialDeMediciones;
	}

	public double getPeso() {
		return this.peso;
	}
}
