# PALaboratorul11
UAIC_FII_PA_LAB_11



## Compulsory {
* pe moment nu s-a realizat conectarea la baze de date, va fi facuta in viitor
* Create a Spring Boot project containing the REST services for comunicating with the database.
    * Aceasta a fost creata prin folosirea : https://start.spring.io
    * a fost selectat maven, Java, si SpringBoot 2.2.6
    * s-a descarcat proiectul generat
    * s-au scos toate celelate programe care foloseau portul 8080
    * s-a modificat in pom.xml, adaugandu-se un **-web** la linia de mai jos:
        * 			<artifactId>spring-boot-starter-web</artifactId>
    * s-a rulat si s-a observat ca merge
* Create the classes Game and Player.
    * aceste clase exista in pachetul *Game*
    * nu contin decat getteri, setteri, constructori si metode ajutatoare pentru adaugarea unui element intr-o lista, stergerea unui element dintr-o lista si gasirea unui element dintr-o lista

* Create a REST controller containing methods for:
    * obtaining the list of the players, via a HTTP GET request.
        * s-a creat o clasa : **GameController**
        * aceasta clasa se ocupa cu maparea tuturor requesturilor referitoare la joc
        * calea specifica clasei este **/game**
        * pentru requesturile de tip get, exista 3 cai construite
        * calea **/players** (apendata evident la **/game**)
        * aceasta cale intoarce toti playerii, ceea ce se cere in cerinta, astfel:
        ```$xslt
        @GetMapping("/players")
            public List<Player> getProducts() {
                return game.getPlayerList();
            }
        ```
        * celelalte cai nu sunt necesare
    * adding a new player in the database, via a HTTP POST request.
        * http://localhost:8080/game?name=Player3 (Postman Post)
        * sau deschiderea unui fisier . html care contine urmatoarele:
        ```$xslt
        <html> <body>
         <form action="http://localhost:8080/game" method="POST">
         Player: <input type="text" name="name"/> <br/>
         <input type="submit" value="Submit"/>
         </form>
        </bodY> </html>
        ```
        * se adauga un player nou, codul de la post este similar cu cel din curs, slide-urile 18
    * modifying the name of a player, via a HTTP PUT request.
        * http://localhost:8080/game/1?name=Player100 (Postman put)
        * similar cu slide-urile 19 din curs, se cauta un player cu id-ul din ruta /game/{id}
        * se vede daca exista, si se intoarce un mesaj si se face modificarea daca este posibil
    * deleting a player, via a HTTP DELETE request.
        * http://localhost:8080/game/1 (Postman delete)
        * se cauta un player si daca exista este scos
* Test your services using the browser and/or Postman.
    * dupa cum se observa sunt puse requesturile prin POSTMAN
    * prin browser se poate testa GET si POST daca se folosesc formulare

## }

