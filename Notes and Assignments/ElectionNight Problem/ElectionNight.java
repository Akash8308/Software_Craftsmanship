// It's election night! 

// Exciting! We have a feed of election results from a data supplier. They will supply us a file which will contain the votes share for each constituency. Write code to find out the winning party from each constituency and print it to console.
// The input file will consist of:

// A constituency
// A repeating set of pairs with the party code and the votes cast

// Party Codes -
// BJP - Bhartiya Janta Party
// INC - Indian National Congress
// BSP - Bahujan Samaj Party
// CPI - Communist Party of India
// NCP - Nationalist Congress Party
// IND - Independant

// Sample line from the input file -
// Jaipur-BJP=400,INC=250,CPI=20,NCP=150

// Sample Output to Console -
// Constituency, Winning Party, Vote Share 
// Jaipur, Bhartiya Janta Party, 48.8

import java.util.*;

public class ElectionNight {

    private static String getPartyName(String partyCode) {
        switch (partyCode) {
            case "BJP":
                return "Bhartiya Janta Party";
            case "INC":
                return "Indian National Congress";
            case "BSP":
                return "Bahujan Samaj Party";
            case "CPI":
                return "Communist Party of India";
            case "NCP":
                return "Nationalist Congress Party";
            case "IND":
                return "Independent";
            default:
                return "Unknown Party";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Constituency, Winning Party, Vote Share");

        String line = sc.nextLine();

        String[] parts = line.split("-", 2);
        String constituency = parts[0];
        String[] partyData = parts[1].split(",");

        String winningParty = "";
        int maxVotes = 0;
        int totalVotes = 0;

        for (String partyString : partyData) {
            String[] partyVotes = partyString.split("=");
            String partyCode = partyVotes[0];
            int votes = Integer.parseInt(partyVotes[1]);
            totalVotes += votes;

            if (votes > maxVotes) {
                maxVotes = votes;
                winningParty = getPartyName(partyCode);
            }
        }

        double voteShare = (double) maxVotes / totalVotes * 100;
        System.out.printf("%s, %s, %.1f%n", constituency, winningParty, voteShare);
    }
}