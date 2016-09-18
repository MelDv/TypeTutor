/*
 * This is the main class for users.
 */
package fi.maaretdufva.users;

import java.util.Scanner;

/**
 *
 * @author Maaret Dufva
 */
public class User {

    // TÄMÄ ON LÄHES VALMIS LUOKKA. TARKASTA KAIKKI!
    private int level;
    private String kayttajanimi;
    private String etunimi;
    private String sukunimi;
    private String email;
    private String salasana;
    private String opitutKirjaimet;

    public User(String kayttajanimi) {
        this.kayttajanimi = kayttajanimi;
        this.level = 0;
        this.etunimi = "";
        this.sukunimi = "";
        this.email = "";
        this.salasana = "1234";
        this.opitutKirjaimet = "";
        testaaKayttajanimi(kayttajanimi);
    }

    public void setAll(String etunimi, String sukunimi, String email, String salasana) {
        // Ei tarvita konstruktoria, joka asettaisi kaikki, koska aina asetetaan
        // ensin käyttäjänimi.
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.email = email;
        this.salasana = salasana;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    public void setOpitutKirjaimet(String opitutKirjaimet) {
        this.opitutKirjaimet = opitutKirjaimet;
    }

    public int getLevel() {
        return this.level;
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

    public String getOpitutKirjaimet() {
        return opitutKirjaimet;
    }

    public boolean testaaSalasana(String testattava) {
        if (this.salasana.equals(testattava)) {
            return true;
        }
        return false;
    }

    public boolean testaaNull(String syote) {
        if (syote == null) {
            return true;
        }
        return false;
    }

    private boolean testaaKayttajanimi(String kayttajanimi) {
        if (kayttajanimi.equals("lopeta") || kayttajanimi.equals("jatka")) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.kayttajanimi + ": " + this.etunimi + " "
                + this.sukunimi + ", taso: " + this.level + "\n sähköposti: " + this.email;
    }
}
