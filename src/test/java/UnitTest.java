import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

@Test
public void place_instantiatesCorrectly_true() {
  Place testPlace = new Place("Portland");
  assertEquals(true, testPlace instanceof Place);
}

@Test
public void place_setsPlaceName() {
  Place testPlace = new Place("Portland");
  assertEquals("Portland", testPlace.getPlace());
}


}
