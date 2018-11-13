package net.bplaced.javacrypto.general;

import javax.xml.bind.DatatypeConverter;

/*
* Herkunft/Origin: http://javacrypto.bplaced.net/
* Programmierer/Programmer: Michael Fehr
* Copyright/Copyright: frei verwendbares Programm (Public Domain)
* Copyright: This is free and unencumbered software released into the public domain.
* Lizenttext/Licence: <http://unlicense.org>
* getestet mit/tested with: Java Runtime Environment 8 Update 191 x64
* Datum/Date (dd.mm.jjjj): 13.11.2018 
* Funktion: Demonstriert das PKCS5-Padding
* Function: shows the PKCS5-Padding
*
* Sicherheitshinweis/Security notice
* Die Programmroutinen dienen nur der Darstellung und haben keinen Anspruch auf eine 
* korrekte Funktion, insbesondere mit Blick auf die Sicherheit ! 
* Prüfen Sie die Sicherheit bevor das Programm in der echten Welt eingesetzt wird.
* The program routines just show the function but please be aware of the security part - 
* check yourself before using in the real world !
*/

public class A06_Pkcs5Padding {

	public static void main(String[] args) {
		System.out.println("A06 PKCS5 Padding");
		System.out.println("");

		String plaintextOriginalString = "1234567890123456"; // testdaten mit 16 zeichen
		int blocklengthInt = 16; // bei aes-verfahren ist die blocklänge immer 16 byte

		String plaintextString = "";
		byte[] plaintextByte = new byte[16]; // in dieses byte array kopieren wir später teile plaintextOriginalString
		int plaintextLengthInt = 0; // länge des jeweils kopierten plaintextes
		int paddingcountInt = 0; // anzahl der fehlenden zeichen = padding-zeichen bis zur blocklengthInt
		byte[] paddingtextByte = null; // nimmt den plaintext nach padding auf

		String ausgabezeileString = ""; // zur formatierten ausgabe der daten

		System.out.println("blocklengthInt         :" + blocklengthInt);
		System.out.println("plaintextOriginalString:" + plaintextOriginalString);
		System.out.println("");
		System.out.println("Padding   plaintextByte                    Länge Anz Hex paddingtextByte"); // kopfzeile

		for (int copyInt = 1; copyInt < 17; copyInt++) {
			// wir kopieren nur einen teil des plaintextOriginalString
			plaintextString = plaintextOriginalString.substring(0, copyInt);
			plaintextLengthInt = plaintextString.length(); // die länge unseres plaintextes
			plaintextByte = plaintextString.getBytes();

			// ab hier wird das padding hinzugeführt
			paddingtextByte = new byte[blocklengthInt];
			if (plaintextLengthInt >= blocklengthInt) {
				paddingtextByte = new byte[(2 * blocklengthInt)];
			}
			System.arraycopy(plaintextByte, 0, paddingtextByte, 0, plaintextLengthInt);
			paddingcountInt = blocklengthInt - plaintextLengthInt;
			for (int i = plaintextLengthInt; i < blocklengthInt; i++) {
				paddingtextByte[i] = (byte) paddingcountInt;
			}

			// zusammenbau der ausgabezeile
			// plaintextByte plaintextLengthInt paddingcountInt paddingcountHex
			// paddingtextByte
			ausgabezeileString = formatMitLeerzeichenRechts(DatatypeConverter.printHexBinary(plaintextByte), 33);
			ausgabezeileString = ausgabezeileString
					+ formatMitLeerzeichenRechts(Integer.toString(plaintextLengthInt), 6);
			ausgabezeileString = ausgabezeileString + formatMitLeerzeichenRechts(Integer.toString(paddingcountInt), 5);
			ausgabezeileString = ausgabezeileString
					+ formatMitLeerzeichenRechts(Integer.toHexString(paddingcountInt), 3);
			ausgabezeileString = ausgabezeileString
					+ formatMitLeerzeichenRechts(DatatypeConverter.printHexBinary(paddingtextByte), 33);
			// ausgabe
			System.out.println("Ergebnis: " + ausgabezeileString);
		}
	}

	// Sehr einfache, aber bei grossen Datenmengen auch ineffiziente
	// Implementierung:
	public static String formatMitLeerzeichenRechts(String value, int len) {
		while (value.length() < len) {
			value += " ";
		}
		return value;
	}
}
