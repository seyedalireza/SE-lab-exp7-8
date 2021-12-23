package ir.sharif.entity.dto;

public class Patient {

    private String username;
    private String name;
    private String nationalCode;
    private String password;

    public String getUsername() {
        return username;
    }

    public Patient setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public Patient setName(String name) {
        this.name = name;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public Patient setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Patient setPassword(String password) {
        this.password = password;
        return this;
    }
}
