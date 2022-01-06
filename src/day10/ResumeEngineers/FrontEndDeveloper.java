package day10.ResumeEngineers;

public class FrontEndDeveloper extends Engineer implements Css, Html {

    public FrontEndDeveloper(String sKnowledge, Experience sExperience) {
        super(sKnowledge, sExperience);
    }

    @Override
    public void addCSS() {
        super.setsKnowledge(", " + "Базовые знания CSS");

    }

    @Override
    public void delCSS() {
        String str = super.sKnowledge;
        super.sKnowledge = str.replace(", " + "Базовые знания CSS", "");
    }

    @Override
    public void setExperience(String sExperience) {
        super.setExperience(sExperience);
    }

    @Override
    public String toString() {
        return "Фронтенд разработчик{" +
                "\nзнания = " + sKnowledge +
                ".\n  опыт = " + getExperience() +
                '.';
    }

    @Override
    public void addHTML() {
        super.setsKnowledge(", " + "Базовые знания HTML");
    }

    @Override
    public void delHTML() {
        String str = super.sKnowledge;
        super.sKnowledge = str.replace(", " + "Базовые знания HTML", "");
    }
}
