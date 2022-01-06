package day11.CorrectURL;

public class UrlUtils {
    public static void validate(String value) throws NotValidUrlException {
        boolean isValidSchema = value.startsWith("http://") || value.startsWith("https://");
        if (!isValidSchema) {
            throw new UnsupportedSchemaException("Протокол указан неверно " + value);
        }
        if (value.contains(" ")) {
            throw new NotValidUrlException("Url содержит пробелы: '" + value + "'");
        }
    }
}
