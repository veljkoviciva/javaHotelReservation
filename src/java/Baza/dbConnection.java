package Baza;


import java.sql.*;

public class dbConnection {
    public static void main(String[] args) throws ClassNotFoundException {
        konekcija();
    }

    public static Connection konekcija() throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/lanachotelajavamini";
        String user = "root";
        String pass = "";
        Connection conn = null;
        
        

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);

            if (conn == null) {
                System.out.println("Veza nije uspostavljena");
            } else {
                System.out.println("Veza je uspostavljena");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("fpjfuehfiuwehfiwehfi" + e);
        }
        return conn;
    }
}
