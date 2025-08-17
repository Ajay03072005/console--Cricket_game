import java.util.*;
class GameController {
    private final Gameview view;
    private final Random rng = new Random();
    private static final int OVERS_LIMIT = 2;
    private static final int MAX_WICKETS = 2;
    public GameController(Gameview view) {
        this.view = view;
    }
    public void run() {
        while (true) {
            view.showbanner();
            int choice = view.showmenu();
            if (choice == 1) startMatch();
            else if (choice == 2) view.showinstruction();
            else return;
        }
    }
    private void startMatch() {
        player user = new player("Player");
        player cpu = new player("Computer");
        Match match = new Match(user, cpu, OVERS_LIMIT);
        boolean userWonToss = performToss(view.asktosscall());
        boolean userBatsFirst;
        if (userWonToss) {
            int opt = view.asktobowl();
            userBatsFirst = (opt == 1);
            view.showTossResult(true, userBatsFirst ? "BAT" : "BOWL");
        } else {
            userBatsFirst = rng.nextBoolean() ? false : true; // 50-50
            view.showTossResult(false, userBatsFirst ? "BOWL" : "BAT");
        }

        scoreCard sc1 = new scoreCard(OVERS_LIMIT);
        scoreCard sc2 = new scoreCard(OVERS_LIMIT);
        if (userBatsFirst) {
            playBattingInnings(match, user, cpu, sc1, null);
            match.setTarget(sc1.getruns() + 1);
            playBowlingInnings(match, user, cpu, sc2, match.getTarget());
        } else {
            playBowlingInnings(match, user, cpu, sc1, null);
            match.setTarget(sc1.getruns() + 1);
            playBattingInnings(match, user, cpu, sc2, match.getTarget());
        }
        String result;
        if (sc1.getruns() == sc2.getruns()) {
            result = "Match Tied";
            match.setWinner(null);
        }
        else if (sc2.getruns() >= match.getTarget()) {
            if (userBatsFirst) {
                match.setWinner(cpu);
                result = "Computer wins by " + (MAX_WICKETS - sc2.getwickets()) + " wicket(s)";
            }
            else {
                match.setWinner(user);
                result = "You win by " + (MAX_WICKETS - sc2.getwickets()) + " wicket(s)";
            }
        }
        else {
            if (userBatsFirst) {
                match.setWinner(user);
                result = "You win by " + (match.getTarget() - 1 - sc2.getruns()) + " run(s)";
            }
            else {
                match.setWinner(cpu);
                result = "Computer wins by " + (match.getTarget() - 1 - sc2.getruns()) + " run(s)";
            }
        }
        if (userBatsFirst) view.showSummary(user, sc1, cpu, sc2, result);
        else view.showSummary(cpu, sc1, user, sc2, result);
        System.out.println("Press Enter to return to menu...");
        new Scanner(System.in).nextLine();
    }
    private boolean performToss(String userCall) {
        String toss = rng.nextBoolean() ? "H" : "T";
        return toss.equals(userCall);
    }

    private void playBattingInnings(Match match, player striker, player bowler,scoreCard sc, Integer target) {
        view.showScorecard("PLAYER BATTING", sc, target, null, false);
        while (sc.getballs() < sc.getmaxballs() && sc.getwickets() < MAX_WICKETS) {
            int userShot = view.askShot();
            int cpuBall = rng.nextInt(6) + 1; // 1-6
            boolean out = (userShot == cpuBall);
            if (out) {
                sc.updatewickets();
            } else {
                sc.updateruns(userShot);
            }
            sc.addballs();
            striker.addballs();
            if (out) bowler.addwickets(); else striker.addruns(userShot);
            if (target != null && sc.getruns() >= target) {
                view.showScorecard("PLAYER BATTING", sc, target, out ? 0 : userShot, out);
                break;
            }
            view.showScorecard("PLAYER BATTING", sc, target, out ? 0 : userShot, out);
        }
    }


    private void playBowlingInnings(Match match, player bowler, player striker, scoreCard sc, Integer target) {
        view.showScorecard("COMPUTER BATTING", sc, target, null, false);
        while (sc.getballs() < sc.getmaxballs() && sc.getwickets() < MAX_WICKETS) {
            int userBall = view.askBall();
            int cpuShot = rng.nextInt(6) + 1; // 1-6
            boolean out = (userBall == cpuShot);
            if (out) {
                sc.updatewickets();
                bowler.addwickets();
            } else {
                sc.updateruns(cpuShot);
                striker.addruns(cpuShot);
            }
            sc.addballs();
            striker.addballs();


            if (target != null && sc.getruns() >= target) {
                view.showScorecard("COMPUTER BATTING", sc, target, out ? 0 : cpuShot, out);
                break;
            }
            view.showScorecard("COMPUTER BATTING", sc, target, out ? 0 : cpuShot, out);
        }
    }
}