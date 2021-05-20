package UML;

import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {
	
		//energia total = 95
		Pato p = new Pato("pato", false);
		
		//energia total = 70
		Avestruz a = new Avestruz("avestruz", false);
		
		//energia total = 105
		Murcielago m = new Murcielago("murcielago", false);
		
		//energia total = 145
		Nutria n = new Nutria("nutria", true);
		
		ArrayList<Animal> animales = new ArrayList<Animal>();	
		ArrayList<Volador> voladores = new ArrayList<Volador>();
		ArrayList<Nadador> nadadores = new ArrayList<Nadador>();
		
		animales.add(p);animales.add(n);animales.add(a);animales.add(m);
		
		voladores.add(m);voladores.add(p);
		
		nadadores.add(p);nadadores.add(n);
		
		for(Animal animal: animales) {
			System.out.println(animal.getNombre()+"   "+animal.energiaTotal());
		}	
		
		for(Volador volador: voladores) {
			volador.volar();
		}
		
		for(Nadador nadador: nadadores) {
			nadador.nadar();
		}
	}
}
