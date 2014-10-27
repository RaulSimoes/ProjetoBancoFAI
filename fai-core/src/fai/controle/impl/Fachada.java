
package fai.controle.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import fai.core.controle.IFachada;
import fai.dao.IDAO;
import fai.dao.jpa.impl.BoletoJpaDAO;
import fai.dao.jpa.impl.ContaJpaDAO;
import fai.dao.jpa.impl.UsuarioJpaDAO;
import fai.domain.Boleto;
import fai.domain.Conta;
import fai.domain.EntidadeDominio;
import fai.domain.Resultado;
import fai.domain.Usuario;
import fai.negocio.ICommand;
import fai.negocio.impl.DebitadorConta;
import fai.negocio.impl.PagadorBoleto;
import fai.negocio.impl.ValidadorBoleto;
import fai.negocio.impl.VerificadorSaldoConta;


//@Repository("fachada")
public class Fachada<F extends EntidadeDominio> implements IFachada<F> {
	private Map<String, IDAO> daos;
	private Map<String, List<ICommand>> rns;	
	private Boleto boleto;
	
	public Fachada() {
		/*
		//Commands de negócio 
		rns = new HashMap<String, List<ICommand>>();
		
		List<ICommand> rnsTransacaoPagarBoleto = new ArrayList<ICommand>();
		rnsTransacaoPagarBoleto.add( new ValidadorBoleto());
		rnsTransacaoPagarBoleto.add( new VerificadorSaldoConta());		
		rnsTransacaoPagarBoleto.add( new DebitadorConta());
		rnsTransacaoPagarBoleto.add( new PagadorBoleto());
		rns.put("fai.domain.Boleto", rnsTransacaoPagarBoleto);
		
		//
		daos = new HashMap<String, IDAO>();
		daos.put("fai.domain.Usuario", new UsuarioJpaDAO<Usuario>());
		daos.put("fai.domain.Conta", new ContaJpaDAO<Conta>());
		daos.put("fai.domain.Boleto", new BoletoJpaDAO<Boleto>());*/						
	}
	
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

	
	
	public Map<String, List<ICommand>> getRns() {						
		return rns;
	}


	public void setRns(Map<String, List<ICommand>> rns) {
		this.rns = rns;
	}
	
	public Resultado<F> pagar(F entidade, String numBoleto, Conta conta){
		ICommand cmd;		
        Resultado<F> r = null; 
        EntidadeDominio ent;
        ent = entidade;
		String nmClasse = entidade.getClass().getName();
		List<ICommand> cmds = rns.get(nmClasse);
		
		boleto = new Boleto();
		boleto.setCodigo(numBoleto);		
		
		for (int i = 0; i < cmds.size(); i++) {
			cmd = cmds.get(i);			
			switch (i) {
			case 0:				
				r = (Resultado<F>) cmd.execute(boleto, "");
				if (r.getEntidades().size()>0)
					boleto = (Boleto) r.getEntidades().get(0);
				break;
			case 1:
				r = (Resultado<F>) cmd.execute(conta, boleto);				
				break;
			case 2:
				cmd.execute(conta, boleto);				
				break;
			case 3:
				r = (Resultado<F>) cmd.execute(boleto, boleto);				
				break;				
			default:
				break;
			}
			
			if (r.getMensagens()!= null){
				if(r.getMensagens().size() != 0){
					break;				//ocorreu algum problema que 
				}					
			}		
		}
		return r;					
	}


	public Boleto getBoleto() {
		return boleto;
	}


	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}



	
	
}
