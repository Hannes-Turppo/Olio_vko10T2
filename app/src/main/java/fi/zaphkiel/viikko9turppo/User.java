package fi.zaphkiel.viikko9turppo;

import java.io.Serializable;

public class User implements Serializable {

    public String firstName;
    public String lastName;
    public String eMail;
    public String degreeProgram;

    public User() {
        firstName = null;
        lastName = null;
        eMail = null;
        degreeProgram = null;
    }

    public User(String firstName, String lastName, String eMail, String degreeProgram) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.degreeProgram = degreeProgram;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }
}
