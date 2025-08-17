public class Match {
    private final player user;
    private final player cpu;
    private player winner;
    private final int overslimit;
    private Integer target;
    public Match(player user, player cpu, int overslimit){
        this.user = user;
        this.cpu = cpu;
        this.overslimit =overslimit;
        this.winner = null;
        this.target = null;
    }
    public player getUser() {
        return user;
    }
    public player getCpu() {
        return cpu;
    }
    public int getOversLimit() {
        return overslimit;
    }
    public Integer getTarget() {
        return target;
    }
    public void setTarget(int t) {
        target = t;
    }
    public player getWinner() {
        return winner;
    }
    public void setWinner(player p) {
        winner = p;
    }

}
