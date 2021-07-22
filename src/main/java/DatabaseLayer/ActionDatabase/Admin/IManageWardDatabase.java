package DatabaseLayer.ActionDatabase.Admin;

import BusinessLogicLayer.WardModule.Bed;
import BusinessLogicLayer.WardModule.BedCounts;
import BusinessLogicLayer.WardModule.PatientBed;
import BusinessLogicLayer.WardModule.Ward;

import java.util.ArrayList;

public interface IManageWardDatabase {

	Ward getWard(int wardId);

	Bed getBed(int bedId);

	ArrayList<Ward> getWardsList();

	ArrayList<Bed> getWardBeds(int wardId);

	ArrayList<PatientBed> getPatientBed(int wardId);

	ArrayList<BedCounts> showCurrentAvailableBeds();

}
