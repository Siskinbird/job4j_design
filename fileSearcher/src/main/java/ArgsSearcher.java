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
            if (args.length % 2 != 0) {
                throw new IllegalArgumentException("Not all arguments");
            }
            for (int i = 0; i < args.length - 1; i += 2) {
                values.put(args[i], args[i + 1]);
            }
            return values;
    }

    /* ArgsValues validation */

    public boolean isValid() {
        return values.size() < 4;
    }
    /* directory search (-d) */

    public String directory() {
        return values.get("-d");
    }

    /* file name, mask, or regular expression (-n) */

    public String name() {
        return values.get("-n");
    }

    /* search type (-t)
     -mask
     -name
     -regex
     */

    public  String type() {
        return values.get("-t");
    }

    /* write to file (-o)*/
    public String writeToFile() {
        return values.get("-o");
    }
}
