package EVoter;

import java.util.ArrayList;

public class Registration {

    private int numberOfRegisteration;
    private  String voterID;
    private  String candidateID;
    private int numberOfCandidateRegisterated;
    private static ArrayList<Voter> voteRegistration = new ArrayList<>();
    private static ArrayList<Candidate> electionCandidate = new ArrayList<>();

    public Voter voterRegistration(int userAge, String userName, char userGender, String password) {
        this.voterID = generateVoterID();
        Voter voters = new Voter(userAge, userName, userGender, voterID, password);
        voteRegistration.add(voters);
        return voters;
    }

    public Candidate candidateRegistration(String candidateName) {
        this.candidateID = generateCandidateID();
        Candidate candidates = new Candidate(candidateName, candidateID);
        electionCandidate.add(candidates);
        return candidates;
    }

    private String generateCandidateID() {
        numberOfCandidateRegisterated++;
        return "NGc" + Integer.toString(numberOfCandidateRegisterated);
    }
    public int getNumberOfCandidateRegisterated(){
        return numberOfCandidateRegisterated;
    }
    public int getnumberOfRegisteration(){
        return numberOfRegisteration;
    }

    private String generateVoterID(){
        numberOfRegisteration++;
        return "NGv" + Integer.toString(numberOfRegisteration);
    }
    public Voter findVoterAccount(String voterID){
        for(Voter voters : voteRegistration){
            if(voters.getUserID().equals(voterID)){
                return voters;
            }
            else{
                throw new IllegalArgumentException("Voter Account is Invalid");
            }
        }
        return null;
    }
    public Candidate findCandidateAccount(String candidateID) {
        for (Candidate candidates : electionCandidate) {
            if (candidates.getCandidateID().equals(candidateID)) {
                return candidates;
            } else {
                throw new IllegalArgumentException("Candidate Account is Invalid");
            }
        }
        return null;
    }
}
