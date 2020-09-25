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

    public Actor nextTurn() {
        Actor nextActorTurns = null;
        for (Actor actor : actorTurns.keySet()){
            if (nextActorTurns == null) {
                nextActorTurns = actor;
            } else if (actorTurns.get(actor) > actorTurns.get(nextActorTurns)){
                nextActorTurns = actor;
            }
        }
//        if (nextActorTurns == null) {
//            for (Actor actor : actorTurns.keySet()){
//                int turn = actorTurns.get(actor) + actor.getSpeed();
//                actorTurns.replace(actor, actorTurns.get(actor), turn);
//            }
//            return nextTurn();
//        }
//        else{
//            return nextActorTurns;
//        }
        return nextActorTurns;
    }

//    public String printTurnMeters() {
//    }

    static class InvalidActorSpeed extends RuntimeException{

    }
}
