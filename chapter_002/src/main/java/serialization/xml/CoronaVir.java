package serialization.xml;

import com.sun.xml.txw2.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "coronaVir")
public class CoronaVir {

    @XmlAttribute
    private String strain;

    public CoronaVir() {
    }

    public CoronaVir(String strain) {
        this.strain = strain;
    }

    @Override
    public String toString() {
        return "Strain{"
                + "strain='" + strain + '\''
                + '}';
    }
}
