package by.gritsuk.dima.util;

public class ResultGenerator {
    private static final int FOOTBALL_MAX=7;
    private static final int BASKETBALL_MAX=120;

    public static String generate(Integer sportId){
        String result=null;
        int team1=0;
        int team2=0;
        int difference;
        switch (sportId){
            case 1:
                team1=(int)(Math.random()*FOOTBALL_MAX);
                team2=(int)(Math.random()*FOOTBALL_MAX);
                result=team1+":"+team2;
                break;
            case 2:
                team1=(int)(Math.random()*BASKETBALL_MAX);
                team2=(int)(Math.random()*BASKETBALL_MAX);
                result=team1+":"+team2;
                break;
            case 3:
                while(team1==team2) {
                    team1 = (int) (Math.random() * 26);
                    team2 = (int) (Math.random() * 26);
                }
                result=team1>team2?"25:"+team2:team1+":25";
                break;
            case 4:
                while(team1==team2) {
                    team1 = (int) (Math.random() * 10);
                    team2 = (int) (Math.random() * 10);
                }
                result=team1>team2?"team 1 win":"team 2 win";
                break;
            case 5:
                while(team1==team2){
                    team1 = (int) (Math.random() * 10);
                    team2 = (int) (Math.random() * 10);
                }
                difference=(int)(Math.random()*2)+1;
                result=team1>team2?"3:"+(3-difference):(3-difference)+":3";
                break;
            case 6:
                while(team1==team2){
                    team1 = (int) (Math.random() * 10);
                    team2 = (int) (Math.random() * 10);
                }
                difference=(int)(Math.random()*2)+1;
                result=team1>team2?"3:"+(3-difference):(3-difference)+":3";
                break;
        }
        return result;
    }
}
