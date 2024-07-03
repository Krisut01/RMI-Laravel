import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/it106";
        String username = "postgres";
        String password = "12345";
        return DriverManager.getConnection(url, username, password);
    }
}
