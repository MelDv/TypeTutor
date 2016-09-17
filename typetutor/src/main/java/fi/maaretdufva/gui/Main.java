/*
 *  This is the main class of TypeTutor
 */
package fi.maaretdufva.gui;

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
        User user = new User();
        System.out.println("Tervetuloa kirjoittamaan! Oletko jo rekisteröitynyt?");
        String teksti = lukija.nextLine();

    }



}
