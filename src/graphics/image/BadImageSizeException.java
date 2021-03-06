package graphics.image;

import java.nio.charset.Charset;

public class BadImageSizeException extends Exception {
    public BadImageSizeException(double ratio, double maxRatio) {
//        Charset w1251 = Charset.forName("Windows-1251");
//        Charset utf8 = Charset.forName("UTF-8");
//        String str = "Максимальное соотношение сторон изображения ";
//        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
//        String  str = new String("Максимальное соотношение сторон изображения ", utf8);
        super("Максимальное соотношение сторон изображения " + maxRatio + ", а у этой " + ratio);
    }
}
