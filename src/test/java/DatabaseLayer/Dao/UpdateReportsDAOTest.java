package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Wards;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateReportsDAOTest {

    @Test
    void updateReport() {
        Wards ward = new Wards();

        ward.setWardId(11);
        ward.setWardType("General");
        ward.setWardName("General");
        ward.setLocation("Wing B");
        ward.setTotalBeds(25);
        ward.setBedType("ICU");

        assertEquals(11 + " "+"General"+" "+"General"+" "+ "Wing B"+ " "+ 25 +" "+ "ICU",
                ward.getWardId() +" "+ ward.getWardType() +" "+ ward.getWardName() +" "+
                        ward.getLocation() +" "+ ward.getTotalBeds() +" "+
                        ward.getBedType(), "The values are not valid");
    }
}