package day9.MusicEditor.Instruments;

import day9.MusicEditor.Instrument;
import day9.MusicEditor.MusicInstruments;

/**
 * author KAU
 * project Netology
 * create 2021-12-27 18:47
 */
public class Baraban extends MusicInstruments implements Instrument {
    String barabanInstrument = "";
    char ChBaraban = '@';
    String name = "барабан - ";

    public Baraban(int leng) {
        super("Барабан");
        for (int i = 0; i < leng; i++) {
            if (Math.random() * 10 >= 4) {
                barabanInstrument += "  ";
            } else {
                barabanInstrument += " " + ChBaraban;
            }
        }
    }

    @Override
    public String getTrack() {
        return barabanInstrument;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return barabanInstrument;
    }
}
