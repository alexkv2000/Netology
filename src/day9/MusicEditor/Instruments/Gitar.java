package day9.MusicEditor.Instruments;

import day9.MusicEditor.Instrument;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 18:19
 */
public class Gitar extends DefInstrument implements Instrument {
    String gitaInstrument = "\n                    ";
    char ChGita = '♫';

    public Gitar(int leng) {
        for (int i = 0; i < leng; i++) {
            if (Math.random() * 10 >= 4) {
                this.gitaInstrument += String.valueOf(ch);
            } else {
                this.gitaInstrument += String.valueOf(ChGita);
            }
        }
    }


    @Override
    public String getTrack() {
        return gitaInstrument;
    }

    ;

    @Override
    public String toString() {
        return gitaInstrument;
    }
}
