package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas 
{
	public static double IMPUESTO = 0.28;
	
	public int calcularTarifa​(Vuelo vuelo, Cliente cliente)
	{
		int precioFinal = 0;
		int CostoBase = calcularCostoBase​(vuelo, cliente);
		int descuento = (int) calcularPorcentajeDescuento​(cliente);
		int ValorImpuesto = calcularValorImpuestos​(CostoBase - descuento);
		precioFinal = CostoBase - descuento + ValorImpuesto;
		return precioFinal;
	}
	protected abstract int calcularCostoBase​(Vuelo vuelo, Cliente cliente);
	protected abstract double calcularPorcentajeDescuento​(Cliente cliente);
	
	protected int calcularDistanciaVuelo​(Ruta ruta) 
	{
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto destino = ruta.getOrigen();
		int distancia = origen.calcularDistancia(origen,destino);
		return distancia;
	}
	
	protected int calcularValorImpuestos​(int costoBase)
	{
		int precioFinal = 0;
		
		precioFinal = (int) (IMPUESTO/costoBase);
		
		return precioFinal;
	}
}
