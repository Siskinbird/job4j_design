package io;

import java.util.LinkedList;

public class Shell {
    private LinkedList<String> res = new LinkedList<>();

    public void cd(String path) {
        StringBuilder sb = new StringBuilder();
        if (path.equals("/")) {
            res.addFirst(path);
            return;
        }
        String[] str;
        str = path.split("/");
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("")) {
                continue;
            }
            if (!str[i].equals("..")) {
                res.addLast(str[i]);
            } else {
                res.pollFirst();
            }

        }
    }

    public String pwd() {
        StringBuilder sb = new StringBuilder();
        while (!res.isEmpty()) {
            sb.append(res.pollFirst());
        }
        return sb.toString();
    }
}