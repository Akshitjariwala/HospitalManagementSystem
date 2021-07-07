package BusinessLogicLayer.WardModule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BedTest {

  @Test
  void getBedCodeTest() {
    Bed bed = new Bed("10000-1", 1, true, "General");
    assertEquals("10000-1", bed.getBedCode(), "Bed Code is not matching");
  }

  @Test
  void setBedCodeTest() {
    Bed bed = new Bed();
    bed.setBedCode("10000-1");
    assertEquals("10000-1", bed.getBedCode(), "Bed Code is not matching");
  }

  @Test
  void getWardIdTest() {
    Bed bed = new Bed("10000-1", 1, true, "General");
    assertEquals(1, bed.getWardId(), "Ward is not matching");
  }

  @Test
  void setWardIdTest() {
    Bed bed = new Bed();
    bed.setWardId(1);
    assertEquals(1, bed.getWardId(), "Ward is not matching");
  }

  @Test
  void getOccupiedTest() {
    Bed bed = new Bed("10000-1", 1, true, "General");
    assertTrue(bed.getOccupied(), "IsOccupied not matching");
  }

  @Test
  void setOccupiedTest() {
    Bed bed = new Bed();
    bed.setOccupied(true);
    assertTrue(bed.getOccupied(), "IsOccupied not matching");
  }

  @Test
  void getBedTypeTest() {
    Bed bed = new Bed("10000-1", 1, true, "General");
    assertEquals("General", bed.getBedType(), "Bed Type is not matching");
  }

  @Test
  void setBedTypeTest() {
    Bed bed = new Bed();
    bed.setBedCode("General");
    assertEquals("General", bed.getBedType(), "Bed Type is not matching");
  }
}
