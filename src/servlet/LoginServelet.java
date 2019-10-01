package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import bean.BeanServlet;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginServelet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BeanServlet beanServelet = new BeanServlet();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		//Uma forma de se fazer:
//		Boolean teste  = beanServelet.validarLoginSenha(logi n, senha);
//		if(teste == true){
//			response.sendRedirect("/curso-servlet-sjp/acessoLiberado.jsp");
//		} else {
//			response.sendRedirect("/curso-servlet-sjp/acessoNegado.jsp");
//		}
		
		//Outra forma de se fazer(curso):
		if(beanServelet.validarLoginSenha(login, senha)){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/acessoLiberado.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/acessoNegado.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
