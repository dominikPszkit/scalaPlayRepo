package controllers

import play.api.db.DB
import play.api.mvc._
import play.api.Play.current

object Application extends Controller {

  var wartownik = 2

  var number =1
  var pytania = new Array[String](number);
  var ceny = new Array [Byte] (number);
  var outString = " "
  var cenyUslug  = new Array [Byte] (number);

  def index = Action {
wartownik =2;


    val conn = DB.getConnection()
    try {
      //tworzenie poloczenia
      val stmt = conn.createStatement
      //tworzenie zapytania do bazy
      val rs = stmt.executeQuery("SELECT * from dane ")
      // przygotowywanie tablic na przyjecie danych
            //obliczenie dlugosci tablicy na podstawie liczby pytan w bazie danych
      while (rs.next()){ number += 1}
            // tworzenie tablicy dla pytan i dla cen
      pytania = new Array[String](number)
      ceny = new Array[Byte](number)
            // tworzenie tablicy do przechowywania cen za wybrane uslugi
      cenyUslug = new Array [Byte] (number)
            // resetowanie ustawien
      while (rs.previous()){}
      number = 0
      //pobieranie pytan z bazy
      while (rs.next()) {
        pytania (number) = rs.getString("pytania")
        number += 1
      }
      // resetowanie ustawien
      while (rs.previous()){}
      number = 0
      //pobranie cen z bazy
      while (rs.next()) {
        ceny (number) = rs.getByte("ceny")
        println(ceny (number));

        number += 1
      }
      number = 0

      // resetowanie ustawien
      while (rs.previous()){}
      number = 0
      //wypelnienie tablicy cenyUslug zerami
      while (rs.next()) {
        cenyUslug (number) = 0
        number += 1
      }
      number = 0



    // zakonczenie  polaczenia z baza
    } finally {
      conn.close()
    }



  Ok(views.html.index(pytania(number), 5.0f))


  }


  def buttonPressed = Action {
if( number < (pytania.length-1)   ) {
      //wyswietl pytanie
     if (wartownik%2 ==0){ number += 1 }
      outString = pytania(number)
    wartownik += 1
}else{

  // oblicz i wyswietl kwote
  var index = 0
  var wynik = 0
  while(index < cenyUslug.length ){
    wynik += cenyUslug(index)
    index += 1


  }
 outString = wynik.toString
  //by stale wyswietlalo cene

}
    println(outString)

  Ok(views.html.index.apply( outString, 4.0f))

  }

  def buttonPressedTak = Action {

    if(number > 0 && number < pytania.length -1) {
      cenyUslug(number) = 0
     outString="Twoja odpowiedź: TAK"
    }
    if (number == 0 ) {
      outString=" Wciśnij  DALEJ by przejść do testu";
      number=0;

    }
    if (number == 4 ) {
      outString=" Wciśnij DALEJ by zobaczyć wynik testu ";
      cenyUslug(number) = 0
      number =5;
    }
    if (number == 5  ) {
      outString=" Wciśnij DALEJ by zobaczyć wynik testu ";
      number = 5 ;
    }
      Ok(views.html.index.apply(outString, 4.0f))
}


  def buttonPressedNie = Action {

    if(number > 0 && number < pytania.length -1) {
      cenyUslug(number) = ceny(number)
      outString="Twoja odpowiedź to: NIE"
    }
    if (number == 0 ) {
      outString=" Wciśnij  DALEJ by przejść do testu";
      number=0;
      wartownik=2;
    }
    if (number == 4 ) {
      cenyUslug(number) = ceny(number)
      outString=" Wciśnij DALEJ by zobaczyć wynik testu ";
      number =5;

    }
    if (number == 5  ) {
      outString="Wciśnij DALEJ by zobaczyć wynik testu ";
      number = 5 ;
    }

    Ok(views.html.index.apply(outString, 4.0f))

}




}