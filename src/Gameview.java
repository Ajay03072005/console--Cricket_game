import java.util.*;
public class Gameview{
    private final Scanner scanner = new Scanner(System.in);
    public void showbanner(){
        System.out.println(ConsoleColors.RED+"-------------------------------------------------------------------------------"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW+"-------------------------------Console Cricket game-------------------------"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED+"-------------------------------------------------------------------------------"+ConsoleColors.RESET);
    }
    public int showmenu(){
        System.out.println(ConsoleColors.GREEN+"1. Start Match"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN+"2. Instructions"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN+"3. Exit"+ConsoleColors.RESET);
        System.out.print(ConsoleColors.GREEN+"> "+ConsoleColors.RESET);
        return readIntInRange(1, 3);
    }
    public void showinstruction(){
        System.out.println(ConsoleColors.BLUE+"\nHow to Play:"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE+"- Toss decides who bats/bowls first."+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE+"- On each ball, enter a number 1-6."+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE+"- If your number matches the opponent's, it's OUT."+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE+"- Otherwise, runs are added equal to the batting number."+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE+"- 2 overs match (12 balls) with 2 wickets."+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE+"\nPress Enter to continue..."+ConsoleColors.RESET);
        scanner.nextLine();
    }
    public String asktosscall(){
        System.out.print(ConsoleColors.PURPLE_BOLD+"Toss (Heads/Tails) [H/T]: "+ConsoleColors.RESET);
        while (true) {
            String s = scanner.nextLine().trim().toUpperCase();
            if (s.equals("H") || s.equals("HEADS")) return "H";
            if (s.equals("T") || s.equals("TAILS")) return "T";
            System.out.print("Please enter H or T: ");
        }
    }
    public int asktobowl(){
        System.out.println("Choose: 1) Bat 2) Bowl");
        System.out.print("> ");
        return readIntInRange(1, 2);
    }
    public int askShot() {
        System.out.print("Enter your shot (1-6): ");
        return readIntInRange(1, 6);
    }
    public int askBall() {
        System.out.print("Enter your ball (1-6): ");
        return readIntInRange(1, 6);
    }
    public void showTossResult(boolean userWon, String userChoice) {
        System.out.println(userWon ? "You won the toss." : "Computer won the toss.");
        if (userWon) {
            System.out.println("You chose to " + (userChoice.equals("BAT") ? "Bat" : "Bowl") + " first.\n");
        } else {
            System.out.println("Computer chose to " + (userChoice.equals("BAT") ? "Bat" : "Bowl") + " first.\n");
        }
    }
    public void showScorecard(String inningsTitle, scoreCard sc, Integer target, Integer lastBallRuns, boolean lastBallOut) {
        System.out.println("------------------------------");
        System.out.println(inningsTitle);
        System.out.println("Overs: " + sc.overstext());
        System.out.println("Score: " + sc.getruns() + " / " + sc.getwickets());
        double oversDecimal = sc.getballs() / 6 + (sc.getballs() % 6) / 10.0; // for display only
        double runRate = oversDecimal == 0.0 ? 0.0 : (sc.getruns() / oversDecimal);
        System.out.printf(Locale.US, "Run Rate: %.2f\n", runRate);
        if (target != null) {
            int needed = Math.max(0, target - sc.getruns());
            System.out.println("Target: " + target + " (Need " + needed + ")");
        }
        if (lastBallRuns != null) {
            if (lastBallOut) System.out.println("Last Ball: OUT");
            else System.out.println("Last Ball: " + lastBallRuns + " run(s)");
        }
        System.out.println("------------------------------\n");
    }
    public void showSummary(player batting1, scoreCard sc1, player batting2, scoreCard sc2, String result) {
        System.out.println("==============================");
        System.out.println(" MATCH SUMMARY");
        System.out.println("==============================");
        System.out.println("1st Innings (" + batting1.getName() + ")");
        System.out.println("Runs: " + sc1.getruns() + ", Wkts: " + sc1.getwickets() + ", Overs: " + sc1.overstext());
        double rr1 = (sc1.getballs()==0)?0.0:( (double)sc1.getruns() / (sc1.getballs()/6.0) );
        System.out.printf(Locale.US, "Run Rate: %.2f\n\n", rr1);


        System.out.println("2nd Innings (" + batting2.getName() + ")");
        System.out.println("Runs: " + sc2.getruns() + ", Wkts: " + sc2.getwickets() + ", Overs: " + sc2.overstext());
        double rr2 = (sc2.getballs()==0)?0.0:( (double)sc2.getruns() / (sc2.getballs()/6.0) );
        System.out.printf(Locale.US, "Run Rate: %.2f\n\n", rr2);
        System.out.println("Result: " + result);
        System.out.println("==============================\n");
    }


    private int readIntInRange(int lo, int hi) {
        while (true) {
            String s = scanner.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < lo || v > hi) throw new NumberFormatException();
                return v;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number between " + lo + " and " + hi + ": ");
            }
        }
    }
}
