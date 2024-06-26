package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;
import model.Books;

public class UserDao {

    private static final String URL = "jdbc:mysql://localhost:3306/rwi";
    private static final String USER = "root";
    private static final String PASSWORD = "Nh@2218#0112";

    private Connection connection;

    public UserDao() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public String loginUser(String username, String password) {
        try {
            String query = "SELECT * FROM User WHERE userName = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return "Log-in sucessfull !!!!";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
    
    public void addUser(User user) {
        try {
            String query = "INSERT INTO User (userName, password) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, user.getUserName());
                statement.setString(2, user.getPassword());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public List<Books> getAllAvailableBooks() {
        List<Books> books = new ArrayList<>();

        try {
            String query = "SELECT * FROM Books WHERE status != 'issued'";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Books book = new Books(resultSet.getInt("idBook"), resultSet.getString("bookName"),
                            resultSet.getString("authorName"), resultSet.getString("status"));
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    
    public void returnBook(int bookId) {
        try {
            String query = "UPDATE Books SET status = 'not issued' WHERE idBook = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, bookId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

  
    public void issueBook(int bookId) {
        try {
            String query = "UPDATE Books SET status = 'issued' WHERE idBook = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, bookId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

   
    public void deleteUser(String userName) {
        try {
            String query = "DELETE FROM User WHERE userName = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, userName);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            String query = "UPDATE User SET userName = ?, password = ? WHERE userId = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, user.getUserName());
                statement.setString(2, user.getPassword());
                statement.setInt(3, user.getUserId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
