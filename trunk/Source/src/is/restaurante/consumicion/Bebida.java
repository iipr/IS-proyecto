package is.restaurante.consumicion;

public class Bebida implements Consumicion{

	@Override
	public float getPrecio() {
		// TODO Auto-generated method stub
		return this.precio;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return this.descripción;
	}

	@Override
	public boolean isDisponible() {
		// TODO Auto-generated method stub
		return this.disponible;
	}

	private String descripción;
	private String nombre;
	private float precio;
	private boolean disponible;
}
