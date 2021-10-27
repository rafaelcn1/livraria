package livraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ThemeBean {

	@SuppressWarnings("unused")
	private String thema = "aristo";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> getThemes() {
		ArrayList<String> listaDeThemas = new ArrayList();
		listaDeThemas.add("casablanca");
		listaDeThemas.add("black-tie");

		return listaDeThemas;
	}

}
