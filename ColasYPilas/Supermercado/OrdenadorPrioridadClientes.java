import java.util.Comparator;

public class OrdenadorPrioridadClientes implements Comparator<Cliente>{

	@Override
	public int compare(Cliente o1, Cliente o2) {
		
		if(o2.getTipo() != TipoCliente.COMUN    )
			return 1;
		
		if(o1.getTipo() != TipoCliente.COMUN )
			return -1;

		
		return 0;
	}

}
