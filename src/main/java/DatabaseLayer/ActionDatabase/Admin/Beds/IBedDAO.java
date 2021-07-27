package DatabaseLayer.ActionDatabase.Admin.Beds;

import BusinessLogicLayer.BeanClasses.Bed;
import BusinessLogicLayer.BeanClasses.BedCounts;
import BusinessLogicLayer.BeanClasses.PatientBed;

import java.util.List;

public interface IBedDAO {

  Bed getBed(int bedId);

  List<Bed> getWardBeds(int wardId);

  List<PatientBed> getPatientBed(int wardId);

  List<BedCounts> showCurrentAvailableBeds();
}
