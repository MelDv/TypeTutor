/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.maaretdufva.logiikka;

import fi.maaretdufva.users.User;

/**
 *
 * @author md
 */
public class Game {
    private String opitutKirjaimet;
    private String opittavatKirjaimet;
    private User user;
    
    public Game() {
        this.opittavatKirjaimet="abcdefghijklmnopqrstuvwxyzåäö";
        this.opitutKirjaimet="";
        this.user = new User();
    }
    
    public void setLevel() {
        if (user.getLevel() < 1){
            OnBoarding.start();
        }
    }
    
    
    
}
