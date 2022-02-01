package day9.MusicEditor;

/**
 * KAU
 * Netology
 * 2021-12-27 17:14
 */
public class Song {
    String name;
    Instrument[] instrument;

    public Song(String name, Instrument[] instrument) {

        this.name = name;
        this.instrument = instrument;
    }

    public String getName() {
        return name;
    }

    public void getInstrument() {
        System.out.print(getName());
        for (Instrument ins : instrument) {
            System.out.print("\n          " + ins.getName());
            System.out.format(ins.getTrack());
        }
        System.out.println();
    }
}
