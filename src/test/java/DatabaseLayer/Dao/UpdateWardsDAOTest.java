package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Ward;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateWardsDAOTest {

  @Test
  void updateWard() {

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