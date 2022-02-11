package kvo.hash;

public class Hash {

    public static void main(String[] args) {
        String pattern = "b*b";
        String source = "Alibaba or Alibubaba? I do not know!";
        String[] str = search(source, pattern);
        printConsole(source, pattern, str);
    }

    private static void printConsole(String source, String pattern, String[] str) {
        System.out.printf("Поиск подстроки : {%s} в строке : {%s}%n", pattern, source);
        for (String el : str) {
            if (el != null) {
                System.out.printf("найдено вхождение подстроки {%s} на позиции {%2s}%n", pattern, el);
            }
        }
    }

    public static int hashC(String pattern, int lenght) {
        int hash = 0;
        if (pattern.length() == 0 || lenght == 0) {
            return 0;
        }
        for (int i = 0; i < lenght; i++) {
            if (pattern.charAt(i) != '*') {
                hash += Character.hashCode(pattern.charAt(i));
            }
        }
        return hash;
    }

    public static String[] search(String source, String pattern) {
        if (pattern.length() > source.length()) {
            return null; //Такой подстроки точно нет !
        }
        String[] found = new String[source.length()];
        int indexFound = 0;
        int pattern_hash = hashC(pattern, pattern.length());//сумма кодов символов в pattern без учёта *;
        int asterik_position = indexMultyplay(pattern); //позиция '*' в pattern;

        int window_hash = -1;
        for (int start = 0; start < source.length() - pattern.length() + 1; start++) { //start от 0 до длина (source) - длина(pattern) + 1
            if (start == 0) {
                window_hash = hashC(source, pattern.length());//сумма кодов первых длина(pattern) символов source;
                window_hash -= hashC(source.charAt(asterik_position)); //код символа в source на позиции asterik_position;
            } else {
                window_hash -= hashC(source.charAt(start - 1)); //код символа в source на позиции start -1;
                window_hash += hashC(source.charAt(start + pattern.length() - 1)); //код символа в source на позиции start +длина(pattern) - 1;
                window_hash -= hashC(source.charAt(start + asterik_position)); //код символа в source на позиции start +asterik_position;
            }
            if (window_hash == pattern_hash) {
                boolean flag = true;
                for (int i = 0; i < pattern.length(); i++) {
                    if (pattern.charAt(i) != '*' && source.charAt(start + i) != pattern.charAt(i)) {
                        flag = false;
                        break; //Не подходит
                    }
                }
                if (flag) { //если подошёл, то добавим start в found;
                    found[indexFound++] = String.valueOf(start);
                }
            }
            window_hash += hashC(source.charAt(start + asterik_position)); //код символа в source на позиции start +asterik_position;
        }
        return found;
    }

    private static int hashC(char charAt) {
        return Character.hashCode(charAt);
    }

    private static int indexMultyplay(String pattern) {
        char[] charArray = pattern.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '*') {
                return i;
            }
        }
        return -1;
    }
}
