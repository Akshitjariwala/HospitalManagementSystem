package BusinessLogicLayer.AdmissionDischargeModule;

public class Admission {

    private String patientID;
    private int admissionType;
    private int wardID;
    private int bedID;
    private String doctorID;
    private String diseaseID;

    public Admission(String patientID,int admissionType,int wardID,int bedID,String doctorID,String diseaseID){
        this.patientID = patientID;
        this.admissionType = admissionType;
        this.wardID = wardID;
        this.bedID = bedID;
        this.doctorID = doctorID;
        this.diseaseID = diseaseID;
    }

    // returns the value of patientID.
    public String getPatientID() {
        return "id";
    }

    // set the value for the patientID.
    public void setPatientID(String patientID){
    }

    // returns the value of admissionType.
    public int getAdmissionType() {
        return 0;
    }

    // set the value for the admissionType.
    public void setAdmissionType(int admissionType){
    }

    // returns the value of wardID.
    public int getWardID() {
        return 0;
    }

    // set the value for the wardID.
    public void setWardID(int wardID){
    }

    // returns the value of bedID.
    public int getBedID() {
        return 0;
    }

    // set the value for the bedID.
    public void setBedID(int bedID){
    }

    // returns the value of doctorID.
    public String getDoctorID() {
        return "id";
    }

    // set the value for the doctorID.
    public void setDoctorID(String doctorID){
    }

    // returns the value of diseaseID.
    public String getDiseaseID() {
        return "id";
    }

    // set the value for the diseaseID.
    public void setDiseaseID(String diseaseID){
    }

}
