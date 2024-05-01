
package model;


public class User {
    private int userId;
    private String userName;
    private String password;
    private String bookIssued;
    private int dateOfIssue;
    private int dateOfReturn;

    public User() {
    }

    public User(int userId, String userName, String password, String bookIssued, int dateOfIssue, int dateOfReturn) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.bookIssued = bookIssued;
        this.dateOfIssue = dateOfIssue;
        this.dateOfReturn = dateOfReturn;
    }

    public User(int userId, String userName, String password){
        
        this.userId=userId;
        this.userName = userName;
        this.password = password;
        
    }
    public User(String userName, String password){
        
        this.userName = userName;
        this.password = password;
        
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getBookIssued() {
        return bookIssued;
    }

    public void setBookIssued(String bookIssued) {
        this.bookIssued = bookIssued;
    }

    public int getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(int dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public int getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(int dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
    
    
    @Override
    public String toString() {
        return "User ID: " + userId + ", User Name: " + userName + ",Book Issued: "+bookIssued + ", Date Of Book Issue: " + dateOfIssue + ", Date Of Book Return: " + dateOfReturn;
    }
    
    
}
