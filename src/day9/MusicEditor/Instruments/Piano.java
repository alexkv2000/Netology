package day9.MusicEditor.Instruments;

import day9.MusicEditor.Instrument;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 18:46
 */
public class Piano extends DefInstrument implements Instrument {
    String pianoInstrument = "\n                    ";
    char ChPiano = '♪';

    public Piano(int leng) {
        for (int i = 0; i < leng; i++) {
            if (Math.random() * 10 >= 4) {
                pianoInstrument += String.valueOf(ch);
            } else {
                pianoInstrument += String.valueOf(ChPiano);
            }
        }
    }

    @Override
    public String getTrack() {
        return pianoInstrument;
    }

    ;

    @Override
    public String toString() {
        return pianoInstrument;
    }
}
