package day14.Candidate;


import java.util.Comparator;

public class namecomp implements Comparator<Candidate> {
    @Override
    public int compare(Candidate paramT1, Candidate paramT2) {
        if (paramT1.getRelevance() > (paramT2.getRelevance())) {
            return -1;
        } else if (paramT1.getRelevance() == (paramT2.getRelevance())) {
            if (paramT1.getRating() > (paramT2.getRating())) {
                return -1;
            } else if (paramT1.getRating() == (paramT2.getRating())) {
                return 1;
            } else {
                return 1;
            }
        }
        return 1;
    }
}
