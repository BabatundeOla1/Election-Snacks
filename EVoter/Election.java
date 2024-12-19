package EVoter;

import java.util.Scanner;

public class Election {

    private String position;
    private static Registration register = new Registration();
    
    public Election(String position){
        this.position = position;
    }
    public static void main(String[] args) {
        displayMenu();
    }
    public static void displayMenu(){
        String mainMain = """
                        ==============================
                                BIVAS NIGERIA
                        ==============================
                        1 -> Register Voter
                        2 -> Register Candidate
                        3 -> Login
                        4 -> Exit
                        ==============================
                            Select an Option:
                        ==============================
                """;
        display(mainMain);
        String userOption = input("Enter option: ");
        switch (userOption){
            case "1":
                registerVoter();
            case "2":
                registerCandidate();
            case "3":
                login();
            default:
                displayMenu();
        }
    }

    private static void registerVoter(){
        String name = input("Enter name: ");
        String registerGender = input("Enter gender: ");
        char gender = registerGender.charAt(0);
        int age = Integer.parseInt(input("Enter age: "));
        String password = input("Enter password: ");
        Voter voters = register.voterRegistration(age,name,gender,password);
        display("Account created successfully!!" + "\n" + name  + " Your I.D is " + voters.getUserID());
        displayMenu();
    }
    private static void registerCandidate(){
        String name = input("Enter name: ");
        Candidate candidates = register.candidateRegistration(name);
        display("Account created successfully!!" +  "\n" + name + " Your I.D is " + candidates.getCandidateID());
        displayMenu();
    }

    public static void login(){
        loginMenu();
    }

    public static void loginMenu(){
        String loginMenu = """
                        ==============================
                                BIVAS LOGIN
                        ==============================
                        1 -> Voter Login
                        2 -> Candidate Login
                        3 -> Exit
                        ==============================
                            Select an Option:
                        ==============================
                """;
        display(loginMenu);
        String userOption = input("Enter option: ");
        switch (userOption){
            case "1" :
                voterLogin();
            case "2":
                candidateLogin();
            case "3":
                displayMenu();
        }
    }

    private static void candidateLogin() {
        String candidateID = input("Enter I.D: ");
        Candidate candidate = register.findCandidateAccount(candidateID);
        display("Login Successful.");
    }

    private static void voterLogin(){
        String voterID = input("Enter I.D: ");
        String voterPassword = input("Enter Password: ");
        Voter voter = register.findVoterAccount(voterID);
        voter.setPassword(voterPassword);
        display("Login Successful.");
    }

    public static void voterMenu(){
        String voterMenu = """
                        ==============================
                               BIVAS VOTE MENU
                        ==============================
                        1 -> Cast Vote
                        2 -> Check Vote Result
                        3 -> Login Menu
                        4 -> Main Menu
                        ==============================
                            Select an Option:
                        ==============================
                """;
        display(voterMenu);
        String voterOption = input("Enter option: ");
        switch (voterOption){
            case "1" :
                Vote();
            case "2":
                checkResult();
            case "3":
                loginMenu();
            default:
                displayMenu();
        }

    }

    private static void Vote() {
        String votingCategory = """
                        ==============================
                               VOTE CATEGORY
                        ==============================
                        1 -> President
                        2 -> Governor
                        3 -> Senator
                        4 -> Vote Menu
                        ==============================
                            Select an Option:
                        ==============================
                """;
        display(votingCategory);
        String votingOption = input("Select Option: ");
        switch (votingOption){
            case "1": 
                castPresidentVote();
            case "2": 
                castGovernorVote();
            case "3": 
                castSenatorVote();
            default:
                voterMenu();
                
        }
    }

    private static void castPresidentVote() {

    }

    private static String input(String message){
        Scanner sc = new Scanner(System.in);
        display(message);
        return sc.nextLine();
    }
    private static void display(String message){
        System.out.println(message);
    }
}
