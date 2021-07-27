package BusinessLogicLayer.AdmissionDischargeModule;

public interface IAdmissionForm {
  void newAdmissionForm();

  String displayPatientName();

  String displayAdmissionType();

  String displayDiagnose();

  String displayDoctor();

  String displayWard();

  String displayBed();

  void updateAdmissionForm();
}
