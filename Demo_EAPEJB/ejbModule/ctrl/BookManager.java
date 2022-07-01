package ctrl;

import javax.ejb.Remote;

import model.Book;

@Remote
public interface BookManager {

	public Book readBook(int index);
}
