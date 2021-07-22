package BusinessLogicLayer.WardModule;

import BusinessLogicLayer.BeanClasses.Ward;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WardTest {

  @Test
  void getWardIdTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    assertEquals(1, ward.getWardId(), "Ward Id is not matching");
  }

  @Test
  void setWardIdTest() {
    Ward ward = new Ward();
    ward.setWardId(1);
    assertEquals(1, ward.getWardId(), "Ward Id is not matching");
  }

  @Test
  void getWardNameTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    assertEquals("WARD A", ward.getWardName(), "Ward Name is not matching");
  }

  @Test
  void setWardNameTest() {
    Ward ward = new Ward();
    ward.setWardName("WARD A");
    assertEquals("WARD A", ward.getWardName(), "Ward Name is not matching");
  }

  @Test
  void getWardTypeTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    assertEquals("COVID", ward.getWardType(), "Ward Type is not matching");
  }

  @Test
  void setWardTypeTest() {
    Ward ward = new Ward();
    ward.setWardType("COVID");
    assertEquals("COVID", ward.getWardType(), "Ward Type is not matching");
  }

  @Test
  void getWardLocationTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    assertEquals("C Wing", ward.getLocation(), "Ward Location is not matching");
  }

  @Test
  void setWardLocationTest() {
    Ward ward = new Ward();
    ward.setLocation("C Wing");
    assertEquals("C Wing", ward.getLocation(), "Ward Location is not matching");
  }

  @Test
  void getTotalBedsTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    assertEquals(100, ward.getTotalBeds(), "Total Beds in ward is not matching");
  }

  @Test
  void setTotalBedsTest() {
    Ward ward = new Ward();
    ward.setTotalBeds(100);
    assertEquals(100, ward.getTotalBeds(), "Total Beds in ward is not matching");
  }

  @Test
  void getBedTypeTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    assertEquals("General", ward.getBedType(), "Bed Type in ward is not matching");
  }

  @Test
  void setBedTypeTest() {
    Ward ward = new Ward();
    ward.setBedType("General");
    assertEquals("General", ward.getBedType(), "Bed Type in ward is not matching");
  }
}
