package net.bplaced.javacrypto.general;

/*
* Herkunft/Origin: http://javacrypto.bplaced.net/
* Programmierer/Programmer: Michael Fehr
* Copyright/Copyright: frei verwendbares Programm (Public Domain)
* Copyright: This is free and unencumbered software released into the public domain.
* Lizenttext/Licence: <http://unlicense.org>
* getestet mit/tested with: Java Runtime Environment 8 Update 181 x64
* Datum/Date (dd.mm.jjjj): 25.09.2018
* Funktion: gibt die verwendete Java-Version aus
* Function: output of the used Java-Version
*
* Sicherheitshinweis/Security notice
* Die Programmroutinen dienen nur der Darstellung und haben keinen Anspruch auf eine korrekte Funktion, 
* insbesondere mit Blick auf die Sicherheit ! 
* Prüfen Sie die Sicherheit bevor das Programm in der echten Welt eingesetzt wird.
* The program routines just show the function but please be aware of the security part - 
* check yourself before using in the real world !
*/

public class A01_HelloWorldJavaVersion {

	public static void main(String[] args) {
		System.out.println("Hallo Welt");
		System.out.println("Die vorhandene Java-Version ist:" + System.getProperty("java.version"));
	}

}
