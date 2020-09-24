import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnManagerTests {
    @Test
    public void canCreateManager(){
        TurnManager manager = new TurnManager();
    }

    @Test
    public void canReturnCorrectNameAndSpeedOfActor(){
        SimpleActor actor = new SimpleActor("Ben", 20);
        assertEquals("Ben", actor.getName());
        assertEquals(20, actor.geSpeed());
    }


}
