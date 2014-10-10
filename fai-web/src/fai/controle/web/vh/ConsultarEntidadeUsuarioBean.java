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
	ControllerJSF controleJSF;
	
	public ConsultarEntidadeUsuarioBean (){
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	public List<Usuario> listarUsuario() throws ServletException, IOException{
			
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		
		usuario = new Usuario();
		
		controleJSF = new ControllerJSF();
		Resultado rs = controleJSF.processRequest(this.getClass().getName(), usuario);
		
		//Usuario usuario = (Usuario) rs.getEntidades().get(0);
		
		listaUsuario = (List<Usuario>) rs.getEntidades(); //carrega para dentro da lista
		
		//System.out.println(usuario.getNome());
		
		/*for (Object o : rs.getEntidades()) {
			Usuario usu = (Usuario)o; 
			System.out.println(usu.getNome());
		}*/
		
		return listaUsuario;
		//return (String) "FormListarUsuario";
	}
	
	public List<Usuario> teste() throws ServletException, IOException {
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		return listaUsuario;
	}

	public Resultado consultar(EntidadeDominio entidade) throws ServletException, IOException{
		controleJSF = new ControllerJSF();
		return controleJSF.processRequest(this.getClass().getName(), entidade);						
	}	
	
}
