package Java.main;

import java.util.List;
import java.util.Scanner;

import ClasesExternas.LoginExterno;

public abstract class AdapterLogin {
	protected AdapterLogin login;
	protected Usuario usuario;
	protected String nombreUsuarioString;
	protected String password;
	protected LoginExterno loginExterno = new LoginExterno();

	public abstract List<String> obtenerDatos();

	public abstract void guardarDatos();

	public abstract boolean registrar();

	public abstract boolean hacerLogin();

	public abstract void ingresar();
}
