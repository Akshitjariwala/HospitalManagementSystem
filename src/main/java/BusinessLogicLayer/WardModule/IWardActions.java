package BusinessLogicLayer.WardModule;

public interface IWardActions {

  void addWards();

  void updateWards();

  void checkBedAvailability();

  void checkPatientWiseBedDetails();

  int getSelectedWard();
}
