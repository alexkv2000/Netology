package day10.ResumeEngineers;

public class Experience {
    String Experience;

    public Experience() {
        Experience = "Разработка моделей проектирования, Построения сетей";
    }

    public Experience(String experience) {
        Experience = experience;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String sExperience) {
        Experience += ", " + sExperience;
    }
}
