package entity;

import jakarta.xml.bind.annotation.*;

@XmlRootElement //обозначает что это составной элемент
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "person", propOrder = { //тут мы говорим что ищи теги именно персон
        "name",
        "telephone",
        "adress" //последовательность элементов xml
})
public class Person {

    /*
    дополнительные аннотации
    @XmlID - уникальное поле
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class) - контроль стринга, убирает пробелы и все подобное, чистит стринг
     */

    @XmlAttribute(required = true)
    private String login;

    @XmlElement(required = true)
    private String name;

    @XmlAttribute(required = true)
    private String faculty;

    @XmlElement(required = true)
    private int telephone;

    @XmlElement(required = true)
    private Adress adress = new Adress();

    public Person() {
    }

    public Person(String login, String name, String faculty, int telephone, Adress adress) {
        this.login = login;
        this.name = name;
        this.faculty = faculty;
        this.telephone = telephone;
        this.adress = adress;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @XmlRootElement
    @XmlType(name = "adress", propOrder = {
            "city",
            "country",
            "street"
    })
    public static class Adress {

        private String city;
        private String country;
        private String street;

        public Adress() {
        }

        public Adress(String city, String country, String street) {
            this.city = city;
            this.country = country;
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        @Override
        public String toString() {
            return "Adress{" +
                    "city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    ", street='" + street + '\'' +
                    '}';
        }
    }
}