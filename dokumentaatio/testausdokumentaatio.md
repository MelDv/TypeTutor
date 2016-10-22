# Testausdokumentaatio

##Robotti

Tavallisten JUnit-testien lisäksi tein testirobotin, jolla näkee nopeasti, toimiiko TypeTutor oppimisen edetessä.
Käsin testatessa tai JUnit-testeillä ei näe tarpeeksi hyvin, miten ohjelma toimii kun opittuja kirjaimia tulee lisää, 
harjoiteltavat kirjainketjut pitenevät ja mennään tasoilla pidemmälle. Robotin takia checkstyleen jäi yksi virhe
nested blockseista, mutta se oli välttämätön robotin sujuvan toimimisen kannalta. Robottitestauksen takia 
en panostanut täyteen JUnit-kattavuuteen.

RobotTest-luokassa on ohjeet robotin käyttämiseksi. Robotin toiminta edellyttää, ettei koneella tehdä samaan aikaan muuta.

##Olemassa olevat testit

Testejä on 27 kappaletta ja monet niistä testaavat luokkansa toimintaa varsin monipuolisesti.
Keskityin testeissä varsinaisen toimintalogiikan testaamiseen. Käyttäjien luominen ja poimiminen tiedostosta on 
tässä kohtaa mielestäni toisarvoista ja pääpaino oli siinä, että opeteltiin tekemään toimivia pieniä ohjelmia.
Mielestäni onnistuin tässä ihan hyvin. Ohjelmaa voi kehittää edelleen ja siinä kohtaa myös käyttäjälistojen ylläpito on tärkeämmällä sijalla.
Tavoite oli kuitenkin luoda toimiva ohjelma kymmensormijärjestelmän opetteluun, ja sen tein.


##Puuttuvat testit

Ohjeiden mukaan en tehnyt testejä private-metodeille, gettereille tai settereille, tai käyttöliittymäluokille.
