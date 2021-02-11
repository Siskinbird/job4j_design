package ru.job4j.collection.exam;

import java.util.*;

/**
 * MaleSplitter - The class implements the merging of the same users into one.
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.66
 * @since 10.02.21
 */

public class MaleSplitter {

    /**
     * Method merge implements the merging of the same users into one.
     * @param inputData - Inbound card to merge duplicates.
     * @return output fused data map.
     */

    public static Map<String, Set<String>> merge(Map<String, Set<String>> inputData) {
        Map<String, Set<String>> outputData = new LinkedHashMap<>();
        Map<String, String> tmp = new HashMap<>();
        String userName;
        Set<String> userEmails;
        for (Map.Entry<String, Set<String>> pair : inputData.entrySet()) {
            userEmails = pair.getValue();
            userName = pair.getKey();
            for (String check : userEmails) {
                if (tmp.containsKey(check)) {
                    userName = tmp.get(check);
                    break;
                }
            }
            for (String mail : userEmails) {
                tmp.put(mail, userName);
            }
        }
        for (Map.Entry<String, String> t : tmp.entrySet()) {
            if (outputData.containsKey(t.getValue())) {
                outputData.get(t.getValue()).add(t.getKey());
            } else {
                Set<String> newSet = new HashSet<>();
                newSet.add(t.getKey());
                outputData.put(t.getValue(), newSet);
            }
        }
        return outputData;
    }
}
