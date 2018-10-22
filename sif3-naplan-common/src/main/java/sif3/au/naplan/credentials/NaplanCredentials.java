package sif3.au.naplan.credentials;

import java.io.Serializable;

public class NaplanCredentials implements Serializable {
    private static final long serialVersionUID = 7484696421521232227L;

    private String applicationKey;
    private String password;

    public NaplanCredentials() {

    }

    public NaplanCredentials(String applicationKey, String password) {
        this.applicationKey = applicationKey;
        this.password = password;
    }

    public String getApplicationKey() {
        return applicationKey;
    }

    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
