package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;
import java.util.UUID;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{
	
    public static String CORPORATIVO = "Corporativo";
    public static int GRANDE = 1;
    public static int MEDIANA = 2;
    public static int PEQUENA = 3;
    private String nombreEmpresa;
    private int tamanoEmpresa;
    private String tipoCliente;
    private String id;


    /**
     * Crea un nuevo objeto de tipo a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * @param cliente El objeto JSON que contiene la información
     * @return El nuevo objeto inicializado con la información
     */
    public static ClienteCorporativo cargarDesdeJSON( JSONObject cliente )
    {
        String nombreEmpresa = cliente.getString( "nombreEmpresa" );
        int tam = cliente.getInt( "tamanoEmpresa" );
        return new ClienteCorporativo( nombreEmpresa, tam );
    }

    /**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject para que ese objeto se almacene en un archivo
     * @return El objeto JSON con toda la información del cliente corporativo
     */
    public JSONObject salvarEnJSON( )
    {
        JSONObject jobject = new JSONObject( );
        jobject.put( "nombreEmpresa", this.nombreEmpresa );
        jobject.put( "tamanoEmpresa", this.tamanoEmpresa );
        jobject.put( "tipo", CORPORATIVO );
        return jobject;
    }
    
    public ClienteCorporativo(String nombreEmpresa, int tamano)
    {
    	super();
    	this.nombreEmpresa = nombreEmpresa;
    	//determinar tamanio empresa
    	if (tamano == GRANDE)
    	{
    		this.tamanoEmpresa = GRANDE;
    	}
    	else if (tamano == MEDIANA)
    	{
    		this.tamanoEmpresa = MEDIANA;
    	}
    	else if (tamano == PEQUENA)
    	{
    		this.tamanoEmpresa = PEQUENA;
    	}
    	
    	this.tamanoEmpresa = tamano;
    	this.tipoCliente = CORPORATIVO;
    	this.id = UUID.randomUUID().toString(); 
    	
    }

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public int getTamanoEmpresa() {
		return tamanoEmpresa;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getIdentificador() {
		return id;
	}
    
    
    
}
