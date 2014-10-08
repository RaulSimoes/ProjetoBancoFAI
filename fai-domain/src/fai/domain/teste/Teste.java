package fai.domain.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fai.domain.Conta;
import fai.domain.Usuario;

public class Teste {

	public static void main(String[] args) {
		
		System.out.print("Banco");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fai-domain");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Usuario usuario = new Usuario();	
		usuario.setCpf("07755810623");
		usuario.setNome("Jádson");
		usuario.setSalario(Float.valueOf(1000));
		usuario.setTipo_cliente("Cliente");
		
		Conta conta = new Conta();
		conta.setId(usuario.getId());
		conta.setNum_conta("21064-1");
		conta.setAgencia("0872-9");
		conta.setSenha("123456");
		conta.setLimite_credito(Float.valueOf(1000));
		conta.setSaldo(Float.valueOf(2000));
		
		//finaliza transação
		em.persist(usuario);
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
			
	}

}

