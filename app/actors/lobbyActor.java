package actors;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import play.mvc.LegacyWebSocket;
import play.mvc.WebSocket;

@Singleton
public class lobbyActor {
    
    private List<LegacyWebSocket<String>> games;
    
    public lobbyActor() {
        games = new ArrayList<LegacyWebSocket<String>>();
    }
    
    public LegacyWebSocket<String> getSocket(int index){
        if(index < 0 || index >= games.size()){
            return null;
        }
        else {
            return games.get(index);
        }
    }
    
    public int startGame() {
        games.add(WebSocket.withActor(mainActor::props));
        return games.size() - 1;
    }
    
    public int getNumberOfGames(){
        return games.size();
    }
}