/*
 * Tämä luokka muistaa kaikki rekisteröityneet käyttäjät.
 */
package fi.maaretdufva.users;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maaret Dufva
 */
public class AllUsers {

    // TÄMÄ ON LÄHES VALMIS LUOKKA. TARKASTA KAIKKI!
    private User user;
    private Map<String, User> all;

    public AllUsers(User lisattava) {
        this.user = lisattava;
        this.all = new HashMap<>();
        this.all.put(lisattava.getKayttajanimi(), lisattava);
    }

    public AllUsers() {
    }

    public Map getUsers() {
        return this.all;
    }

    public User getUser(String kayttajanimi) {
        if (all.containsKey(kayttajanimi)) {
            return all.get(kayttajanimi);
        }
        return null;
    }

    public void addKayttaja(User lisattava) {
        this.all.put(lisattava.getKayttajanimi(), lisattava);
    }

    public boolean findUser(String kayttajanimi) {
        if (this.all == null) {
            return false;
        }
        if (this.all.containsKey(kayttajanimi)) {
            return true;
        }
        return false;
    }

    public void paivitaKayttaja(String vanhaKayttajatunnus, User kayttaja) {
        if (!this.all.containsKey(vanhaKayttajatunnus)) {
            addKayttaja(kayttaja);
        }
        this.all.remove(vanhaKayttajatunnus);
        this.all.put(kayttaja.getKayttajanimi(), kayttaja);
    }

    @Override
    public String toString() {
        StringBuilder userlist = null;

        for (int i = 0; i < all.size(); i++) {
            userlist.append("\n");
            userlist.append(user.toString());
        }
        return userlist.toString();
    }
}
