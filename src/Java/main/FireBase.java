package Java.main;

public class FireBase {
	private static FireBase fireBase = null;

	private FireBase() {

	}
	public static FireBase getFireBase() {
		if (fireBase == null) {
			fireBase = new FireBase();
		}
		return fireBase;
	}

	public static void notificar(String mensaje) {		
		System.out.println(mensaje);
	}
}
