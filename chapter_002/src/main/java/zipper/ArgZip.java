package zipper;

import java.util.HashMap;
import java.util.Map;

public class ArgZip {

    private final String[] args;
    private final HashMap<String, String> values = new HashMap<>();

    public ArgZip(String[] args) {
        this.args = args;
    }

    public Map<String, String> argsValues() {
        for (String argument : args) {
            String[] arr = argument.split("=");
            if (arr.length < 2) {
                throw new IllegalArgumentException();
            }
            values.put(arr[0].substring(1), arr[1]);
        }
        return values;
    }

    public boolean valid() {
        if (values.size() != 3) {
            throw new IllegalArgumentException();
        }
       return true;
    }

    public String directory() {
        return values.get("d");
    }

    public String exclude() {
        return values.get("e");
    }

    public String output() {
        return values.get("o");
    }
}

