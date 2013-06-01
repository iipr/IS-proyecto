package is.restaurante;

import java.util.ArrayList;
import java.util.Vector;

public class Mesa implements MesaInfo{
	
	public Mesa(int num){
		this.setNumeroMesa(num);
	}
	
	public void addPedido(Comanda comanda){
		pedidos.add(comanda);
		//pedidos.
	}
	
//TODO editComanda, selectComanda delete Comanda
	
	
	public int getNumeroMesa() {
		return numeroMesa;
	}
	
	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	public String generarFactura(){
		String factura = "";
		for (Comanda c : pedidos){
			factura += c.toString() + LINE_SEPARATOR;
		}
		//return pedidos.toString();
		return factura;
	}
	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	

	private Vector<Comanda> pedidos;
	private int numeroMesa;
	private int capacidadMaxima;
}
