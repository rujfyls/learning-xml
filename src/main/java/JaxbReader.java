import entity.Employee;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class JaxbReader {
    public static void main(String[] args) {
        String fileURL = "src\\main\\resources\\employee.xml";

        File file = new File(fileURL);

        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            Employee emloyee = (Employee) unmarshaller.unmarshal(file);

            System.out.println(emloyee);


        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
