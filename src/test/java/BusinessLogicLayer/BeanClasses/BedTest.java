package BusinessLogicLayer.BeanClasses;

import BusinessLogicLayer.BeanClasses.Bed;
import BusinessLogicLayer.BeanClasses.Ward;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BedTest {

  @Test
  void getBedCodeTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed = new Bed(1, "10000-1", ward, true, "General");
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
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed = new Bed(1, "10000-1", ward, true, "General");
    assertEquals(ward, bed.getWard(), "Ward is not matching");
  }

  @Test
  void setWardIdTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed = new Bed();
    bed.setWard(ward);
    assertEquals(ward, bed.getWard(), "Ward is not matching");
  }

  @Test
  void getOccupiedTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed = new Bed(1, "10000-1", ward, true, "General");
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
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed = new Bed(1, "10000-1", ward, true, "General");
    assertEquals("General", bed.getBedType(), "Bed Type is not matching");
  }

  @Test
  void setBedTypeTest() {
    Bed bed = new Bed();
    bed.setBedType("General");
    assertEquals("General", bed.getBedType(), "Bed Type is not matching");
  }
}
