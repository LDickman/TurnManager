import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TurnManagerTests {
    @Test
    public void canCreateManager(){
        TurnManager manager = new TurnManager();
    }

    @Test
    public void canAddActorToManager() {
        TurnManager manager = new TurnManager();
        Actor actor = new SimpleActor("George", 13);
        Actor actor2 = new SimpleActor("George", 15);
        manager.add(actor);
        assertEquals(1, manager.actorTurns.size());
        manager.add(actor2);
        assertEquals(2, manager.actorTurns.size());
    }

    @Test (expected = TurnManager.InvalidActorSpeed.class)
    public void throwsExceptionOnNegativeSpeedActor() {
        TurnManager manager = new TurnManager();
        Actor actor = new SimpleActor("Bob", -7);
        manager.add(actor);
    }

    @Test
    public void cannotAddTwoEquivalentActors() {
        TurnManager manager = new TurnManager();
        Actor actor = new SimpleActor("Bob", 27);
        Actor actor2 = new SimpleActor("Bob", 27);
        manager.add(actor);
        manager.add(actor2);
        assertEquals(1, manager.actorTurns.size());
    }

    @Test
    public void canRemoveActors() {
        TurnManager manager = new TurnManager();
        Actor actor = new SimpleActor("Fred", 17);
        manager.add(actor);
        manager.remove(actor);
        assertEquals(0, manager.actorTurns.size());
    }

    @Test
    public void canMoveToNextTurn() {
        TurnManager manager = new TurnManager();
        Actor actor = new SimpleActor("Fred", 13);
        manager.add(actor);
        Actor next = manager.nextTurn();
        assertEquals(actor, next);
    }

    @Test
    public void multipleActorsInNextTurnReturnsActorWithHighestSpeed() {
        TurnManager manager = new TurnManager();
        Actor tim = new SimpleActor("Tim", 4);
        Actor robert = new SimpleActor("Robert", 30);
        Actor bob = new SimpleActor("Bob", 16);
        
        manager.add(tim);
        manager.add(bob);
        manager.add(robert);

        Actor next = manager.nextTurn();
        assertEquals(robert, next);
    }



}
