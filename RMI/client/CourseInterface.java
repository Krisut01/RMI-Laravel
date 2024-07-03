import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CourseInterface extends Remote {
    void sendCourseData(int courseID, int studentID, String courseTitle, String courseDescription) throws RemoteException;
}