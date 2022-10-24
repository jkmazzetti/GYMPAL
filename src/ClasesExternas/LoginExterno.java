package ClasesExternas;

/*
 * Se creó esta clase para poder hacer la ejecucion del programa.
*/
public class LoginExterno {
	private String user="admin";
	private String pass="";
	public boolean loguearse(String usernameAndPassword) {
		return usernameAndPassword.equals(user+pass);
	}
	public void setUser(String user) {
		this.user=user;
	}
	public void setPass(String pass) {
		this.pass=pass;
	}
}
