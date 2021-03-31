package serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "CoVID{"
                + "contagiousness=" + contagiousness
                + ", since=" + since
                + ", coronaVir=" + coronaVir
                + ", properties=" + Arrays.toString(properties)
                + '}';
    }

    public static void main(String[] args) {
        final CoVID coVID = new CoVID(true, 2020, new CoronaVir("COVID-19"), "Very hi, Deadly dangerous, You have no chance");
        /* Преобразуем объект coVID в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(coVID));
        /* Преобразуем объект из JSON */
        final String virusJson =
                "{"
                        + "\"contagiousness\": true,"
                        + "\"since\":2020,"
                        + "\"coronaVir\":"
                        + "{"
                        + "\"strain\" : \"CoVID19\""
                        + "},"
                        + "\"properties\":"
                        + "[\"Very_hi\",\"Deadly_dangerous\"]"
                        + "}";
        final CoVID covidMod = gson.fromJson(virusJson, CoVID.class);
        System.out.println(covidMod);
    }
}


