import java.util.*;

public class TurnManager {
    Map<Actor, Integer> actorTurns = new HashMap<>();

    public void add(Actor actor) {
        if (actor.getSpeed() < 0){
            throw new InvalidActorSpeed();
        }
        else {
            actorTurns.put(actor, 0);
        }
    }

    public void remove(Actor actor) {
        actorTurns.remove(actor);
    }

//    public String printTurnMeters() {
//    }

    static class InvalidActorSpeed extends RuntimeException{

    }
}
