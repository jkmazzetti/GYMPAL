package Java.main;

import java.util.List;
import java.util.Scanner;

import ClasesExternas.LoginExterno;

public class Login extends AdapterLogin {

	private Login() {

	}

	@Override
	public List<String> obtenerDatos() {
		return null;
	}

	@Override
	public void guardarDatos() {

	}

	@Override
	public boolean hacerLogin() {
		boolean validado = loginExterno.loguearse(nombreUsuarioString + password);
		String usuarioIngresado = "", passwordIngresado = "";
		while (!validado) {
			@SuppressWarnings("resource")
			Scanner userName = new Scanner(System.in);
			System.out.println("INGRESE SU USUARIO");
			System.out.print("Su respuesta:");
			usuarioIngresado = userName.nextLine();
			@SuppressWarnings("resource")
			Scanner userPassword = new Scanner(System.in);
			System.out.println("INGRESE SU CONTRASEÑA");
			System.out.print("Su respuesta:");
			passwordIngresado = userPassword.nextLine();
			validado = loginExterno.loguearse(usuarioIngresado + passwordIngresado);
			if (!validado) {
				System.out.println("No hemos podido validar su ideantidad");
			} else {
				System.out.println("Bienvenido " + usuarioIngresado);
			}
		}
		return validado;
	}

	@Override
	public boolean registrar() {
		boolean validado = false;
		String usuario = "", password = "", repeticion;
		while (!validado) {
			@SuppressWarnings("resource")
			Scanner ingresoDeDatos = new Scanner(System.in);
			System.out.println("ELIJA SU NOMBRE DE USUARIO");
			System.out.print("Su respuesta:");
			usuario = ingresoDeDatos.nextLine();
			System.out.println("INGRESE UNA CONTRASEÑA");
			System.out.print("Su respuesta:");
			password = ingresoDeDatos.nextLine();
			System.out.println("REPITA SU CONTRASEÑA");
			System.out.print("Su respuesta:");
			repeticion = ingresoDeDatos.nextLine();
			validado = password.equals(repeticion);
			if (!validado) {
				System.out.println("No hemos podido regitrarlo, vuelva intentarlo.");
				registrar();
			} else {
				this.usuario = new Usuario(usuario, null, null, 0);
			}
		}
		loginExterno.setUser(usuario);
		loginExterno.setPass(password);
		System.out.println("Se registró correctamente.");
		return validado;
	}

	@Override
	public void ingresar() {
		boolean validado = false;
		while (!validado) {
			@SuppressWarnings("resource")
			Scanner ingreso = new Scanner(System.in);
			System.out.println("BIENVENIDO ELIJA UNA OPCION\n1.Registro\n2.Login");
			System.out.print("Su respuesta:");
			String elegida = ingreso.nextLine();
			if (elegida.equals("1")) {
				registrar();
			} else if (elegida.equals("2")) {
				validado = hacerLogin();
			} else {
				System.out.println("Opción inválida, vuelva a intentarlo");
			}
		}
	}

	public static Usuario ingreso() {
		Login login = new Login();
		login.ingresar();
		return new Usuario(null, null, null, 0);
	}

}
