package livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import livraria.model.Autor;
import livraria.util.DAO;

@ManagedBean(name = "autorBean")
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String gravar() {
		DAO<Autor> dao = new DAO<Autor>(Autor.class);
		dao.gravar(getAutor());
		setAutor(new Autor());
		return "livro?faces-redirect=true";
	}

	public Autor buscarPorId(int id) {
		DAO<Autor> dao = new DAO<Autor>(Autor.class);
		return dao.buscarPorId(id);
	}

	public void remover(int id) {
		DAO<Autor> dao = new DAO<Autor>(Autor.class);
		dao.remover(id);

	}

	public List<Autor> listarTodos() {
		DAO<Autor> dao = new DAO<Autor>(Autor.class);
		return dao.listarTodos();
	}
}
