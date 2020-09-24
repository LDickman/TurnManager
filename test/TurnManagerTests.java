import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnManagerTests {
    @Test
    public void canCreateManager(){
        TurnManager manager = new TurnManager();
    }

    @Test
    public void canCreateSimpleActor(){
        SimpleActor actor = new SimpleActor();
//        String expectedName = "Ben";
//        int expectedSpeed = 15;
//        assertEquals(expectedName, Actor.getName());
//        assertEquals(expectedSpeed, Actor.geSpeed());
    }

}
