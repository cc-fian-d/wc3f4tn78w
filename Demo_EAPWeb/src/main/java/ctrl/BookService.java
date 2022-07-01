package ctrl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Book;

@ApplicationScoped
@Named
public class BookService implements Serializable {

	@Inject
	private BookManager bm;
	
	public Book readBook() {
		return bm.readBook(123);
	}
}
