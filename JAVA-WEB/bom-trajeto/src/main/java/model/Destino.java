package model;

public class Destino {
	private int id;
	private String nome;
	private String destino;
	private String dataentrada;
	private String datasaida;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDataentrada() {
		return dataentrada;
	}

	public void setDataentrada(String dataentrada) {
		this.dataentrada = dataentrada;
	}

	public String getDatasaida() {
		return datasaida;
	}

	public void setDatasaida(String datasaida) {
		this.datasaida = datasaida;
	}

	@Override
	public String toString() {
		return "Destino [id=" + id + ", nome=" + nome + ", destino=" + destino + ", dataentrada=" + dataentrada
				+ ", datasaida=" + datasaida + "]";
	}

}