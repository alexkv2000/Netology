package day14.TreeMap;

import java.time.LocalDateTime;
import java.util.*;

public class MissedCalls {
    Map<LocalDateTime, String> missedCalls = new TreeMap<>(); // время и номер телефона

    public Map<LocalDateTime, String> getMissedCalls() {
        for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
            // get key
            LocalDateTime LocalDateTime = entry.getKey();
            // get value
            String value = entry.getValue();
            System.out.println(LocalDateTime + " " + value);
        }
        return missedCalls;
    }

    public String setMissedCalls(LocalDateTime localDateTime, String missedCalls) {
        return this.missedCalls.put(localDateTime, missedCalls);
    }

    @Override
    public String toString() {
        return "MissedCalls\n\t{" +
                "missedCalls=" + missedCalls +
                "}\n";
    }
}
