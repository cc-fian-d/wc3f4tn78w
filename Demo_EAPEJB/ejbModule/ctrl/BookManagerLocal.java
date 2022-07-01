package ctrl;

import javax.ejb.Local;

import model.Book;

@Local
public interface BookManagerLocal extends BookManager{

	public void persistBook(Book book);
}
