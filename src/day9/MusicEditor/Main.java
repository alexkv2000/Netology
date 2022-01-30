package day9.MusicEditor;

import day9.MusicEditor.Instruments.Baraban;
import day9.MusicEditor.Instruments.Gitar;
import day9.MusicEditor.Instruments.Piano;


/**
 * KAU
 * Netology
 * 2021-12-27 17:05
 */
public class Main {
    public static void main(String[] args) {
        Song[] song = new Song[]{
                new Song("Bagem rhapsody", new Instrument[]{
                        new Gitar(45),
                        new Piano(45),
                        new Baraban(45),
                        new Gitar(45)}),
                new Song("Blood type", new Instrument[]{
                        new Gitar(25),
                        new Piano(25),
                        new Baraban(25)}),
                new Song("Classic", new Instrument[]{
                        new Baraban(45),
                        new Piano(45),
                        new Gitar(45)}),
        };


        //TODO вывод на консоль
        for (Song i : song) {
            i.getInstrument();
        }
    }
}