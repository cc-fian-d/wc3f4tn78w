package ctrl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

import model.Book;

/**
 * Session Bean implementation class BookManagerBean
 */
@SuppressWarnings("serial")
@Stateful
public class BookManagerBean implements BookManager, BookManagerLocal , Serializable{

	private List<Book> books;
	
	
    /**
     * Default constructor. 
     */
    public BookManagerBean() {

    }

	@Override
	public void persistBook(Book book) {
		System.out.println(book);
	}

	@Override
	public Book readBook(int index) {
		System.out.println(index);
		Book b = new Book();
		b.setName("Java");
		b.setTitle("Insel");
		return b;
	}
	
	@PostConstruct
	private void initialize() {
		books = new ArrayList<Book>();
		books.add(new Book());
		books.add(new Book());
		books.add(new Book());
	}

}
