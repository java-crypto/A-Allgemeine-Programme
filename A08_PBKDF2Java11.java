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
* Funktion: Demonstriert das PBKDF2-Hashing
* Function: shows the PBKDF2-Hashing
*
* Sicherheitshinweis/Security notice
* Die Programmroutinen dienen nur der Darstellung und haben keinen Anspruch auf eine 
* korrekte Funktion, insbesondere mit Blick auf die Sicherheit ! 
* Prüfen Sie die Sicherheit bevor das Programm in der echten Welt eingesetzt wird.
* The program routines just show the function but please be aware of the security part - 
* check yourself before using in the real world !
*/

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class A08_PBKDF2Java11 {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		System.out.println("A08 PBKDF2");

		// das passwort wird z.b. von einem jPassword-Feld übergeben
		char[] passwordChar = "geheimes Passwort".toCharArray();

		// variablen für pbkdf2
		final int PBKDF2_ITERATIONS = 10000; // anzahl der iterationen, höher = besser = langsamer
		final int SALT_SIZE_BYTE = 128; // grösse des salts, sollte so groß wie der hash sein
		final int HASH_SIZE_BYTE = 128; // größe das hashes bzw. gehashten passwortes, 128 byte = 512 bit
		byte[] passwordHashByte = new byte[HASH_SIZE_BYTE]; // das array nimmt das gehashte passwort auf

		// wir erzeugen einen zufalls salt mit securerandom, nicht mit random
		SecureRandom secureRandom = new SecureRandom();
		byte passwordSaltByte[] = new byte[SALT_SIZE_BYTE];
		secureRandom.nextBytes(passwordSaltByte);

		// erstellung des gehashten passwortes
		PBEKeySpec spec = new PBEKeySpec(passwordChar, passwordSaltByte, PBKDF2_ITERATIONS, HASH_SIZE_BYTE);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
		passwordHashByte = skf.generateSecret(spec).getEncoded();

		// das passwordHash wird an die ver- oder entschlüsselungs-routine übergeben
		System.out.println("passwordChar: " + String.valueOf(passwordChar));
		System.out.println("Iterationen : " + PBKDF2_ITERATIONS);
		System.out.println("passwordSalt: " + printHexBinary(passwordSaltByte));
		System.out.println("passwordHash: " + printHexBinary(passwordHashByte));
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
