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

    private User user;
    private Map<String, User> all;

    public AllUsers(User lisattava) {
        this.user = new User();
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

    public User findUser(String kayttajanimi) {
        if (this.all.containsKey(kayttajanimi)) {
            return this.all.get(kayttajanimi);
        }

        return null;
    }

    public void paivitaKayttaja(String vanhaKayttajatunnus, User kayttaja) {
        if (!this.all.containsKey(vanhaKayttajatunnus)) {
            addKayttaja(kayttaja);
        }
        this.all.remove(vanhaKayttajatunnus);
        this.all.put(kayttaja.getKayttajanimi(), kayttaja);
    }

}
