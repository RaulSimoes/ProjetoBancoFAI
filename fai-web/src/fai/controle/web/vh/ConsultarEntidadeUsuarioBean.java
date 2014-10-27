package fai.controle.web.vh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fai.controle.web.impl.ControllerJSF;
import fai.domain.EntidadeDominio;
import fai.domain.Resultado;
import fai.domain.Usuario;

@ManagedBean
public class ConsultarEntidadeUsuarioBean{
	
	private Usuario usuario;
	private List<Usuario> listaDeUsuario = new ArrayList<Usuario>();
	ControllerJSF controleJSF;
	
	public ConsultarEntidadeUsuarioBean () throws ServletException, IOException{
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}	
	
	public String listarUsuario() throws ServletException, IOException{
				
		usuario = new Usuario();
		controleJSF = new ControllerJSF();
		Resultado rs = controleJSF.processRequest(this.getClass().getName(), usuario,"");
		
		//Usuario usuario = (Usuario) rs.getEntidades().get(0);
		listaDeUsuario = (List<Usuario>) rs.getEntidades(); //carrega para dentro da lista
		
		//System.out.println(usuario.getNome());
		/*for (Object o : rs.getEntidades()) {
			Usuario usu = (Usuario)o; 
			System.out.println(usu.getNome());
		}*/
		//return (String) "FormListarUsuario";
		
		return (String) "FormConsultarUsuario";
	}
	
	public Resultado consultar(EntidadeDominio entidade) throws ServletException, IOException{
		controleJSF = new ControllerJSF();
		return controleJSF.processRequest(this.getClass().getName(), entidade,"");						
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaDeUsuario() {
		return listaDeUsuario;
	}

	public void setListaDeUsuario(List<Usuario> listaDeUsuario) {
		this.listaDeUsuario = listaDeUsuario;
	}

	public ControllerJSF getControleJSF() {
		return controleJSF;
	}

	public void setControleJSF(ControllerJSF controleJSF) {
		this.controleJSF = controleJSF;
	}
}
