package day10.ResumeEngineers;

public class PythonDeveloper extends Engineer implements Css, Html, ProgramDeveloper {

    public PythonDeveloper(String sKnowledge, Experience sExperience) {
        super(sKnowledge, sExperience);
    }

    @Override
    public void addCSS() {
        super.setsKnowledge(", " + "Знания CSS");

    }

    @Override
    public void delCSS() {
        String str = super.sKnowledge;
        super.sKnowledge = str.replace(", " + "Знания CSS", "");
    }

    @Override
    public void setExperience(String sExperience) {
        super.setExperience(sExperience);
    }

    @Override
    public void addHTML() {
        super.setsKnowledge(", " + "Знания HTML");
    }

    @Override
    public void delHTML() {
        String str = super.sKnowledge;
        super.sKnowledge = str.replace(", " + "Знания HTML", "");
    }

    @Override
    public void addPython() {
        super.setsKnowledge(", " + "Знания Python");
    }

    @Override
    public void delPython() {
        String str = super.sKnowledge;
        super.sKnowledge = str.replace(", " + "Знания Python", "");
    }

    @Override
    public void addCPlus() {
        super.setsKnowledge(", " + "Знания С++");
    }

    @Override
    public void delCPlus() {
        String str = super.sKnowledge;
        super.sKnowledge = str.replace(", " + "Знания С++", "");
    }

    @Override
    public void addJava() {
        super.setsKnowledge(", " + "Знания Java");
    }

    @Override
    public void delJava() {
        String str = super.sKnowledge;
        super.sKnowledge = str.replace(", " + "Знания Java", "");
    }

    @Override
    public void addDotNet() {
        super.setsKnowledge(", " + "Знания Dot.Net");
    }

    @Override
    public void delDotNet() {
        String str = super.sKnowledge;
        super.sKnowledge = str.replace(", " + "Знания Dot.Net", "");
    }

    @Override
    public String toString() {
        return "Python разработчик{" +
                "\nзнания = " + sKnowledge +
                ".\n  опыт = " + getExperience() +
                '.';
    }
}
