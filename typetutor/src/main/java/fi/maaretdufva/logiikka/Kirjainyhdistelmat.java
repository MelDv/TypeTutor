/*
 * Tämä luokka luo satunnaiset kirjainyhdistelmät kirjainten harjoitteluun.
 */
package fi.maaretdufva.logiikka;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author md
 */
public class Kirjainyhdistelmat implements Teksti {

    private String kirjaimet;
    private Map<Integer, String> toisto;

    public Kirjainyhdistelmat() {
        this.kirjaimet = "";
        this.toisto = new HashMap<>();
    }

    public String uusiKirjainyhdistelma() {
        String txt = "";

        return txt;
    }

    @Override
    public void setToisto() {
    }

    @Override
    public int getToisto() {
        return 0;
    }

}
