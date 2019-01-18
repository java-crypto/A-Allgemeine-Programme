package net.bplaced.javacrypto.general;

/*
* Herkunft/Origin: http://javacrypto.bplaced.net/
* Programmierer/Programmer: Michael Fehr
* Copyright/Copyright: frei verwendbares Programm (Public Domain)
* Copyright: This is free and unencumbered software released into the public domain.
* Lizenttext/Licence: <http://unlicense.org>
* getestet mit/tested with: Java Runtime Environment 8 Update 191 x64
* getestet mit/tested with: Java Runtime Environment 11.0.1 x64
* Datum/Date (dd.mm.jjjj): 13.01.2019
* Funktion: kodiert ein Byte Array in einen Base64-formatierten String und wieder zurück
* Function: converts a Byte Array into a Base64-formatted String and reverse
*
* Sicherheitshinweis/Security notice
* Die Programmroutinen dienen nur der Darstellung und haben keinen Anspruch auf eine 
* korrekte Funktion, insbesondere mit Blick auf die Sicherheit ! 
* Prüfen Sie die Sicherheit bevor das Programm in der echten Welt eingesetzt wird.
* The program routines just show the function but please be aware of the security part - 
* check yourself before using in the real world !
*/

import java.util.Base64; // notwendig fuer die base64-kodierung

public class A09_Base64_KodierungJava11 {

	public static void main(String[] args) throws Exception {
		System.out.println("A09 Base64-Kodierung");

		// unsere Variablen
		String dataString = "1234567890";
		byte[] dataToBase64Byte = null; // der Inhalt wird später Base64-kodiert
		String dataBase64String = ""; // in den String kommen die Base64-kodierten Daten
		byte[] dataFromBase64Byte = null; // dieses Byte Array nimmt später die Base64-dekodierten Daten auf
		String dataFromBase64String = ""; // in den String kommen die Base64-dekodierten Daten

		// die variable wird mit daten gefuellt
		dataToBase64Byte = dataString.getBytes("UTF-8");

		// hier erfolgt die base64-kodierung, d.h. das byte array wird in einen string
		// kodiert
		dataBase64String = Base64.getEncoder().encodeToString(dataToBase64Byte);
		// hier erfolgt die base64-dekodierung, d.h. der string wird in ein byte array
		// zurueck kodiert
		dataFromBase64Byte = Base64.getDecoder().decode(dataBase64String);
		// umwandlung vom byte array in einen string
		dataFromBase64String = new String(dataFromBase64Byte, "utf-8");

		System.out.println("");
		System.out.println("dataString (String-Format)        :" + dataString);
		System.out.println("dataToBase64Byte (Hex-Format)     :" + printHexBinary(dataToBase64Byte));
		System.out.println("data64String (String-Format)      :" + dataBase64String);
		System.out
				.println("dataFromBase64Byte (Hex-Format)   :" + printHexBinary(dataFromBase64Byte));
		System.out.println("dataFromBase64Byte (String-Format):" + dataFromBase64String);
	}

	public static String printHexBinary(byte[] bytes) {
		final char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}