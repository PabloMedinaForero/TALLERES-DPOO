package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas
{
	protected int COSTO_POR_KM = 1000;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente)
	{
		int costoBase = 0;
		Ruta ruta = vuelo.getRuta();
		int distancia = calcularDistanciaVuelo​(ruta);
		costoBase = distancia * COSTO_POR_KM;
		return costoBase;
	}
	
	public double calcularPorcentajeDescuento​(Cliente cliente)
	{
		double descuento = 0;
		int historia = cliente.calcularValorTotalTiquetes();
		if(historia > 1000)
		{
			descuento = 0.2;
		}	
		return descuento;
	}
	
	

}
