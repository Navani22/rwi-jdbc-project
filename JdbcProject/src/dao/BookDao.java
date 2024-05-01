
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Books;


public class BookDao {


	private static final String URL = "jdbc:mysql://localhost:3306/rwi";
	private static final String USER = "root";
	private static final String PASSWORD = "Nh@2218#0112";

	private Connection connection;

	public BookDao() {
		// TODO Auto-generated constructor stub
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Books> getAllBooks() {
		List<Books> book = new ArrayList<>();

		try {
			String query = "SELECT * FROM books";
			try (PreparedStatement statement = connection.prepareStatement(query);
					ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Books books = new Books(resultSet.getInt("idBook"), resultSet.getString("bookName"),
							resultSet.getString("authorName"),resultSet.getString("status"));
					book.add(books);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;
	}

	public void addBook(Books book) {
		try {
			String query = "INSERT INTO books (bookName, authorName) VALUES (?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, book.getBookName());
				statement.setString(2, book.getAuthorName());
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBook(Books book) {
		try {
			String query = "UPDATE books SET bookName = ?, authorName = ? WHERE idBook = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, book.getBookName());
				statement.setString(2, book.getAuthorName());
				statement.setInt(3, book.getBookId());
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(int BookId) {
		try {
			String query = "DELETE FROM Books WHERE idBook = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, BookId);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
    

