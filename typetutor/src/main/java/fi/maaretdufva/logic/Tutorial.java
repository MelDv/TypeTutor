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

    public String letterTutorials(int level) {
        if (level == 0) {
            return "Nakuta äffää ja jiitä etusormilla.";
        }
        if (level == 1) {
            return "Nakuta keskisormilla deetä ja koota.";
        }
        if (level == 2) {
            return "Loistavaa! Nyt f, j, d ja k yhdessä.";
        }
        if (level == 3) {
            return "Harjoittele ällää ja ässää nimettömillä.";
        }
        if (level == 4) {
            return "Hyvin menee! Nyt jfkdls kaikki yhdessä.";
        }
        if (level == 5) {
            return "Otetaan pikkurilli mukaan. Harjoittele aa ja öö.";
        }
        if (level == 6) {
            return "Harjoittele vielä yhdistämään lsöajf.";
        }
        if (level == 7) {
            return "Muistatko kaikki keskirivin näppäimet? Harjoittele jfkdlsöa.";
        }
        if (level == 8) {
            return "Edistyt erinomaisesti! Siirrytään yläriville. "
                    + "Kirjoita kirjaimia är ja uu etusormilla.";
        }
        return "";
        //To be continued
    }
}
