package day10.ResumeEngineers;

public class FullStackDesigner extends FrontEndDeveloper implements Databases {

    public FullStackDesigner(String sKnowledge, Experience sExperience) {
        super(sKnowledge, sExperience);
    }

    @Override
    public void addSQL() {
        super.setsKnowledge(", " + "Знание реляционных БД (MS SQL, MySQL, Postgre SQL)");
    }

    @Override
    public void delSQL() {
        String str = super.sKnowledge;
        super.sKnowledge = str.replace(", " + "Знание реляционных БД (MS SQL, MySQL, Postgre SQL)", "");
    }

    @Override
    public void addNoSQL() {
        super.setsKnowledge(", " + "Знание не реляционных БД (CouchDB, Couchbase, MongoDB, eXist)");
    }

    @Override
    public void delNoSQL() {
        String str = super.sKnowledge;
        super.sKnowledge = str.replace(", " + "Знание не реляционных БД (CouchDB, Couchbase, MongoDB, eXist)", "");
    }

    @Override
    public String toString() {
        return "Фулстэк разработчик{" +
                "\nзнания = " + sKnowledge +
                ".\n  опыт = " + getExperience() +
                '.';
    }

    @Override
    public void setExperience(String sExperience) {
        Experience += ", " + sExperience;
    }
}
