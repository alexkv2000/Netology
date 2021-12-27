package day9.MusicEditor.Instruments;

import day9.MusicEditor.Instrument;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 18:47
 */
public class Baraban extends DefInstrument implements Instrument {
    String barabanInstrument = "\n                    ";
    char ChBaraban = 579;

    public Baraban(int leng) {
        for (int i = 0; i < leng; i++) {
            if (Math.random() * 10 >= 4) {
                barabanInstrument += String.valueOf(ch);
            } else {
                barabanInstrument += String.valueOf(ChBaraban);
            }
        }
    }

    @Override
    public String getTrack() {
        return barabanInstrument;
    }

    ;

    @Override
    public String toString() {
        return barabanInstrument;
    }
}
