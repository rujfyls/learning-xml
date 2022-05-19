import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StaxWriter {
    public static void main(String[] args) {
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = outputFactory
                    .createXMLStreamWriter(new FileWriter("src\\main\\resources\\result.xml"));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("BookCatalogue");

            for (int i = 1; i <= 5; i++) {
                writer.writeStartElement("Book");

                writer.writeStartElement("Title");
                writer.writeCharacters("Book #" + i);
                writer.writeEndElement();

                writer.writeStartElement("Author");
                writer.writeCharacters("Author #" + i);
                writer.writeEndElement();

                writer.writeStartElement("Date");
                writer.writeCharacters(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
                writer.writeEndElement();

                writer.writeStartElement("Cost");
                writer.writeAttribute("currency", "RUB");
                writer.writeCharacters("" + i * 10);
                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.flush();
        } catch (XMLStreamException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
