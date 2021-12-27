package day9.MusicEditor;

import day9.MusicEditor.Instruments.Baraban;
import day9.MusicEditor.Instruments.Gitar;
import day9.MusicEditor.Instruments.Piano;


/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 17:05
 */
public class Main {
    public static void main(String[] args) {

        Song[] song = new Song[]{
                new Song("Bagem rhapsody", new Instrument[]{
                        new Gitar(40),
                        new Piano(40),
                        new Baraban(45),
                        new Gitar(38)}),
                new Song("Blood type", new Instrument[]{
                        new Gitar(23),
                        new Piano(25),
                        new Baraban(17)}),
                new Song("Classic", new Instrument[]{
                        new Baraban(20),
                        new Piano(20),
                        new Gitar(20)}),
        };


        //TODO вывод на консоль
        for (Song i : song) {
            i.getInstrument();
        }
    }
}