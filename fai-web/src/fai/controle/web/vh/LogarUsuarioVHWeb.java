package fai.controle.web.vh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fai.domain.EntidadeDominio;
import fai.domain.Resultado;
import fai.domain.Usuario;

public class LogarUsuarioVHWeb <U extends Usuario> implements IViewHelperWeb<U> {
	private Usuario usuario;
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request)
			throws ServletException, IOException {
		
		String agencia = request.getParameter("txtAgencia");
		String conta = request.getParameter("txtConta");
		String senha = request.getParameter("txtSenha");		
		
		usuario.setAgencia(agencia);
		usuario.setConta(conta);
		usuario.setSenha(senha);			
		
		return usuario;
	}

	@Override
	public void setView(Resultado rs, HttpServletRequest rq,
			HttpServletResponse rp) throws ServletException, IOException {
		if(rs.getEntidades().size() > 0){
			//rq.setAttribute("cli", cliente);
			rq.getRequestDispatcher("FormUsuario.html").
				forward(rq, rp);
		}else{
			rq.getRequestDispatcher("FormLogin.html").
			forward(rq, rp);			
		}
	}

	@Override
	public void setEntidade(U entidade) {
		this.usuario = entidade;		
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	

}
