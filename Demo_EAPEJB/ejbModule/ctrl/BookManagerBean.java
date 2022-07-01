package ctrl;

import java.io.Serializable;

import javax.ejb.Stateless;

import model.Book;

/**
 * Session Bean implementation class BookManagerBean
 */
@SuppressWarnings("serial")
@Stateless
public class BookManagerBean implements BookManagerLocal , Serializable{

    /**
     * Default constructor. 
     */
    public BookManagerBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void persistBook(Book book) {
		
	}

	@Override
	public Book readBook(int index) {
		return null;
	}

}
