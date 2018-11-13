package net.bplaced.javacrypto.general;

/*
* Herkunft/Origin: http://javacrypto.bplaced.net/
* Programmierer/Programmer: Michael Fehr
* Copyright/Copyright: frei verwendbares Programm (Public Domain)
* Copyright: This is free and unencumbered software released into the public domain.
* Lizenttext/Licence: <http://unlicense.org>
* getestet mit/tested with: Java Runtime Environment 8 Update 191 x64
* Datum/Date (dd.mm.jjjj): 13.11.2018 
* Funktion: Demonstriert das PBKDF2-Hashing
* Function: shows the PBKDF2-Hashing
*
* Sicherheitshinweis/Security notice
* Die Programmroutinen dienen nur der Darstellung und haben keinen Anspruch auf eine 
* korrekte Funktion, insbesondere mit Blick auf die Sicherheit ! 
* Pr�fen Sie die Sicherheit bevor das Programm in der echten Welt eingesetzt wird.
* The program routines just show the function but please be aware of the security part - 
* check yourself before using in the real world !
*/

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

public class A08_PBKDF2 {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		System.out.println("A08 PBKDF2");

		// das passwort wird z.b. von einem jPassword-Feld �bergeben
		char[] passwordChar = "geheimes Passwort".toCharArray();

		// variablen f�r pbkdf2
		final int PBKDF2_ITERATIONS = 10000; // anzahl der iterationen, h�her = besser = langsamer
		final int SALT_SIZE_BYTE = 128; // gr�sse des salts, sollte so gro� wie der hash sein
		final int HASH_SIZE_BYTE = 128; // gr��e das hashes bzw. gehashten passwortes, 128 byte = 512 bit
		byte[] passwordHashByte = new byte[HASH_SIZE_BYTE]; // das array nimmt das gehashte passwort auf

		// wir erzeugen einen zufalls salt mit securerandom, nicht mit random
		SecureRandom secureRandom = new SecureRandom();
		byte passwordSaltByte[] = new byte[SALT_SIZE_BYTE];
		secureRandom.nextBytes(passwordSaltByte);

		// erstellung des gehashten passwortes
		PBEKeySpec spec = new PBEKeySpec(passwordChar, passwordSaltByte, PBKDF2_ITERATIONS, HASH_SIZE_BYTE);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
		passwordHashByte = skf.generateSecret(spec).getEncoded();

		// das passwordHash wird an die ver- oder entschl�sselungs-routine �bergeben
		System.out.println("passwordChar: " + String.valueOf(passwordChar));
		System.out.println("Iterationen : " + PBKDF2_ITERATIONS);
		System.out.println("passwordSalt: " + DatatypeConverter.printHexBinary(passwordSaltByte));
		System.out.println("passwordHash: " + DatatypeConverter.printHexBinary(passwordHashByte));
	}
}
