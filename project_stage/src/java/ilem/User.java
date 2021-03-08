package ilem;
public class User {
    
    private long ID_USER;
    private String NOM;
    private String PRENOM;
    private String USERNAME;
    private String PASSWORD;
    private String typerole;

    public User() {
    }

    public User(String NOM, String PRENOM, String USERNAME, String PASSWORD, String typerole) {
        this.NOM = NOM;
        this.PRENOM = PRENOM;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.typerole = typerole;
    }
    
    public User(long ID_USER, String NOM, String PRENOM, String USERNAME, String PASSWORD, String typerole) {
        this.ID_USER = ID_USER;
        this.NOM = NOM;
        this.PRENOM = PRENOM;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.typerole = typerole;
    }

    public long getID_USER() {
        return ID_USER;
    }

    public void setID_USER(long ID_USER) {
        this.ID_USER = ID_USER;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String gettyperole() {
        return typerole;
    }

    public void settyperole(String typerole) {
        this.typerole = typerole;
    }

}
