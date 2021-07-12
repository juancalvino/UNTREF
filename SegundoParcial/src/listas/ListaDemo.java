package listas;

public class ListaDemo {
	public static <T> void main(String[] args) {
		ListaSE<Integer> lista = new ListaSE<Integer>();
		
		lista.add(25);
		lista.add(38);
		lista.add(57);
		lista.add(7);
		lista.add(8);
		lista.add(157);
		lista.add(21);
		lista.add(84);
		lista.add(75);
		lista.add(52);
		lista.add(1);
		lista.add(0);
		
		IteradorLSE<Integer> it = lista.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("Retrocediendo....");
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
		
		it.next();//0
		it.next();//1
		System.out.println("llamadas sucesivas a next y previous devuelven el mismo elemento");
		System.out.println(it.next());//52
		System.out.println(it.previous());//52 
		System.out.println(it.next());//52
		System.out.println(it.previous());//52 
	}
	

}
