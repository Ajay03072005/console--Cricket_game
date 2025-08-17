import java.util.*;
 class player {
    private final String name ;
    private  int runs;
    private int wickets;
    private  int balls;
    public player(String name){
        this.name = name;
        this.runs = 0;
        this.balls = 0;
        this.wickets = 0;
    }
    public String getName(){
        return name;
    }
    public int getballs(){
        return balls;
    }
    public int getruns(){
        return runs;
    }
    public int getwickets(){
        return wickets;
    }
    public void addruns(int r){
        this.runs+=r;
    }
    public void addwickets(){
        this.wickets +=1;
    }
    public void addballs(){
        this.balls +=1;
    }
    public void reset(){
        this.runs=0;
        this.balls = 0;
        this.wickets = 0;
    }
}
