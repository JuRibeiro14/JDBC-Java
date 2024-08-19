import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection connect() {
        try {
            var jdbcUrl = "jdbc:mysql://localhost:3306/db_fatec";
            var user = "root"; //usei o xampp
            var password = "";

            return DriverManager.getConnection(jdbcUrl, user, password);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}
