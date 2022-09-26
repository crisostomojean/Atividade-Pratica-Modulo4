package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDao;

@WebServlet("/DDelete")
public class DestinoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DestinoDelete() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int destinoId = Integer.parseInt(request.getParameter("destinoId"));
		DestinoDao.delete(destinoId);

		DestinoCreateAndFind destinoCreateAndFind = new DestinoCreateAndFind();
		destinoCreateAndFind.doGet(request, response);

	}

}
