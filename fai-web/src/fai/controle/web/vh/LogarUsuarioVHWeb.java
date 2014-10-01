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
		
		/*usuario.setAgencia(agencia);
		usuario.setConta(conta);
		usuario.setSenha(senha);*/			
		
		return usuario;
	}

	@Override
	public void setView(Resultado rs, HttpServletRequest rq,
			HttpServletResponse rp) throws ServletException, IOException {
		if(rs.getEntidades().size() > 0){
			Usuario usuario = (Usuario)rs.getEntidades().get(0);
			if(usuario.getTipo_cliente().equals("Cliente")){
				rq.getRequestDispatcher("FormUsuario.html").forward(rq, rp);//direcionar para página do cliente				
			}else{
				rq.getRequestDispatcher("FormUsuario.html").forward(rq, rp); //direcionar para página do funcionario			
			}
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
