package uniandes.dpoo.aerolinea.modelo.cliente;
import java.util.UUID;

public class ClienteNatural extends Cliente 
{
	public static String NATURAL = "Natural";
	private String nombre;
	private String id;
	private String tipoCliente;
	
	public ClienteNatural(String nombre)
	{
		this.nombre = nombre;
		this.id = UUID.randomUUID().toString(); 
		this.tipoCliente = NATURAL;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getIdentificador() {
		
		return id;
	}

	@Override
	public int getTamanoEmpresa() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
