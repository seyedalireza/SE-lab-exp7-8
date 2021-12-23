package ir.sharif.entity.dto;

public class Doctor {

    private String username;
    private String name;
    private String nationalCode;
    private String password;

    public String getUsername() {
        return username;
    }

    public Doctor setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public Doctor setName(String name) {
        this.name = name;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public Doctor setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Doctor setPassword(String password) {
        this.password = password;
        return this;
    }
}
