package ir.sharif.admin;

public class Status {
    private long numberOfUsers;
    private long numberOfDoctors;
    private long numberOfPatients;
    private long numberOfPrescriptions;

    public long getNumberOfUsers() {
        return numberOfUsers;
    }

    public Status setNumberOfUsers(long numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
        return this;
    }

    public long getNumberOfDoctors() {
        return numberOfDoctors;
    }

    public Status setNumberOfDoctors(long numberOfDoctors) {
        this.numberOfDoctors = numberOfDoctors;
        return this;
    }

    public long getNumberOfPatients() {
        return numberOfPatients;
    }

    public Status setNumberOfPatients(long numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
        return this;
    }

    public long getNumberOfPrescriptions() {
        return numberOfPrescriptions;
    }

    public Status setNumberOfPrescriptions(long numberOfPrescriptions) {
        this.numberOfPrescriptions = numberOfPrescriptions;
        return this;
    }
}
