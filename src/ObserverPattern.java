import java.util.ArrayList;
import java.lang.*;

interface Iplayer{
    void adjustAttackValue(int value);
}

class Game
{
    // todo
    ArrayList<Iplayer> players = new ArrayList<>();

    public void enterPlay(Iplayer player){
        players.add(player);
        broadcast();
    }

    public void LeavePlay(Iplayer player){
        players.remove(player);
        broadcast();
    }


    public void broadcast(){
        int totalPlayers = players.size();
        for (Iplayer p: players) {
            p.adjustAttackValue(totalPlayers);
        }
    }


}

class Rat implements Iplayer,AutoCloseable{

    public int attack = 1;
    Game game;
    Rat(Game game){
        this.game = game;
        game.enterPlay(this);
    }

    @Override
    public void adjustAttackValue(int value) {
        attack = value;
    }

    @Override
    public void close()  {
        game.LeavePlay(this);
    }
}