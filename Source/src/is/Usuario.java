package is;

import is.gui.UserWindow;

public class Usuario {

	public Usuario(String nombre, String contrasena){
		this.id = nombre;
		this.password = contrasena;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserWindow p = new UserWindow();
		p.setVisible(true);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String id;
	private String password;

}
