import entity.Person;
import entity.Persons;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JaxbWriter {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Marshaller marshaller = context.createMarshaller();

            Persons persons = new Persons();

            Person alex = new Person(
                    "rujfyls",
                    "Alexander",
                    "CS",
                    27,
                    new Person.Adress("balakhna", "RUSSIA", "Olimpiyskaya"));

            Person kate = new Person(
                    "kefirchik",
                    "Ekaterina",
                    "BIO",
                    26,
                    new Person.Adress("balakhna", "RUSSIA", "Vladimirkaya"));

            persons.addPerson(alex);
            persons.addPerson(kate);

            marshaller.marshal(persons, new FileOutputStream("src\\main\\resources\\person.xml"));
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
