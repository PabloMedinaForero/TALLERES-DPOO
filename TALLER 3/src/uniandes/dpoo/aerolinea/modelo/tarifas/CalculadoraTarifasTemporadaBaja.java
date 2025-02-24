package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas
{
	protected int COSTO_POR_KM_NATURAL = 600;
	protected int COSTO_POR_KM_CORPORATIVO = 900;
	protected double DECUENTO_PEQ = 0.02;
	protected double DECUENTO_MEDIANAS = 0.1;
	protected double DESCUENTO_GRANDES = 0.2;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente)
	{
		int costoBase = 0;
		String tipoCliente = cliente.getTipoCliente();
		Ruta ruta = vuelo.getRuta();
		int distancia = calcularDistanciaVuelo​(ruta);
		if (tipoCliente == "Corporativo")
		{
			costoBase = distancia * COSTO_POR_KM_CORPORATIVO;
		}		
		return costoBase; 
	}
	
	public double calcularPorcentajeDescuento​(Cliente cliente)
	{
		double descuento = 0;
		String tipoCliente = cliente.getTipoCliente();
		if (tipoCliente == "Corporativo")
		{
			int tamano = cliente.getTamanoEmpresa();
			if (tamano == 1)
			{
				descuento = DECUENTO_PEQ;
			}
			else if (tamano == 2)
			{
				descuento = DECUENTO_MEDIANAS;
			}
			else if (tamano == 3)
			{
				descuento = DESCUENTO_GRANDES;
			}	
		}
		else 
		{
			int historia = cliente.calcularValorTotalTiquetes();
			if(historia > 1000)
			{
				descuento = 0.2;
			}			
		}
	return descuento;
	}
}
