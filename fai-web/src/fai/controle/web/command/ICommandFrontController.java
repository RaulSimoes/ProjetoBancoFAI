
package fai.controle.web.command;

import fai.domain.EntidadeDominio;
import fai.domain.Resultado;


public interface ICommandFrontController<E extends EntidadeDominio> {

	public Resultado<E> execute(E entidade, String aux);
	
}
