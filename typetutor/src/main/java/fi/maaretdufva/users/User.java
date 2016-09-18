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

    public User(String kayttajanimi) {
        this.level = 0;
        this.kaikki = new AllUsers();
        this.kayttajanimi = kayttajanimi;
        this.etunimi = "";
        this.sukunimi = "";
        this.email = "";
    }

    public User() {
    }
    
    public void setAll(String etunimi, String sukunimi, String email) {
        // Ei tarvita konstruktoria, joka asettaisi kaikki, koska aina asetetaan
        // ensin käyttäjänimi.
        this.etunimi=etunimi;
        this.sukunimi=sukunimi;
        this.email=email;
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

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setKayttajanimi(String kayttajanimi) {
        this.kayttajanimi = kayttajanimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
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

    @Override
    public String toString() {
        return this.kayttajanimi + ": " + this.etunimi + " "
                + this.sukunimi + " sähköposti: " + this.email;
    }
}
