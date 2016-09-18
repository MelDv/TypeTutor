/*
 * This is the main class for users.
 */
package fi.maaretdufva.users;

/**
 *
 * @author Maaret Dufva
 */
public class User {

    private int level;
    private AllUsers kaikki;
    private String kayttajanimi;
    private String etunimi;
    private String sukunimi;
    private String email;

    public User() {
        this.level = 0;
        this.kaikki = new AllUsers();
        this.kayttajanimi = "";
        this.etunimi = "";
        this.sukunimi = "";
        this.email = "";
    }

    public int getLevel() {
        return this.level;
    }

    public boolean etsiKayttajanimi(String kayttis) {
        if (this.kayttajanimi.equals(kayttis)) {
            return true;
        }
        return false;
    }

    public String getKayttajanimi() {
        return this.kayttajanimi;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public String getEmail() {
        return email;
    }

}
