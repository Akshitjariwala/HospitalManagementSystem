package DatabaseLayer.ActionDatabase.Admin;

import BusinessLogicLayer.BeanClasses.Bed;
import BusinessLogicLayer.BeanClasses.BedCounts;
import BusinessLogicLayer.BeanClasses.PatientBed;
import BusinessLogicLayer.BeanClasses.Ward;

import java.util.ArrayList;
import java.util.List;

public interface IManageWardDatabase {

  Ward getWard(int wardId);

  Bed getBed(int bedId);

  List<Ward> getWardsList();

  List<Bed> getWardBeds(int wardId);

  List<PatientBed> getPatientBed(int wardId);

  List<BedCounts> showCurrentAvailableBeds();

}
