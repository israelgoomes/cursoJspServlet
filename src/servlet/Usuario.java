package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BeanServlet;
import bean.BeanUsuarioTelefone;
import dao.DaoUsuario;
@WebServlet("/salvarUsuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private DaoUsuario usuarioDao = new DaoUsuario();

	private String idUser;
	private List<BeanServlet> listaUsuario;
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = (request.getParameter("acao"));
		String user = (request.getParameter("user"));
		try {
		if(acao.equalsIgnoreCase("delete")) {
			usuarioDao.delete(user);
			RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
		
				request.setAttribute("usuarios", usuarioDao.listaUsuario());
				view.forward(request, response);
		}else if(acao.equalsIgnoreCase("editar")) {
			BeanServlet bean = usuarioDao.consultar(user);
			RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", bean);
				view.forward(request, response);
			
		}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idUser = request.getParameter("idUser");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String celular = request.getParameter("celular");
		String residencial = request.getParameter("residencial");
		BeanServlet usuario = new BeanServlet();
		BeanUsuarioTelefone telefone = new BeanUsuarioTelefone();
		
		usuario.setIdUser(!idUser.isEmpty() ? Long.parseLong(idUser) : 0);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		try {
			listaUsuario = usuarioDao.listaUsuario();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		telefone.setCelular(celular);
		telefone.setResidencial(residencial);
		telefone.setIdUser(!idUser.isEmpty() ? Long.parseLong(idUser) : 0);
		
		if(idUser == null || idUser.isEmpty()) {
			usuarioDao.salvarUsuario(usuario);
			usuarioDao.sslvarTelefoneUsuario(telefone);
			
		}else {
			usuarioDao.atualizar(usuario);
		}
		
			
		
		
		try {
		RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
		request.setAttribute("usuarios", usuarioDao.listaUsuario());
		//fazendo o redirecionamento.
		view.forward(request, response);
		/*RequestDispatcher userByTel = request.getRequestDispatcher("/cadastroUsuario.jsp");
		request.setAttribute("userTel", usuarioDao.listarUsuarioTelefone());*/
		//fazendo o redirecionamento.
		//userByTel.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		}

}
