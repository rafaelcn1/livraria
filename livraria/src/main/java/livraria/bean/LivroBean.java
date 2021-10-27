package livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.management.RuntimeErrorException;

import livraria.model.Autor;
import livraria.model.Livro;
import livraria.util.DAO;

@ManagedBean(name = "livroBean")
@ViewScoped
public class LivroBean {
	private Livro livro = new Livro();
	private int autorId;

	public LivroBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}

	public List<Autor> getAutores() {
		List<Autor> listarTodos = new DAO<Autor>(Autor.class).listarTodos();
		return listarTodos;
	}

	public void cadastrarAutor() {
		Autor autorDoLivro = new DAO<Autor>(Autor.class).buscarPorId(getAutorId());
		getLivro().adicionaAutor(autorDoLivro);

		List<Autor> autores = getLivro().getAutores();
		for (Autor autor : autores) {
			System.out.println("Livro Escrito por: " + autor.getNome());
		}
	}

	public List<Autor> getAutoresDoLivro() {
		return getLivro().getAutores();
	}

	public void gravar() {
		if (getLivro().getTitulo().isEmpty()) {
			//throw new RuntimeException("Titulo do livro obrigatório!");
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Titulo do livro obrigatório!"));
			return;
		} else {
			if (getLivro().getAutores().isEmpty()) {
				//throw new RuntimeException("Autor do livro obrigatório!");
				FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Autor do livro obrigatório!"));
				return;
			} else {
				new DAO<Livro>(Livro.class).gravar(getLivro());
				System.out.println("Livro " + getLivro().getTitulo() + ", escrito por " + getLivro().getAutores()
						+ " Cadastrado com sucesso!");
			}
		}

		setLivro(new Livro());
	}
	
	public List<Livro> getLivros(){
		return new DAO<Livro>(Livro.class).listarTodos();
	}
	
	public String irParaPaginaAutor() {
		return "autor?faces-redirect=true";
	}

}
