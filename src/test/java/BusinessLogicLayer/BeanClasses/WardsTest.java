package BusinessLogicLayer.BeanClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WardsTest {

    @Test
    void getWardId() {
        Wards ward = new Wards();
        int id =1;
        ward.setWardId(id);
        assertEquals(1,ward.getWardId(),"The id doesnt match ");

    }

    @Test
    void setWardId() {
        Wards ward = new Wards();
        int id =1;
        ward.setWardId(id);
        assertEquals(1,ward.getWardId(),"The id doesnt match ");
    }

    @Test
    void getWardName() {
        Wards ward = new Wards();
        ward.setWardName("General");
        assertEquals("General",ward.getWardName(),"The ward name doesnt match ");
    }

    @Test
    void setWardName() {
        Wards ward = new Wards();
        ward.setWardName("ICU");
        assertEquals("ICU",ward.getWardName(),"The ward name doesnt match ");
    }

    @Test
    void getLocation() {
        Wards ward = new Wards();
        ward.setLocation("1st Floor");
        assertEquals("1st Floor",ward.getLocation(),"The location name doesnt match ");
    }

    @Test
    void setLocation() {
        Wards ward = new Wards();
        ward.setLocation("2nd Floor");
        assertEquals("2nd Floor",ward.getLocation(),"The location name doesnt match ");
    }

    @Test
    void getBedType() {
        Wards ward = new Wards();
        ward.setBedType("ICU");
        assertEquals("ICU",ward.getBedType(),"The bed type name doesnt match ");
    }

    @Test
    void setBedType() {
        Wards ward = new Wards();
        ward.setBedType("Oxygen");
        assertEquals("Oxygen",ward.getBedType(),"The bed type name doesnt match ");
    }

    @Test
    void getTotalBeds() {
        Wards ward = new Wards();
        ward.setTotalBeds(20);
        assertEquals(20,ward.getTotalBeds(),"The bed total name doesnt match ");
    }

    @Test
    void setTotalBeds() {
        Wards ward = new Wards();
        ward.setTotalBeds(20);
        assertEquals(20,ward.getTotalBeds(),"The bed total name doesnt match ");
    }

    @Test
    void getWardType() {
        Wards ward = new Wards();
        ward.setWardType("Children Ward");
        assertEquals("Children Ward",ward.getWardType(),"The ward type doesnt match ");
    }

    @Test
    void setWardType() {
        Wards ward = new Wards();
        ward.setWardType("Covid Ward");
        assertEquals("Covid Ward",ward.getWardType(),"The ward type doesnt match ");
    }

}