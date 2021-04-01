package serialization.xml;

import org.json.JSONArray;
import org.json.JSONObject;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "virusBase")
@XmlAccessorType(XmlAccessType.FIELD)

public class CoVID {
    private final boolean contagiousness;
    private final int since;
    private final CoronaVir coronaVir;
    private final String[] properties;

    public CoVID(boolean contagiousness, int since, CoronaVir coronaVir, String... properties) {

        this.contagiousness = contagiousness;
        this.since = since;
        this.coronaVir = coronaVir;
        this.properties = properties;
    }

    public boolean isContagiousness() {
        return contagiousness;
    }

    public int getSince() {
        return since;
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

    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonStrain = new JSONObject("{\"strain\":\"COVID-19\"}");
        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Very hi");
        list.add(" Deadly dangerous");
        list.add(" You have no chance");
        JSONArray jsonProperties = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final CoVID coVID = new CoVID(true, 2020, new CoronaVir("COVID-19"), "Very hi, Deadly dangerous, You have no chance");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("contagiousness", coVID.isContagiousness());
        jsonObject.put("since", coVID.getSince());
        jsonObject.put("coronaVir", jsonStrain);
        jsonObject.put("properties", jsonProperties);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект coVID в json-строку */
        System.out.println(new JSONObject(coVID).toString());

        }
    }

