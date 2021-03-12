package zipper;

import java.util.HashMap;
import java.util.Map;

/**
 * Class ArgZip - Argument validation
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.00
 * @since 12.03.21
 */

public class ArgZip {

    private final String[] args;
    private  HashMap<String, String> values = new HashMap<>();

    public ArgZip(String[] args) {
        this.args = args;
    }
/*
Map for args
 */
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
/*
argsValues validation
 */
    public boolean valid() {
        if (this.argsValues().size() != 3) {
            throw new IllegalArgumentException();
        }
       return true;
    }
/*
getDirectory
 */
    public String directory() {
        return values.get("d");
    }
/*
getExclude
 */
    public String exclude() {
        return values.get("e");
    }
/*
getOutput file
 */
    public String output() {
        return values.get("o");
    }
}

