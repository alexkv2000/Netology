package graphics;

import graphics.image.Convert;
import graphics.image.SchemaImage;
import graphics.image.TextGraphicsConverter;
import graphics.server.GServer;

public class Main {
    public static void main(String[] args) throws Exception {
        TextGraphicsConverter converter = new Convert(600, 1200, 0, new SchemaImage()); // Создайте тут объект вашего класса конвертера

        GServer server = new GServer(converter); // Создаём объект сервера
        server.start(); // Запускаем

        // Или то же, но с сохранением в файл:
        /*
        PrintWriter fileWriter = new PrintWriter(new File("converted-image.txt"));
        converter.setMaxWidth(200);
        converter.setMaxHeight(300);
        fileWriter.write(converter.convert("https://i.ibb.co/6DYM05G/edu0.jpg"));
        fileWriter.close();
        */
    }
}
