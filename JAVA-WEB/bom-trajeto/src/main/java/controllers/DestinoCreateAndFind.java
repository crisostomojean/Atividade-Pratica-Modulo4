package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDao;

import model.Destino;

@WebServlet("/DCreateAndFind")
public class DestinoCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DestinoCreateAndFind() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pesquisa1 = request.getParameter("pesquisa1");

		if (pesquisa1 == null) {
			pesquisa1 = "";
		}

		List<Destino> destinos = DestinoDao.find(pesquisa1);

		request.setAttribute("destinos", destinos);
		RequestDispatcher requesDispatcher = request.getRequestDispatcher("lista2.jsp");
		requesDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Destino destino = new Destino();

		destino.setNome(request.getParameter("nome"));
		destino.setDestino(request.getParameter("destino"));
		destino.setDataentrada(request.getParameter("dataentrada"));
		destino.setDatasaida(request.getParameter("datasaida"));

		DestinoDao.create(destino);

		doGet(request, response);
	}

}
