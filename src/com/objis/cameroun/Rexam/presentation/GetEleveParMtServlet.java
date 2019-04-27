package com.objis.cameroun.Rexam.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objis.cameroun.Rexam.domaine.Eleve;
import com.objis.cameroun.Rexam.service.IEleveService;
import com.objis.cameroun.Rexam.service.impl.EleveService;

/**
 * Servlet implementation class GetEleveParMtServlet
 */
@WebServlet("/GetEleveParMtServlet")
public class GetEleveParMtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEleveParMtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matricule = request.getParameter("matricule");
		IEleveService iEleveService = new EleveService();
		Eleve eleve = iEleveService.getEleveParMtService(matricule);
		
		request.setAttribute("eleve", eleve);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
