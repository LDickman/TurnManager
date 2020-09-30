import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TurnManagerTests {

    private TurnManager manager = new TurnManager();


    @Test
    public void canAddActorToManager() {
        Actor actor = new SimpleActor("George", 13);
        Actor actor2 = new SimpleActor("George", 15);
        int expected = 1;
        manager.add(actor);
        assertEquals(expected, manager.actorTurns.size());
        manager.add(actor2);
        assertEquals(2, manager.actorTurns.size());
    }

    @Test (expected = TurnManager.InvalidActorSpeed.class)
    public void throwsExceptionOnNegativeSpeedActor() {
        Actor actor = new SimpleActor("Bob", -7);
        manager.add(actor);
    }

    @Test
    public void cannotAddTwoEquivalentActors() {
        Actor actor = new SimpleActor("Bob", 27);
        Actor actor2 = new SimpleActor("Bob", 27);
        manager.add(actor);
        manager.add(actor2);
        assertEquals(1, manager.actorTurns.size());
    }

    @Test
    public void canRemoveActors() {
        Actor actor = new SimpleActor("Fred", 17);
        manager.add(actor);
        manager.remove(actor);
        assertEquals(0, manager.actorTurns.size());
    }

    @Test
    public void canMoveToNextTurn() {
        Actor actor = new SimpleActor("Fred", 13);
        manager.add(actor);
        Actor next = manager.nextTurn();
        assertEquals(actor, next);
    }

    @Test
    public void multipleActorsInNextTurnReturnsActorWithHighestSpeed() {
        Actor tim = new SimpleActor("Tim", 4);
        Actor robert = new SimpleActor("Robert", 30);
        Actor bob = new SimpleActor("Bob", 16);
        
        manager.add(tim);
        manager.add(bob);
        manager.add(robert);

        Actor next = manager.nextTurn();
        assertEquals(robert, next);
    }

    @Test
    public void multipleActorsInNextTurnReturnsActorWithHighestSpeedAndTurnMeters() {
        Actor Jim = new SimpleActor("Jim", 40);
        Actor Lily = new SimpleActor("Lily", 77);
        Actor Bobby = new SimpleActor("Bobby", 9);

        manager.add(Jim);
        manager.add(Bobby);
        manager.add(Lily);

        Actor next = manager.nextTurn();
        assertEquals(Lily, next);
    }

    @Test
    public void withMultipleActorsNextTurnResetsTheChosenActorsMeterToZero() {
        Actor Jim = new SimpleActor("Jim", 40);
        Actor Lily = new SimpleActor("Lily", 77);
        Actor Bobby = new SimpleActor("Bobby", 9);

        manager.add(Jim);
        manager.add(Bobby);
        manager.add(Lily);
        Actor next = manager.nextTurn();

        assertEquals(Integer.valueOf(0), manager.actorTurns.get(next));
    }

    @Test
    public void withMultipleActorsAndMultipleCallsToNextTurnItReturnsCorrectActor() {
        Actor Jim = new SimpleActor("Jim", 40);
        Actor Lily = new SimpleActor("Lily", 77);
        Actor Bobby = new SimpleActor("Bobby", 9);

        manager.add(Jim);
        manager.add(Bobby);
        manager.add(Lily);
        manager.nextTurn();
        Actor next = manager.nextTurn();

        assertEquals(Jim, next);
    }

    @Test
    public void multipleActorsWithTheSameHighestSpeedAndTurnMeters_OrderDoesNotMatter() {
        Actor kevin = new SimpleActor("Kevin", 50);
        Actor henry = new SimpleActor("Henry", 50);
        Actor mary = new SimpleActor("Mary", 50);
        Actor jacob = new SimpleActor("Jacob", 50);

        manager.add(mary);
        manager.add(kevin);
        manager.add(henry);
        manager.add(jacob);

        Actor next = manager.nextTurn();
        Actor[] actors = {kevin, mary, henry, jacob};
        boolean contains = Arrays.asList(actors).contains(next);
        assertEquals(true, contains);
    }

    @Test
    public void printingNamesIsInOrderOfTurnMeterAndAlignedToLongestName() {
        Actor Jim = new SimpleActor("Jim", 40);
        Actor Lily = new SimpleActor("Lily", 77);
        Actor Bobby = new SimpleActor("Bobby", 9);
        Actor Will = new SimpleActor("William II", 3);

        manager.add(Jim);
        manager.add(Bobby);
        manager.add(Lily);
        manager.add(Will);
        manager.nextTurn();

        String expected =
                "Jim          Turn meter: 80   Speed: 40\n" +
                "Bobby        Turn meter: 18   Speed:  9\n" +
                "William II   Turn meter:  6   Speed:  3\n" +
                "Lily         Turn meter:  0   Speed: 77\n";
        assertEquals(expected, manager.printTurnMeters());
    }

}
