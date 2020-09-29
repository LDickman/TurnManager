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
        if (actorTurns.get(nextActorTurns) <= 100) {
            for (Actor actor : actorTurns.keySet()){
                int turn = actorTurns.get(actor) + actor.getSpeed();
                actorTurns.replace(actor, actorTurns.get(actor), turn);
            }
            return nextTurn();
        }
        else{
            actorTurns.replace(nextActorTurns, 0);
            return nextActorTurns;
        }
    }

    public String printTurnMeters() {
        Comparator<? super Actor> compare = (Comparator<Actor>) (a1, a2) -> {return actorTurns.get(a2) - actorTurns.get(a1); };
        Actor[] arr = actorTurns.keySet().toArray(new Actor[0]);
        Arrays.sort(arr, compare);
        String listOfActors = "";
        for (Actor actor : arr) {
            listOfActors += String.format("%-" + getLengthOfLongestName() + "s   Turn meter: %2s   Speed: %2s\n", actor.getName(), actorTurns.get(actor), actor.getSpeed());
        }
        return listOfActors;
    }

    private int getLengthOfLongestName() {
        Comparator<? super Actor> compare = (Comparator<Actor>) (a1, a2) -> {return a2.getName().length() - a1.getName().length(); };
        Actor[] arr = actorTurns.keySet().toArray(new Actor[0]);
        Arrays.sort(arr, compare);
        return arr[0].getName().length();
    }


    static class InvalidActorSpeed extends RuntimeException{

    }
}
