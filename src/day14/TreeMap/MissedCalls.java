package day14.TreeMap;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class MissedCalls extends PhoneBook {
    Map<LocalDateTime, String> missedCalls = new TreeMap<>(); // время и номер телефона

    public MissedCalls() {
    }

    public void getMissedCalls(PhoneBook phoneBook) {
        System.out.println("MissedCalls");
        for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
            LocalDateTime LocalDateTime = entry.getKey(); // get key
            String value = entry.getValue(); // get value
            value = checkNumber(phoneBook, value); //проверить номер в справочнике
            System.out.printf("\t{DateTime = %-30s, Phone = %s}\n", LocalDateTime, value);
        }
    }

    private String checkNumber(PhoneBook phoneBook, String value) {
        String searchContact = String.valueOf(phoneBook.searchContact(value, false));
        if (searchContact.length() > 2) { //строка пустая "[]"
            int startSub = searchContact.indexOf("'");
            int endSub = searchContact.indexOf(",");
            String name = searchContact.substring(startSub, endSub);
            value = AnsiColor.ANSI_GREEN + name + AnsiColor.ANSI_RESET;
        }
        return value;
    }

    public void setMissedCalls(String missedCalls) throws InterruptedException {
        this.missedCalls.put(LocalDateTime.now(), missedCalls);
        int waitSleep = 1;
        waitNano(waitSleep);
    }

    private void waitNano(int waitSleep) throws InterruptedException {
        TimeUnit.NANOSECONDS.sleep(1);
    }

    @Override
    public String toString() {
        return "MissedCalls\n\t{" +
                "missedCalls=" + missedCalls +
                "}\n";
    }
}
