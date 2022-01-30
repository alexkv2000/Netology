package day9.MusicEditor.Instruments;

import day9.MusicEditor.Instrument;
import day9.MusicEditor.MusicInstruments;

/**
 * KAU
 * Netology
 * 2021-12-27 18:46
 */
public class Piano extends MusicInstruments implements Instrument {
    String pianoInstrument = "";
    char ChPiano = '!';
    String name = "пианино - ";

    public Piano(int leng) {
        super("Пианино");
        for (int i = 0; i < leng; i++) {
            if (Math.random() * 10 >= 4) {
                pianoInstrument += "  ";
            } else {
                pianoInstrument += " " + ChPiano;
            }
        }
    }

    @Override
    public String getTrack() {
        return pianoInstrument;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return pianoInstrument;
    }
}
