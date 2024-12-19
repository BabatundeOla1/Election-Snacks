package EVoter;

public class Candidate {
    private String name;
    private String CandidateID;
    private int countCandidateVote;
    public Candidate(String name, String userID){
        this.name = name;
        this.CandidateID = userID;
        this.countCandidateVote = 0;
    }

    public void setName(String name) {
        validatName(name);
        this.name = name;
    }
    public int getCountCandidateVote(){
        return countCandidateVote;
    }

    public void addVote(){
        this.countCandidateVote++;
    }

    public String getName() {
        return name;
    }
    public String getCandidateID(){
        return CandidateID;
    }
    private void validatName(String name){
        if(name.matches(".*\\d.*")){
            throw new IllegalArgumentException("Invalid Name");
        }
    }
    private void validateAge(String password){
        if(password.matches(".*\\d.*")){
            throw new IllegalArgumentException("Invalid Password");
        }
    }
}
