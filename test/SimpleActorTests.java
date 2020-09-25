import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleActorTests {
    @Test
    public void canReturnCorrectNameAndSpeedOfActor(){
        Actor actor = new SimpleActor("Ben", 20);
        Actor actor2 = new SimpleActor("Annie", 12);
        assertEquals("Ben", actor.getName());
        assertEquals(20, actor.getSpeed());

        assertEquals("Annie", actor2.getName());
        assertEquals(12, actor2.getSpeed());
    }

    @Test
    public void simpleActorsCanEqualThemselves() {
        Actor actor = new SimpleActor("Ben", 20);
        Actor actor2 = new SimpleActor("Ben", 20);
        assertEquals(actor, actor2);
    }
}
