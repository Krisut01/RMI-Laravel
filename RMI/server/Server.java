import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            // Set the hostname for the RMI server
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            // Create the RMI registry on port 9100
            Registry registry = LocateRegistry.createRegistry(9100);
            System.out.println("Server has been started...");

            // Create instances of the service implementations
            StudentInterface studentService = new StudentRegistration();
            CourseInterface courseService = new CourseRegistration();

            // Export the remote objects
            StudentInterface stub_Student = (StudentInterface) UnicastRemoteObject.exportObject(studentService, 0);
            CourseInterface stub_Course = (CourseInterface) UnicastRemoteObject.exportObject(courseService, 0);

            // Bind the services to the registry
            registry.rebind("StudentService", stub_Student);
            registry.rebind("CourseService", stub_Course);

            System.out.println("Exporting and binding of Objects has been completed...");
        } catch (RemoteException e) {
            System.err.println("RMI error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


//run "java -classpath postgresql-42.7.3.jar; Server"