package Alumnos;

import java.util.Comparator;

public class ordenamientoDeFechas implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int dia1 = Integer.parseInt( o1.split(" ")[1]);
		int dia2 = Integer.parseInt( o2.split(" ")[1]);
		
		if (dia1 < dia2)
			return -1;
		
		return 1;
	}

}
