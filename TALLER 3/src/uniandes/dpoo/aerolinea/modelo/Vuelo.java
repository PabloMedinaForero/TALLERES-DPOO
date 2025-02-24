package uniandes.dpoo.aerolinea.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo 
{
	private Avion avion;
	private Ruta ruta;
	private Map<String,Tiquete> tiquetes;
	
	private String fecha;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion)
	{
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
	}

	public Avion getAvion() {
		return avion;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public Collection<Tiquete> getTiquetes() 
	{
		List <Tiquete> list = (List<Tiquete>) tiquetes.values();
		return list;
	}

	public String getFecha() {
		return fecha;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException
	{
		GeneradorTiquetes GeneradorTiquetes = new GeneradorTiquetes() ;
		int tarifa = calculadora.calcularTarifa​(this, cliente);
		int cantidadVendida = 0;
		if(getTiquetes().size() <= 30)
		{
			if(getTiquetes().size() + cantidad <= 30)
			{
				for (int i = 0; i<cantidad;i++)
				{
					Tiquete tiqueteNuevo = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
					String codigo = tiqueteNuevo.getCodigo();
					cantidadVendida = cantidad;
					tiquetes.put(codigo, tiqueteNuevo);
				}
			}
			else
			{
				throw new VueloSobrevendidoException(this);
			}
		}
		return cantidadVendida;
	}
	public boolean equals​(Object obj)
	{
		return true;
	}
	
	
	
}
