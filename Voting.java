import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Voting {
    private int type; // 0 for single vote, 1 for multiple votes
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type, String question, boolean isAnonymous, ArrayList<String> options) {
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
        this.voters = new ArrayList<>();
        this.choices = new HashMap<>();

        for (String option : options) {
            choices.put(option, new HashSet<>());
        }
    }

    public void vote(Person voter, ArrayList<String> voterChoices, String date) {
        if (voters.contains(voter) && type == 0) {
            System.out.println("This person has already voted.");
            return;
        }

        for (String choice : voterChoices) {
            if (choices.containsKey(choice)) {
                choices.get(choice).add(new Vote(voter, date));
            }
        }
        voters.add(voter);
    }

    public void printResults() {
        System.out.println("Results for: " + question);
        for (String choice : choices.keySet()) {
            System.out.println(choice + ": " + choices.get(choice).size() + " votes");
        }
    }

    public void printVoters() {
        System.out.println("Voters:");
        for (Person voter : voters) {
            System.out.println(voter.getFirstName() + " " + voter.getLastName());
        }
    }
}
