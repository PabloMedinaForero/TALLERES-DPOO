package uniandes.dpoo.aerolinea.modelo.cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
public abstract class Cliente
{
    protected String tipoCliente;
    private List<Tiquete> tiquetesSinUsar;
    private List<Tiquete> tiquetesUsados;
    
    
	public Cliente()
	{
		super();
		if (tipoCliente == "Natural")
		{
			//Pedir nombre cliente
			Scanner scanner = new Scanner(System.in);  
			System.out.print("Ingrese su nombre: ");
	        String nombre = scanner.nextLine();  
			new ClienteNatural(nombre);
		}
		else if (tipoCliente == "Corporativo")
		{
			//Pedir nombre empresa
			Scanner scanner = new Scanner(System.in);  
			System.out.print("Ingrese el nombre de la empresa: ");
	        String nombreEmpresa = scanner.nextLine(); 
	        //Poner tamano empresa
	        Random random = new Random();
	        int tamano = random.nextInt(3) + 1; 
			new ClienteCorporativo(nombreEmpresa, tamano);
		}

	}

	public String getTipoCliente() {
		return tipoCliente;
	}
		
	public abstract String getIdentificador();
	
	public void agregarTiquete(Tiquete tiquete)
	{
		this.tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes()
	{
		int valorTiquetes = 0;
		for (int i = 0; i<tiquetesUsados.size();i++)
		{
			Tiquete tiquete = tiquetesUsados.get(i);
			valorTiquetes += tiquete.getTarifa(); 
		}
		return valorTiquetes;
	}
	public void usarTiquete(Vuelo vuelo)
	{
		List<Tiquete> listaVuelos = (List<Tiquete>) vuelo.getTiquetes();
		
		for (int i = 0;i<listaVuelos.size();i++)
		{
			Tiquete tiquete = listaVuelos.get(i);
			Cliente cliente = tiquete.getCliente();
			if (cliente.equals(this))
			{
				tiquete.marcarComoUsado();
				tiquetesSinUsar.remove(tiquete);
				tiquetesUsados.add(tiquete);
			}
		}
	}

	public abstract int getTamanoEmpresa();
	
}
