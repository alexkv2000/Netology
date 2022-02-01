package day9.MusicEditor.Instruments;

import day9.MusicEditor.Instrument;
import day9.MusicEditor.MusicInstruments;

/**
 * KAU
 * Netology
 * 2021-12-27 18:19
 */
public class Gitar extends MusicInstruments implements Instrument {
    String gitaInstrument = "";
    char ChGita = '#';
    String name = " гитара - ";

    public Gitar(int leng) {
        super("Гитара");
        for (int i = 0; i < leng; i++) {
            if (Math.random() * 10 >= 4) {
                this.gitaInstrument += "  ";
            } else {
                this.gitaInstrument += " " + ChGita;
            }
        }
    }


    @Override
    public String getTrack() {
        return gitaInstrument;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return gitaInstrument;
    }
}
