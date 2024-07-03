import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote {
    void sendStudentData(int studentID, String name, int age, String address, String contactNum) throws RemoteException;
}