
package fai.teste;

import java.util.List;

import fai.dao.IDAO;
import fai.dao.jpa.impl.CategoriaJpaDAO;
import fai.dao.jpa.impl.ProdutoJpaDAO;
import fai.dao.jpa.impl.UsuarioJpaDAO;
import fai.domain.Categoria;
import fai.domain.Produto;
import fai.domain.Usuario;



public class TesteDAO {

	
	public static void main(String[] args) {
	/*	Produto prd = new Produto();
		prd.setId(3);
		IDAO dao = new ProdutoJpaDAO();
		
		Produto p = (Produto) dao.consulta(prd).get(0);

		System.out.println("PRODUTO: "+p.getDescricao());
		System.out.println("CATEGORIA: "+p.getCategoria().getDescricao());
		
		p.setDescricao("Tablet");
		p.getCategoria().setDescricao("Multitoch");
		dao.salvar(p);
		
		p = (Produto) dao.consulta(prd).get(0);
		System.out.println("PRODUTO: "+p.getDescricao());
		System.out.println("CATEGORIA: "+p.getCategoria().getDescricao());
		prd = new Produto();
		prd.setId(4);
		dao.excluir(prd);*/
		
		/*IDAO<Produto> dao = new ProdutoJpaDAO<Produto>();
		Categoria c = new Categoria();
		c.setId(1);
		Produto prd = new Produto();
		prd.setCategoria(c);
		List<Produto> produtos = dao.consultar(prd);
		
		for(Produto p:produtos){
			System.out.println(p.getDescricao());
		}
		
		
		IDAO<Categoria> daoCat = new CategoriaJpaDAO<Categoria>();
		List<Categoria> categorias = daoCat.consultar(new Categoria());
		for(Categoria cat: categorias){
			System.out.println(cat.getDescricao());
		}*/
		
		IDAO<Usuario> daoUsu = new UsuarioJpaDAO<Usuario>();
		Usuario usuario1 = new Usuario();
		usuario1.setAgencia("fsdfsda");
		daoUsu.salvar(usuario1);
		List<Usuario> usuarios = daoUsu.consultar(new Usuario());
		for(Usuario usu: usuarios){
			System.out.println(usu.getAgencia());
			System.out.println(usu.getConta());
			System.out.println(usu.getSenha());			
		}		
	}

}
