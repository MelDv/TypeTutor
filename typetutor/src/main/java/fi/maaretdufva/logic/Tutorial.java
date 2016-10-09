package fi.maaretdufva.logic;

/**
 * The typing guides are in this class.
 * <p>
 * When the user reaches the next level, the information text on the window is
 * retrieved from this class. It will aslo contain other instructions and visual
 * guides.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class Tutorial {
    //guidance texts and pics coming soonish

    /**
     * Constructor.
     */
    public Tutorial() {
    }

    /**
     * Guide for placing your hands on the keyboard.
     */
    public void handPosture() {
        System.out.println("Käet näppäimistölle");
    }

    /**
     * Guides for typing each letter.
     *
     * @param level Game class calls for this method and provides level
     * information.
     * @return instructions for typing efficiently based on level.
     */
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
