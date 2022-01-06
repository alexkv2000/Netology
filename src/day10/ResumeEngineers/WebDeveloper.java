package day10.ResumeEngineers;

public class WebDeveloper extends FrontEndDeveloper implements Databases {

    public WebDeveloper(String sKnowledge, Experience sExperience) {
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
        return "Web разработчик{" +
                "\nзнания = " + sKnowledge +
                ".\n  опыт = " + getExperience() +
                '.';
    }
}
