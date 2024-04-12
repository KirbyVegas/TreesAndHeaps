import java.util.Arrays;
import java.util.LinkedList;

public class ElectionSystem {

    public static void main(String[] args) {
        Election e = new Election();
        LinkedList<String> candidates = new LinkedList<>();
        candidates.addAll(Arrays.asList(new String[]{"Marcus Fenix", "Dominic Santiago", "Damon Baird", "Cole Train", "Anya Stroud"}));
        int p = 10;

        e.initializeCandidates(candidates);
        e.castVote("Cole Train");
        e.castVote("Cole Train");
        e.castVote("Cole Train");
        e.castVote("Marcus Fenix");
        e.castVote("Anya Stroud");
        e.castVote("Anya Stroud");

        e.castRandomVote();
        //e.rigElection("Marcus Fenix");

        System.out.println("Top candidates: ");
        String[] result = e.getTopKCandidates(3);
        System.out.println(Arrays.toString(result));

        System.out.println("\nCandidates and their votes");
        e.auditElection();

    }


}
