package livraria.util;

import java.util.List;

import javax.persistence.EntityManager;

public class DAO<T> {
	private Class<T> classe;

	public Class<T> getClasse() {
		return classe;
	}

	public DAO(Class<T> classe) {
		super();
		this.classe = classe;
	}

	public void gravar(T t) {

		T gravar = t;
		EntityManager manager = new JPAUtil().getManager();
		try {
			manager.getTransaction().begin();
			if (gravar == null) {
				manager.persist(gravar);
			} else {
				manager.merge(gravar);
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error ao gravar: " + e);
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	public T buscarPorId(int id) {
		T find = null;
		EntityManager manager = new JPAUtil().getManager();

		try {
			manager.getTransaction().begin();
			find = manager.find(getClasse(), id);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error ao buscar pelo ID: " + e);
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

		return find;

	}

	public T remover(int id) {
		T find = null;
		EntityManager manager = new JPAUtil().getManager();
		manager.getTransaction().begin();
		try {
			manager.getTransaction().begin();
			find = manager.find(getClasse(), id);
			manager.remove(find);
			manager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error ao remover: " + e);
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return find;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> listarTodos() {
		EntityManager manager = new JPAUtil().getManager();
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append(getClasse().getSimpleName());
		List resultList = manager.createQuery(sql.toString()).getResultList();
		return resultList;

	}
}
