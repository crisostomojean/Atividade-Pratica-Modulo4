package dao;

import java.util.List;

import model.Destino;

public interface CRUDD {

	public static void create(Destino destino) {
	};

	public static void delete(int destinoId) {
	};

	public static List<Destino> find(String pesquisa1) {
		return null;
	}

	public static Destino findByPk(int destinoId) {
		return null;
	}

	public static void update(Destino destino) {
	}

}
