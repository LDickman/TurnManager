import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnManagerTests {
    @Test
    public void canCreateManager(){
        TurnManager manager = new TurnManager();
    }

    @Test
    public void simpleActor(){
        String expectedName = "Aarron";
        int expectedSpeed = 20;
        assertEquals(expectedName, Actor.getName());
        assertEquals(expectedSpeed, Actor.geSpeed());
    }

}
