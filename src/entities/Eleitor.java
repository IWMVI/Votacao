package entities;

public class Eleitor {
	
	private String name;
	private int voto;
	
	public Eleitor() {
		
	}
	
	public Eleitor(String name) {
		this.name = name;
	}
	
	public String getNome() {
		return name;
	}
	
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	public int getVoto() {
		return voto;
	}
}
