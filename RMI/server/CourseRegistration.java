import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseRegistration extends DatabaseService implements CourseInterface{

    public void sendCourseData(int courseID, int studentID, String courseTitle, String courseDescription) {
        try (Connection connection = getConnection()) {
            String deleteSql = "DELETE FROM courses WHERE course_id = ? AND student_id = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
                deleteStatement.setInt(1, courseID);
                deleteStatement.setInt(2, studentID);
                deleteStatement.executeUpdate();
            }

            String insertSql = "INSERT INTO courses (course_id, student_id, course_title, course_description, created_at, updated_at) VALUES (?,?,?,?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
            try (PreparedStatement statement = connection.prepareStatement(insertSql)) {
                statement.setInt(1, courseID);
                statement.setInt(2, studentID);
                statement.setString(3, courseTitle);
                statement.setString(4, courseDescription);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
