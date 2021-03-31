package serialization.json;

public class CoronaVir {

    private final String strain;

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
