package day10.ResumeEngineers;

public class Main {
    public static void main(String[] args) {
        String sKnowledge = "Основы алгоритмизации, Основы построения сети, Протокол TCP/IP";

        /*Engineer engineer = new Engineer(sKnowledge,sExperience);
        System.out.println(engineer);*/
        System.out.println();

        PythonDeveloper pythonDeveloper = new PythonDeveloper(sKnowledge, new Experience());

        pythonDeveloper.addPython();
        pythonDeveloper.setExperience("Опыт работы по написанию Python основной формы ввода документов");
        pythonDeveloper.setExperience("Опыт разбора чужого кода Python");

        pythonDeveloper.addDotNet();
        pythonDeveloper.getsKnowledge();
        System.out.println(pythonDeveloper);

        FrontEndDeveloper frontEndDeveloper = new FrontEndDeveloper(sKnowledge, new Experience());

        frontEndDeveloper.addCSS();
        frontEndDeveloper.addHTML();
        System.out.println("\n" + frontEndDeveloper);

        FullStackDesigner fullStackDesigner = new FullStackDesigner(sKnowledge, new Experience());
        fullStackDesigner.addNoSQL();
        fullStackDesigner.addSQL();
        fullStackDesigner.addHTML();
        fullStackDesigner.setsKnowledge("Опыт 'самостоятельной' / 'в команде' разработке");
        System.out.println("\n" + fullStackDesigner);
    }
}
