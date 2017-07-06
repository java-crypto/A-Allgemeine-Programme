package javaCrypto;

/*
* Programm/Program A02_Systemeigenschaften.java
* Kurzbeschreibung/Short description:
* Das Programm gibt wichtige Java-Systemeigenschaften aus.
* Program shows important Java systemfeatures. 
* Herkunft/Origin: http://javacrypto.bplaced.net/
* Sourcecode: https://github.com/java-crypto/A-Allgemeine-Programme/
* Programmierer/Programmer: Michael Fehr
*
* getestet mit/checked with Java Runtime Environment 8 Update 131
* letzter Test/last check: 06.07.2017/July 6th. 2017 
*
* Copyright/Copyright: frei verwendbares Programm/Public Domain
* Lizenzmodell/Licence model: CC0 (Public Domain wo verfügbar/where available)
* Lizenzhinweise/Licence links:
* https://de.wikipedia.org/wiki/Creative_Commons#CC_Zero
* https://en.wikipedia.org/wiki/Creative_Commons_license
* 
* Sicherheitshinweis/Security notice
* Die Programmroutinen dienen nur der Darstellung und haben keinen Anspruch auf eine korrekte Funktion, 
* insbesondere mit Blick auf die Sicherheit ! 
* Prüfen Sie die Sicherheit bevor die Programm in der echten Welt eingesetzt werden.
* The program routines just show the function but please be aware of the security part - 
* check yourself before using in the real world !
*/

public class A02_Systemeigenschaften {

	public static void main(String[] args) {
		System.out.println("A02 Systemeigenschaften");
		System.out.println("Programm gibt alle Systemeigenschaften aus");
		System.getProperties().list( System.out );
	}

}
