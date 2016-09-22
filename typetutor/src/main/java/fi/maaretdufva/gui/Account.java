/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.maaretdufva.gui;

import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.AllUsers;
import fi.maaretdufva.users.User;
import java.util.Scanner;

/**
 *
 * @author Maaret
 */
public class Account {
    
    // TÄMÄ ON KESKENERÄINEN LUOKKA! TARKISTA KAIKKI METODIT!

    private Scanner lukija;
    private User user;
    private AllUsers kaikki;

    public Account() {
        this.lukija = new Scanner(System.in);
        this.user = new User("Jaska"); //poista Jaska, kun testaus valmis
        this.kaikki = new AllUsers();
    }

    public User aloita() {
        while (true) {
            System.out.println("Voit tutustua ohjelmaan komennolla 'jatka' "
                    + "tai kirjautua kirjoittamalla käyttäjätunnuksesi.\n"
                    + "Jos haluat luoda käyttäjätilin, paina enter");
            String teksti = lukija.nextLine();

            if (teksti.equals("jatka")) {
                return user;
            } else if (teksti.isEmpty()) {
                luoTunnus();
                break;
            } else if (kaikki.findUser(teksti)) {
                System.out.println("Tervetuloa takaisin, " + teksti);
                tarkastaSalasana();
                break;
            } // lisää kohta jossa käyttäjää ei löydy

        }
        return user;

    }

    public void luoTunnus() {
        while (true) {
            System.out.println("Anna käyttäjätunnus.");
            String tunnus = lukija.nextLine();
            if (kaikki.findUser(tunnus)) {
                System.out.println("Tunnus on jo käytössä.");
            } else {
                user.setKayttajanimi(tunnus);
                System.out.println("Tervetuloa käyttäjäksi, " + tunnus + "!");
                break;
            }
        }
        annaTiedot();
    }

    public void tarkastaSalasana() {
        System.out.println("Kirjoita salasana: ");
        String salasana = lukija.nextLine();
        if (user.testaaSalasana(salasana)) {
            return;
        } else {
            System.out.println("Kirjoitit väärän salasanan. Kirjoita salasana uudelleen"
                    + "tai palaa alkuun painamalla enter.");
        }
    }

    public void promptLuoTili() {
        System.out.println("Voit jatkaa harjoittelua luomalla käyttäjätunnuksen "
                + "tai kirjautumalla käyttäjätilillesi. Kirjoita käyttäjänimi"
                + "tai lopeta painamalla enter.");
        String vastaus = lukija.nextLine();
        if (vastaus.isEmpty()) {
            System.out.println("Jos haluat harjoitella uudelleen, paina K, muuten enter.");
            String uusiVastaus = lukija.nextLine();
            if (uusiVastaus.isEmpty()) {
                System.out.println("Tervetuloa uudelleen!");
                return;
            }
        }
    }

    public boolean tyhjaSyote(String syote) {
        if (syote.isEmpty()) {
            return true;
        }
        return false;
    }

    private void luoSalasana() {
        // EI VALMIS!
        //this.kaikki.addKayttaja(user);
    }

    private void annaTiedot() {
        // EI VALMIS!!
        //luoSalasana();
    }
}
