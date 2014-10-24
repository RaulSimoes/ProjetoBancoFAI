
package fai.controle.impl;

import java.util.List;
import java.util.Map;

import fai.core.controle.IFachada;
import fai.dao.IDAO;
import fai.dao.jpa.impl.UsuarioJpaDAO;
import fai.domain.EntidadeDominio;
import fai.domain.Mensagem;
import fai.domain.Resultado;
import fai.domain.Usuario;
import fai.negocio.ICommand;



public class Fachada<F extends EntidadeDominio> implements IFachada<F> {
	private Map<String, IDAO> daos;
	private Map<String, List<ICommand>> rns;		
	private UsuarioJpaDAO<Usuario> usuarioJpaDAO;
	
	@Override
	public Resultado<F> salvar(F entidade) {
		IDAO<F> dao = daos.get(entidade.getClass().getName());
		dao.salvar(entidade);
		return null;
	}

	
	@Override
	public Resultado<F> alterar(F entidade) {
		IDAO<F> dao = daos.get(entidade.getClass().getName());
		dao.alterar(entidade);
		return null;
	}

	
	@Override
	public Resultado<F> consultar(F entidade) {	
		IDAO<F> dao = daos.get(entidade.getClass().getName());
        Resultado<F> r = null;
        List<F> entidades = dao.consultar(entidade);
        if( entidades != null){
        	r = new Resultado<F>();
        	r.setEntidades(entidades);    
        }
        return r;
	}
	
	@Override
	public Resultado<F> excluir(F entidade) {
		return null;
	}


	public void setDaos(Map<String, IDAO> daos) {
		this.daos = daos;
	}

	
	
	public Resultado<F> pagar(F entidade, String numBoleto){
	    //TransacaoJpaDAO dao = (TransacaoJpaDAO) daos.get(entidade.getClass().getName());
        Resultado<F> r = null;
        
		String nmClasse = entidade.getClass().getName();
		List<ICommand> cmds = rns.get(nmClasse);
				
		for(ICommand cmd : cmds){					
			String msg = cmd.execute(entidade);
			if(msg != null)
				r.getMensagens().add(new Mensagem(msg));
				//msgs.add(new Mensagem(msg));
		}		
		if(r.getMensagens().size() == 0){
			IDAO dao = daos.get(nmClasse);			
			dao.salvar(entidade);
			return null;
		}else{			
			return r;
		}	
	}
	
	
}
