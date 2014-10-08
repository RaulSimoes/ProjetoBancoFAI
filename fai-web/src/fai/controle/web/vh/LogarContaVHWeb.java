package fai.controle.web.vh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fai.domain.Conta;
import fai.domain.EntidadeDominio;
import fai.domain.Resultado;

public class LogarContaVHWeb <C extends Conta> implements IViewHelperWeb<C> {
	private Conta conta;
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request)
			throws ServletException, IOException {
		
		String agencia = request.getParameter("txtAgencia");
		String num_Conta = request.getParameter("txtConta");
		String senha = request.getParameter("txtSenha");		
		
		conta.setAgencia(agencia);
		conta.setNum_conta(num_Conta);
		conta.setSenha(senha);			
		
		return conta;
	}

	@Override
	public void setView(Resultado rs, HttpServletRequest rq,
			HttpServletResponse rp) throws ServletException, IOException {
		if(rs.getEntidades().size() > 0){
			//Conta conta = (Conta)rs.getEntidades().get(0);
			//if(usuario.getTipo_cliente().equals("Cliente")){
				rq.getRequestDispatcher("FormUsuario.html").forward(rq, rp);//direcionar para página do cliente				
			//}else{
			//	rq.getRequestDispatcher("FormUsuario.html").forward(rq, rp); //direcionar para página do funcionario			
			//}
		}else{
			rq.getRequestDispatcher("FormLogin.html").
			forward(rq, rp);			
		}
	}

	@Override
	public void setEntidade(C entidade) {
		this.conta = entidade;		
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}	

}
