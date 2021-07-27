package BusinessLogicLayer.WardModule;

import BusinessLogicLayer.BeanClasses.Ward;
import DatabaseLayer.ActionDatabase.Admin.Wards.IWardDAO;
import DatabaseLayer.ActionDatabase.Admin.Wards.WardDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WardDAOTest {

  private IWardDAO iWardDAO;

  @BeforeEach
  void setup() {
    iWardDAO = Mockito.mock(WardDAO.class);
  }

  @Test
  void getWardTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Mockito.when(iWardDAO.getWard(1)).thenReturn(ward);
    assertEquals(ward.getWardName(), iWardDAO.getWard(1).getWardName(), "Ward is not matching");
  }

  @Test
  void addWardTest() {
    Ward ward = new Ward();
    ward.setWardId(11);
    ward.setWardType("General");
    ward.setWardName("General");
    ward.setLocation("Wing B");
    ward.setTotalBeds(25);
    ward.setBedType("ICU");

    Mockito.when(iWardDAO.addWard(ward)).thenReturn(1);
    assertEquals(1, iWardDAO.addWard(ward), "Ward has not been added");
  }

  @Test
  void updateWardTest() {
    Ward ward = new Ward();
    ward.setWardId(13);
    ward.setWardType("Children");
    ward.setWardName("General");
    ward.setLocation("Wing B");
    ward.setTotalBeds(25);
    ward.setBedType("ICU");

    assertEquals(13 + " " + "Children" + " " + "General" + " " + "Wing B" + " " + 25 + " " + "ICU",
            ward.getWardId() + " " + ward.getWardType() + " " + ward.getWardName() + " " +
                    ward.getLocation() + " " + ward.getTotalBeds() + " " +
                    ward.getBedType(), "The values are not valid");

  }
}
