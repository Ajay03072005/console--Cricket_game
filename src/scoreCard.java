import java.util.*;
public class scoreCard {
    private int runs;
    private int balls;
    private int wickets;
    private final int overslimit;
    private final int ballsperover = 6;

    public scoreCard(int overslimit){
        this.runs=0;
        this.balls = 0;
        this.wickets =0;
        this.overslimit = overslimit;
    }
    public void updateruns(int r){
        runs += r;
    }
    public void updatewickets(){
        wickets +=1;
    }
    public void addballs(){
        balls +=1;
    }
    public int getruns(){
        return runs;
    }
    public int getwickets(){
        return wickets;
    }
    public int getballs(){
        return balls;
    }
    public int getmaxballs(){
        return ballsperover*overslimit ;
    }
    public int getoverslimit(){
        return overslimit;
    }
    public String overstext(){
        int ballsinover = balls%ballsperover;
        int completedballs = balls / ballsperover;
        return completedballs+"."+ballsinover+"/ "+overslimit;
    }
}
