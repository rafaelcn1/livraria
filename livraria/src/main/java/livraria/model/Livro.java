package livraria.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String titulo, isbn;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataLacamento = Calendar.getInstance();

	private double preco;

	@ManyToMany
	private List<Autor> autores = new ArrayList<Autor>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Calendar getDataLacamento() {
		return dataLacamento;
	}

	public void setDataLacamento(Calendar dataLacamento) {
		this.dataLacamento = dataLacamento;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public void adicionaAutor(Autor autor) {
		getAutores().add(autor);
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", dataLacamento=" + dataLacamento
				+ ", preco=" + preco + ", autores=" + autores + "]";
	}

}
