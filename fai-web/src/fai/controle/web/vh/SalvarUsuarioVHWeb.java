
package fai.controle.web.vh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fai.domain.EntidadeDominio;
import fai.domain.Resultado;
import fai.domain.Usuario;


public class SalvarUsuarioVHWeb<C extends Usuario> implements IViewHelperWeb<C> {
	private Usuario usuario;
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request)
			throws ServletException, IOException {
		String nome = request.getParameter("txtNome");
		String conta = request.getParameter("txtConta");
		String cpf = request.getParameter("txtCpf");
		String senha = request.getParameter("txtSenha");
		
		String saldo = request.getParameter("txtSaldo");
		String salario = request.getParameter("txtSalario");
		String limite_credito = request.getParameter("txtLimCredito");
		
		String agencia = request.getParameter("txtAgencia");
		String tipo_cliente = request.getParameter("txtTpCliente");
			
		usuario.setNome(nome);
		usuario.setConta(conta);
		usuario.setCpf(cpf);
		usuario.setSenha(senha);
		
		usuario.setSaldo(Float.valueOf(saldo));
		usuario.setSalario(Float.valueOf(salario));
		usuario.setLimite_credito(Float.valueOf(limite_credito));
		
		usuario.setAgencia(agencia);
		usuario.setTipo_cliente(tipo_cliente);	
		
		return usuario;
	}
	
	/** 
	 * TODO Descrição do Método
	 * @param rs
	 * @param rq
	 * @param rp
	 * @throws ServletException
	 * @throws IOException
	 * @see fai.controle.web.vh.IViewHelperWeb#setView(fai.domain.Resultado, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void setView(Resultado rs, HttpServletRequest rq, HttpServletResponse rp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * TODO Descrição do Método
	 * @param entidade
	 * @see fai.controle.web.vh.IViewHelperWeb#setEntidade(fai.domain.EntidadeDominio)
	 */
	@Override
	public void setEntidade(C entidade) {
		this.usuario = entidade;
		
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}




}
