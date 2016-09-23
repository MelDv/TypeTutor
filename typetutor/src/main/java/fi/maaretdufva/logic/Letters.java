/*
 * Tämä luokka luo satunnaiset kirjainyhdistelmät kirjainten harjoitteluun.
 */
package fi.maaretdufva.logic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author md
 */
public class Letters implements Text {

    private String kirjaimet;
    private Map<Integer, String> toisto;

    public Letters() {
        this.kirjaimet = "";
        this.toisto = new HashMap<>();
    }

    public String uusiKirjainyhdistelma() {
        String txt = "";

        return txt;
    }

    @Override
    public void setRepetition() {
    }

    @Override
    public int getRepetition() {
        return 0;
    }

}
