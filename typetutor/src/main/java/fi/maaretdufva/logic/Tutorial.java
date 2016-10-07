/*
 * The typing guides are in this class.
 */
package fi.maaretdufva.logic;

/**
 *
 * @author Maaret
 */
public class Tutorial {
    //guidance texts and pics coming soonish

    public Tutorial() {
    }

    public void handPosture() {
        System.out.println("Käet näppäimistölle");
    }

    public void letterTutorials(int level) {
        if (level == 0) {
            System.out.println("Nakuta äffää ja jiitä etusormilla.");
        }
        if (level == 1) {
            System.out.println("Nakuta keskisormilla deetä ja koota.");
        }
        if (level == 2) {
            System.out.println("Loistavaa! Nyt f, j, d ja k yhdessä.");
        }
        if (level == 3) {
            System.out.println("Harjoittele ällää ja ässää nimettömillä.");
        }
        if (level == 4) {
            System.out.println("Hyvin menee! Nyt jfkdls kaikki yhdessä.");
        }
        if (level == 5) {
            System.out.println("Otetaan pikkurilli mukaan. Harjoittele aa ja öö.");
        }
        if (level == 6) {
            System.out.println("Harjoittele vielä yhdistämään lsöajf.");
        }
        if (level == 7) {
            System.out.println("Muistatko kaikki keskirivin näppäimet? Harjoittele jfkdlsöa.");
        }
        if (level == 8) {
            System.out.println("Edistyt erinomaisesti! Siirrytään yläriville. "
                    + "Kirjoita kirjaimia är ja uu etusormilla.");
        }
        //To be continued
    }
}
