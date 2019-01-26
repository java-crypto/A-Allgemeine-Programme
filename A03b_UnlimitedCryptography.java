package net.bplaced.javacrypto.general;

/*
* Herkunft/Origin: http://javacrypto.bplaced.net/
* Programmierer/Programmer: Michael Fehr
* Copyright/Copyright: frei verwendbares Programm (Public Domain)
* Copyright: This is free and unencumbered software released into the public domain.
* Lizenttext/Licence: <http://unlicense.org>
* getestet mit/tested with: Java Runtime Environment 8 Update 191 x64
* getestet mit/tested with: Java Runtime Environment 11.0.1 x64
* Datum/Date (dd.mm.jjjj): 25.01.2019
* Funktion: prüft auf unbegrenzte Kryptographie-Schlüssellänge
* Function: checks for unlimited cryptographic key-length
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

public class A03b_UnlimitedCryptography {

	public static void main(String[] args) {
		System.out.println("A03b Pruefung auf unbegrenzte Kryptographie-Schluessellaenge");
        
        System.out.println("Das System unterstützt nur die eingeschraenkte Kryptographie:" + restrictedCryptography());
        System.out.println("Moegliche Ergebnisse: false = unbeschraenkte Kryptographie freigeschaltet");
        System.out.println("                      true  = nur die eingeschraenkte Kryptographie ist freigeschaltet");
	}
	
	/**
	 * Determines if cryptography restrictions apply.
	 * Restrictions apply if the value of {@link Cipher#getMaxAllowedKeyLength(String)} returns a value smaller than {@link Integer#MAX_VALUE} if there are any restrictions according to the JavaDoc of the method.
	 * This method is used with the transform <code>"AES/CBC/PKCS5Padding"</code> as this is an often used algorithm that is <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#impl">an implementation requirement for Java SE</a>.
	 * 
	 * @return <code>true</code> if restrictions apply, <code>false</code> otherwise
	 */
	public static boolean restrictedCryptography() {
	    try {
	        return Cipher.getMaxAllowedKeyLength("AES/CBC/PKCS5Padding") < Integer.MAX_VALUE;
	    } catch (final NoSuchAlgorithmException e) {
	        throw new IllegalStateException("The transform \"AES/CBC/PKCS5Padding\" is not available (the availability of this algorithm is mandatory for Java SE implementations)", e);
	    }
	}
}
