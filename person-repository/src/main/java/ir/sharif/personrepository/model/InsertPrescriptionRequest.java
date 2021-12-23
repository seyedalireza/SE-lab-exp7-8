package ir.sharif.personrepository.model;

public class InsertPrescriptionRequest {

    private String patientUsername;
    private String medicines;
    private String comment;

    public String getPatientUsername() {
        return patientUsername;
    }

    public InsertPrescriptionRequest setPatientUsername(String patientUsername) {
        this.patientUsername = patientUsername;
        return this;
    }

    public String getMedicines() {
        return medicines;
    }

    public InsertPrescriptionRequest setMedicines(String medicines) {
        this.medicines = medicines;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public InsertPrescriptionRequest setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
