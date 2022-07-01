package model;

public class Book {

	private String name;
	private String title;

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", title=" + title + "]";
	}
	
	
}
