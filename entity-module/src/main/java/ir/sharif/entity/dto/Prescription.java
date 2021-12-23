package ir.sharif.entity.dto;

public class Prescription {

    private Long id;
    private Doctor doctor;
    private Patient patient;
    private String medicines;
    private String comment;


    public Long getId() {
        return id;
    }

    public Prescription setId(Long id) {
        this.id = id;
        return this;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Prescription setDoctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    public Patient getPatient() {
        return patient;
    }

    public Prescription setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public String getMedicines() {
        return medicines;
    }

    public Prescription setMedicines(String medicines) {
        this.medicines = medicines;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Prescription setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
