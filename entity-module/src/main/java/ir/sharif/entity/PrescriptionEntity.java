package ir.sharif.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "PRESCRIPTION")
public class PrescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private DoctorEntity doctorEntity;

    @ManyToOne(optional = false)
    private PatientEntity patientEntity;

    private String medicines;
    private String comment;


    public Long getId() {
        return id;
    }

    public PrescriptionEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public DoctorEntity getDoctorEntity() {
        return doctorEntity;
    }

    public PrescriptionEntity setDoctorEntity(DoctorEntity doctorEntity) {
        this.doctorEntity = doctorEntity;
        return this;
    }

    public PatientEntity getPatientEntity() {
        return patientEntity;
    }

    public PrescriptionEntity setPatientEntity(PatientEntity patientEntity) {
        this.patientEntity = patientEntity;
        return this;
    }

    public String getMedicines() {
        return medicines;
    }

    public PrescriptionEntity setMedicines(String medicines) {
        this.medicines = medicines;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public PrescriptionEntity setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
