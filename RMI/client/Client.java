import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            // Lookup separate services for student and course data
            StudentInterface studentService = (StudentInterface) registry.lookup("StudentService");
            CourseInterface courseService = (CourseInterface) registry.lookup("CourseService");
            
            // Parse students.xml
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Assuming Student.xml is in the same directory as the Java program
            Document studentDocument = builder.parse("Student.xml");
            studentDocument.getDocumentElement().normalize();

            // Parse courses.xml
            Document courseDocument = builder.parse("Courses.xml");
            courseDocument.getDocumentElement().normalize();

            // Get and send student details
            NodeList studentList = studentDocument.getElementsByTagName("student");
            for (int i = 0; i < studentList.getLength(); i++) {
                Element studentElement = (Element) studentList.item(i);
                int studentID = Integer.parseInt(studentElement.getElementsByTagName("student_id").item(0).getTextContent());
                String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
                int age = Integer.parseInt(studentElement.getElementsByTagName("age").item(0).getTextContent());
                String address = studentElement.getElementsByTagName("address").item(0).getTextContent();
                String contactNum = studentElement.getElementsByTagName("contact_number").item(0).getTextContent();
                
                studentService.sendStudentData(studentID, name, age, address, contactNum);
                System.out.println("Student data sent successfully. Student ID: " + studentID);
            }

            // Get and send course details
            NodeList courseList = courseDocument.getElementsByTagName("course");
            for (int i = 0; i < courseList.getLength(); i++) {
                Element courseElement = (Element) courseList.item(i);
                int courseID = Integer.parseInt(courseElement.getElementsByTagName("course_id").item(0).getTextContent());
                int studentID = Integer.parseInt(courseElement.getElementsByTagName("student_id").item(0).getTextContent());
                String courseTitle = courseElement.getElementsByTagName("course_title").item(0).getTextContent();
                String courseDescription = courseElement.getElementsByTagName("course_description").item(0).getTextContent();
                
                courseService.sendCourseData(courseID, studentID, courseTitle, courseDescription);
                System.out.println("Course data sent successfully. Course ID: " + courseID);
            }
        } catch (Exception e) {
            System.out.println("Client side error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
