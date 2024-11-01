import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        ArrayList<String> options = new ArrayList<>();
        options.add("Option A");
        options.add("Option B");

        votingSystem.createVoting("Do you like coffee?", false, 1, options);
        Voting voting = votingSystem.getVoting(0);

        if (voting != null) {
            Person p1 = new Person("John", "Doe");
            ArrayList<String> choices = new ArrayList<>();
            choices.add("Option A");
            voting.vote(p1, choices, "2024-11-01");

            votingSystem.printVoting(0);
            votingSystem.printVoters(0);
        }
    }
}
