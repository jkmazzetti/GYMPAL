package Java.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Entrenamiento {
	private Map<GrupoMuscular, List<Ejercicio>> ejercicios;
	private boolean completado=false;
	private boolean reforzado=false;
	public List<Ejercicio> getEjercicios (GrupoMuscular grupo){
		return this.ejercicios.get(grupo);
	}
	@SuppressWarnings("unchecked")
	public List<GrupoMuscular> getGruposMusculares(){
		return (List<GrupoMuscular>) ejercicios.keySet();
	}
	public void reforzar() {
		
	}
	public void agregarEjercicio(Ejercicio ejercicio) {
		List<Ejercicio> list=new ArrayList();
		if(this.ejercicios.containsKey(ejercicio.getGrupoMuscular())) {
			list=ejercicios.get(ejercicio.getGrupoMuscular());
			list.add(ejercicio);
			this.ejercicios.put(ejercicio.getGrupoMuscular(),list);
		}else {
			list.add(ejercicio);
			this.ejercicios.put(ejercicio.getGrupoMuscular(),list);
		}
	}
	
}
