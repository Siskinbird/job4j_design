
package filesearcher;
import java.util.HashMap;
import java.util.Map;

/**
 * Class ArgsSearcher - Argument validation
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.0 - SNAPSHOT
 * @since 09.06.21
 */

public class ArgsSearcher {

    private final String[] args;
    private HashMap<String, String> values = new HashMap<>();

    public ArgsSearcher(String[] args) {
        this.args = args;
        values = (HashMap<String, String>) fillingMap();

    }

    /* Map for args */

    public Map<String, String> fillingMap() {
        values = new HashMap<>();
           for (String argument : args) {
               String[] arr = argument.split("=");
               if (arr.length < 2) {
                   throw new IllegalArgumentException();
               }
               values.put(arr[0].substring(1), arr[1]);
           }
            return values;
    }

    /* ArgsValues validation */

    public boolean isValid() {
        return values.size() < 5;
    }
    /* directory search (-d) */

    public String directory() {
        return values.get("d");
    }

    /* file name, mask, or regular expression (-n) */

    public String name() {
        return values.get("n");
    }

    /* search type (-t)
     -mask
     -name
     -regex
     */

    public  String type() {
        return values.get("t");
    }

    /* write to file (-o)*/
    public String writeToFile() {
        return values.get("o");
    }
}
