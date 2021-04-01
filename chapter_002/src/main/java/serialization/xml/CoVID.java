package serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "virusBase")
@XmlAccessorType(XmlAccessType.FIELD)

public class CoVID {

    @XmlAttribute
    private boolean contagiousness;

    @XmlAttribute
    private int since;
    private CoronaVir coronaVir;

    @XmlElementWrapper(name = "properties")
    @XmlElement(name = "property")
    private String[] properties;

    public CoVID() { }

    public CoVID(boolean contagiousness, int since, CoronaVir coronaVir, String... properties) {
        this.contagiousness = contagiousness;
        this.since = since;
        this.coronaVir = coronaVir;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "CoVID{"
                + "contagiousness=" + contagiousness
                + ", since=" + since
                + ", coronaVir=" + coronaVir
                + ", property=" + Arrays.toString(properties)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        final CoVID coVID = new CoVID(true, 2020, new CoronaVir("COVID-19"), "Very hi, Deadly dangerous, You have no chance");
        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(CoVID.class);
        /* Создаем сериализатор */
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            //Сериализуем
            marshaller.marshal(coVID, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            // Дисериализуем
            CoVID result = (CoVID) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}


