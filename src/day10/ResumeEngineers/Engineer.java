package day10.ResumeEngineers;

public class Engineer extends Experience {
    String sKnowledge; // знания
    Experience sExperience; // опыт

    Engineer(String sKnowledge, Experience sExperience) {
        this.sKnowledge = sKnowledge;
        this.sExperience = sExperience;
    }

    public String getsKnowledge() {
        return sKnowledge;
    }

    public void setsKnowledge(String sKnowledge) {

        this.sKnowledge += sKnowledge;
    }

    @Override
    public String toString() {
        return "Инженер{" +
                "\nзнания = " + sKnowledge +
                ".\n  опыт = " + getExperience() +
                '.';
    }
}
