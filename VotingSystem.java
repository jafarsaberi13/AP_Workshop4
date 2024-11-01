import java.util.ArrayList;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    public VotingSystem() {
        this.votingList = new ArrayList<>();
    }

    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> options) {
        votingList.add(new Voting(type, question, isAnonymous, options));
    }

    public Voting getVoting(int index) {
        if (index >= 0 && index < votingList.size()) {
            return votingList.get(index);
        } else {
            return null;
        }
    }

    public void printVoting(int index) {
        Voting voting = getVoting(index);
        if (voting != null) {
            voting.printResults();
        } else {
            System.out.println("Voting not found.");
        }
    }

    public void printVoters(int index) {
        Voting voting = getVoting(index);
        if (voting != null) {
            voting.printVoters();
        } else {
            System.out.println("Voting not found.");
        }
    }
}
