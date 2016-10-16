# Rakennekuvaus

Kuten luokkakaaviosta näkyy, TypeTutorissa toteutetaan jakoa käyttöliittymä-, sovelluslogiikka- ja säilytyskerroksiin. 
Luokat jakautuvat näihin seuraavasti:

Käyttöliittymäkerros:
* Main
* Gui
* Listener
* RegisterListener (keskeneräinen)

Sovelluslogiikkakerros:
* Game
* Letters suurimmaksi osin
* Tutorial (keskeneräinen)

Säilytyskerros:
* User
* AllUsers
* Letters (tiedostosta haettavien sanojen osalta)

Käyttöliittymäkerroksen luokat huolehtivat käyttäjälle näkyvien osien luomisesta (Gui) ja päivittämisestä (kuuntelijat) ja ohjelman käynnistämisestä (Main).

Varsinainen toiminta tapahtuu sovelluslogiikassa, josta tärkein on Game-luokka. Se hakee tietoja Tutorial- ja Letters-luokista.

Säilytyskerrokseen talletetaan käyttäjien tiedot, jotta he voivat jatkaa siitä, mihin edellisellä kerralla pääsivät. Täältä löytyvät tulevaisuudessa myös sanalistat.