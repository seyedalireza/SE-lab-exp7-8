package ir.sharif.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "USER")
public class UserEntity {

    @Id
    private String username;
    private String passwordHash;
    private String name;
    private String nationalCode;

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public UserEntity setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public UserEntity setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity that = (UserEntity) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}