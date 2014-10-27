
package fai.negocio;

import fai.domain.EntidadeDominio;
import fai.domain.Resultado;



public interface ICommand {

	public Resultado<EntidadeDominio> execute(EntidadeDominio entidade, Object obj);	
	
}