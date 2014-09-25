package fai.controle.web.vh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fai.domain.Categoria;
import fai.domain.EntidadeDominio;
import fai.domain.Resultado;
import fai.domain.Usuario;

public class LogarUsuarioVHWeb <C extends Usuario> implements IViewHelperWeb<C> {
	private Usuario usuario;
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request)
			throws ServletException, IOException {
		String agencia = request.getParameter("txtAgencia");
		String conta = request.getParameter("txtConta");
		String senha = request.getParameter("txtSenha");		
		
		usuario.setAgencia(agencia);
		usuario.setAgencia(conta);
		usuario.setAgencia(senha);			
		
		return usuario;
	}

	@Override
	public void setView(Resultado rs, HttpServletRequest rq,
			HttpServletResponse rp) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	}

	@Override
	public void setEntidade(C entidade) {
		this.usuario = entidade;		
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	

}
