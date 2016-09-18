/*
 *  This is the main class of TypeTutor
 */
package fi.maaretdufva.gui;

import fi.maaretdufva.logiikka.OnBoarding;
import fi.maaretdufva.users.User;
import static java.lang.System.in;
import java.util.Scanner;

/**
 *
 * @author Maaret Dufva
 */
public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        User user = new User("Jaska"); //poista Jaska, kun testaus valmis
        System.out.println("Tervetuloa kirjoittamaan! "
                + "Voit tutustua ohjelmaan komennolla 'jatka' "
                + "tai kirjautua/rekisteröityä kirjoittamalla käyttäjätunnuksesi.");
        String teksti = lukija.nextLine();

        if (teksti.equals("jatka")) {
            OnBoarding.start();
        }
        if (user.etsiKayttajanimi(teksti) == true) {
            System.out.println("Tervetuloa takaisin, " + teksti);
        }
        
        // lisää uudet käyttäjät myös AllUsers-listaan!
    }

}
