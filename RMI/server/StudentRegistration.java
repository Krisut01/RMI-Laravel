import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRegistration extends DatabaseService implements StudentInterface {

    protected StudentRegistration() {
        super();
    }

    @Override
    public void sendStudentData(int studentID, String name, int age, String address, String contactNum) {
        try (Connection connection = getConnection()) {
            String checkSql = "SELECT COUNT(*) FROM students WHERE student_id = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
                checkStatement.setInt(1, studentID);
                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    resultSet.next();
                    int count = resultSet.getInt(1);
                    if (count > 0) {
                        updateStudent(connection, studentID, name, age, address, contactNum);
                    } else {
                        insertStudent(connection, studentID, name, age, address, contactNum);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertStudent(Connection connection, int studentID, String name, int age, String address, String contactNum) throws SQLException {
        String insertSql = "INSERT INTO students (student_id, name, age, address, contact_number, created_at, updated_at) VALUES (?,?,?,?,?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
            insertStatement.setInt(1, studentID);
            insertStatement.setString(2, name);
            insertStatement.setInt(3, age);
            insertStatement.setString(4, address);
            insertStatement.setString(5, contactNum);
            insertStatement.executeUpdate();
        }
    }

    private void updateStudent(Connection connection, int studentID, String name, int age, String address, String contactNum) throws SQLException {
        String updateSql = "UPDATE students SET name = ?, age = ?, address = ?, contact_number = ?, updated_at = CURRENT_TIMESTAMP WHERE student_id = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
            updateStatement.setString(1, name);
            updateStatement.setInt(2, age);
            updateStatement.setString(3, address);
            updateStatement.setString(4, contactNum);
            updateStatement.setInt(5, studentID);
            updateStatement.executeUpdate();
        }
    }
}
