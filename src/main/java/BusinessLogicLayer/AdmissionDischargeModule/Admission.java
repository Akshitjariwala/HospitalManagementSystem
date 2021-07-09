package BusinessLogicLayer.AdmissionDischargeModule;

public class Admission {

    private String patientID;
    private int admissionType;
    private int wardID;
    private int bedID;
    private int doctorID;
    private int diseaseID;

    public Admission(){};

    public Admission(String patientID,int admissionType,int wardID,int bedID,int doctorID,int diseaseID){
        this.patientID = patientID;
        this.admissionType = admissionType;
        this.wardID = wardID;
        this.bedID = bedID;
        this.doctorID = doctorID;
        this.diseaseID = diseaseID;
    }

    public String getPatientID() {
        return this.patientID;
    }
    public void setPatientID(String patientID){
        this.patientID = patientID;
    }

    public int getAdmissionType() {
        return this.admissionType;
    }
    public void setAdmissionType(int admissionType){
        this.admissionType = admissionType;
    }

    public int getWardID() {
        return this.wardID;
    }
    public void setWardID(int wardID){
        this.wardID = wardID;
    }

    public int getBedID() {
        return this.bedID;
    }
    public void setBedID(int bedID){
        this.bedID = bedID;
    }

    public int getDoctorID() {
        return this.doctorID;
    }
    public void setDoctorID(int doctorID){
        this.doctorID =doctorID;
    }

    public int getDiseaseID() {
        return this.diseaseID;
    }
    public void setDiseaseID(int diseaseID){
        this.diseaseID =diseaseID;
    }

}
