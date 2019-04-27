package com.objis.cameroun.Rexam.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.objis.cameroun.Rexam.domaine.Abonnes;
import com.objis.cameroun.Rexam.service.IEleveService;
import com.objis.cameroun.Rexam.service.impl.EleveService;
/**
 * Servlet implementation class AddAbonnesServlet
 */
@WebServlet(description = "Servlet permettant d'enregistrer les abonnés", urlPatterns = { "/AddAbonnesServlet" })
public class AddAbonnesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public AddAbonnesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matricule=request.getParameter("matricule");
		int telephone=Integer.parseInt(request.getParameter("telephone"));
		
		Abonnes abonnes = new Abonnes(matricule, telephone);
		IEleveService iEleveService = new EleveService();
		
		int statuts=iEleveService.addAbonnesService(abonnes);
		
		if(statuts==1) {
			
		}
		
		
		request.setAttribute("addSuccess", Integer.valueOf(statuts));
		
		request.getRequestDispatcher("index.jsp")
		.forward(request,response);
	}

}
