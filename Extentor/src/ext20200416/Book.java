package ext20200416;

public class Book {
	
	private String isbn;
	private String title;
	private String author;
	
	
	public Book(String isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	
	@Override
	public String toString() {
		return author + ", " + title;
	}
	
	@Override
	public int hashCode() {
		return isbn.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			return isbn.equals(((Book) obj).isbn);
		}
		return false;
	}
}
