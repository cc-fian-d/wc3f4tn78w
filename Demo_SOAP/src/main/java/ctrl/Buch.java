package ctrl;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Buch {
	
	private String titel;
	private String autor;
	
	public Buch() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
}
