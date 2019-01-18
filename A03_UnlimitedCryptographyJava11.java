package net.bplaced.javacrypto.general;

/*
* Herkunft/Origin: http://javacrypto.bplaced.net/
* Programmierer/Programmer: Michael Fehr
* Copyright/Copyright: frei verwendbares Programm (Public Domain)
* Copyright: This is free and unencumbered software released into the public domain.
* Lizenttext/Licence: <http://unlicense.org>
* getestet mit/tested with: Java Runtime Environment 8 Update 181 x64
* getestet mit/tested with: Java Runtime Environment 11.0.1 x64
* Datum/Date (dd.mm.jjjj): 13.01.2019
* Funktion: ermittelt die maximale Kryptographie-Schlüssellänge
* Function: output of the allowed cryptographic key-length
*
* Sicherheitshinweis/Security notice
* Die Programmroutinen dienen nur der Darstellung und haben keinen Anspruch auf eine 
* korrekte Funktion, insbesondere mit Blick auf die Sicherheit ! 
* Prüfen Sie die Sicherheit bevor das Programm in der echten Welt eingesetzt wird.
* The program routines just show the function but please be aware of the security part - 
* check yourself before using in the real world !
*/

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

public class A03_UnlimitedCryptographyJava11 {

	public static void main(String[] args) {
		System.out.println("A03 Ausgabe der erlaubten Kryptograpie-Schluessellaenge");
		int allowedAesKeyLength = 0;
        try {
            allowedAesKeyLength = Cipher.getMaxAllowedKeyLength("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("Die erlaubte Schluessellaenge fuer AES ist: " + allowedAesKeyLength);
	}
}
