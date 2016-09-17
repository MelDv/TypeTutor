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
        this.kirjaimet="";
        this.toisto=new HashMap<>();       
    }
    
    public String uusiKirjainyhdistelma() {
        String txt="";
        
        
        
        return txt;
    }
    

    @Override
    public Map setToisto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getToisto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
