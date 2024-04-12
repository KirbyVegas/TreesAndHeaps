import java.util.*;

public class Election {

    //map of candidates that holds their name and number of votes
    public HashMap<String, Integer> candidates;
    public Heap heap;
    public Election() {
        candidates = new HashMap<>();
        heap = new Heap();
    }

    public void initializeCandidates(LinkedList<String> theCandidates) {
        //start each candidate with a vote count of zero
        for(String theCandidate : theCandidates) {
            candidates.put(theCandidate, 0);
            //adding initial votes to the heap
            heap.addVotes(0);
        }
    }

    //add one vote to given candidate
    public void castVote(String candidate) {
        int currentVotes = candidates.get(candidate);
        candidates.put(candidate, currentVotes+1);
        heap.remove(currentVotes);
        heap.addVotes(currentVotes+1);
        //not working properly
        heap.maxHeapify(currentVotes);
    }

    public void castRandomVote() {
        Random random = new Random();
        //make an array list of the names(keys) of the candidates
        ArrayList<String> listCandidates = new ArrayList<>(candidates.keySet());
        //get the string of a random candidate in the list of names
        String randomCand = listCandidates.get(random.nextInt(listCandidates.size()));
        castVote(randomCand);
    }

    public void rigElection(String candidate) {
        //right now just sets the candidate's votes to the highest candidate's votes
        int newVotes = heap.getAtIndex(0);
        candidates.remove(candidate);
        candidates.put(candidate, newVotes);

//        for(int votes : candidates.values()) {
//            if(votes == newVotes) {
//                votes = 0;
//                break;
//            }
//        }
    }

    public String[] getTopKCandidates(int k) {
        int[] topK = new int[k];
        String[] result = new String[k];

        for(int i = 0; i<k; i++) {
            topK[i] = heap.getAtIndex(i);
        }
        for(int j = 0; j<topK.length; j++) {
            for(String current : candidates.keySet()) {
                if(candidates.get(current) == topK[j]) {
                    result[j] = current;
                    break;
                }
            }
        }
        return result;
    }

    //Print to console all the candidates and how many votes they got in order from
    //the candidate with the most votes to the candidate with the least amount of votes
    public void auditElection() {
        //idea for how to print out the names in order
        //getTopKCandidates(heap.getSize());

        for (String name: candidates.keySet()) {
            String key = name;
            int value = candidates.get(name);
            System.out.println(key + " " + value);
        }
    }
}