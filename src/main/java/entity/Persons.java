package entity;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
public class Persons {

    @XmlElement(name = "person")
    private ArrayList<Person> persons = new ArrayList<>();

    public Persons() {
    }

//    public ArrayList<Person> getPersons() { //нельзя, и наче будет ошибка
//        return persons;
//    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public String toString() {
        return "Persons{" +
                "persons=" + persons +
                '}';
    }
}
