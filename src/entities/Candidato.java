package entities;

public class Candidato {

	private String name;
	private int partido;
	private int votos;

	public Candidato() {

	}

	public Candidato(String name, int partido) {
		this.name = name;
		this.partido = partido;
	}

	public String getNome() {
		return name;
	}

	public int getPartido() {
		return partido;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}
}
