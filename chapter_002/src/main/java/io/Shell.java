package io;

import java.util.LinkedList;
import java.util.StringJoiner;

public class Shell {
    private LinkedList<String> res = new LinkedList<>();

    public void cd(String path) {
        /* when absolutePath */
        if (path.startsWith("/")) {
            parseAbsolute(path);
        }
        /* when rootPath */
        if (path.equals("/")) {
            res.clear();

        /* when userLocalPath */
        } else {
            parseRelative(path);
        }
    }

    /* when absolutePath */
    void parseAbsolute(String path) {
            res.clear();
            if (path.startsWith("/")) {
                String[] str;
                str = path.split("/");
                for (int i = 0; i < str.length; i++) {
                    if (str[i].equals("")) {
                        continue;
                    }
                    res.addLast(str[i]);
                }
            }
        }

    /* when relativePath */

    void parseRelative(String path) {
        if (!path.equals("/") && !path.startsWith("/")) {
            String[] str;
            str = path.split("/");
            for (String s : str) {
                if (s.equals("..")) {
                    res.clear();
                } else {
                    res.addLast(s);
                }
            }
        }
    }

    public String pwd() {
        StringJoiner sj = new StringJoiner("/", "/", "");
        while (!res.isEmpty()) {
            sj.add(res.pollFirst());
        }
        return sj.toString();
    }
}
