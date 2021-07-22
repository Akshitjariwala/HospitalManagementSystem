package DatabaseLayer.ActionDatabase.Admin;

import BusinessLogicLayer.BeanClasses.Bed;
import BusinessLogicLayer.BeanClasses.BedCounts;
import BusinessLogicLayer.BeanClasses.PatientBed;
import BusinessLogicLayer.BeanClasses.Ward;

import java.util.ArrayList;

public interface IManageWardDatabase {

	Ward getWard(int wardId);

	Bed getBed(int bedId);

	ArrayList<Ward> getWardsList();

	ArrayList<Bed> getWardBeds(int wardId);

	ArrayList<PatientBed> getPatientBed(int wardId);

	ArrayList<BedCounts> showCurrentAvailableBeds();

}
