import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StaxParser {
    public static void main(String[] args) {
        final String file = "src\\main\\resources\\books.xml";

        try {
            XMLStreamReader xmlReader = XMLInputFactory.newInstance().createXMLStreamReader(
                    file, new FileInputStream(file)
            );

            while (xmlReader.hasNext()) {
                xmlReader.next();
                if (xmlReader.isStartElement()) {
                    System.out.println(xmlReader.getLocalName());
                } else if (xmlReader.isEndElement()) {
                    System.out.println("/" + xmlReader.getLocalName());
                } else if (xmlReader.hasText() && xmlReader.getText().trim().length() > 0
                        && !xmlReader.getText().startsWith("#COMMENT")) {

                    System.out.println("    " + xmlReader.getText());
                }
            }

        } catch (XMLStreamException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
