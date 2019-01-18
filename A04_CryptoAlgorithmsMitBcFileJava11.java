package net.bplaced.javacrypto.general;

import java.io.BufferedWriter;
import java.io.FileWriter;

/*
* Herkunft/Origin: http://javacrypto.bplaced.net/
* Programmierer/Programmer: Michael Fehr
* Copyright/Copyright: frei verwendbares Programm (Public Domain)
* Copyright: This is free and unencumbered software released into the public domain.
* Lizenttext/Licence: <http://unlicense.org>
* getestet mit/tested with: Java Runtime Environment 8 Update 181 x64
* getestet mit/tested with: Java Runtime Environment 11.0.1 x64
* Datum/Date (dd.mm.jjjj): 13.01.2019
* Funktion: Auflistung aller Kryptographie-Provider und unterstützten Algorithmen in Java
* Function: output of all installed/available cryptography provider in Java
*
* Sicherheitshinweis/Security notice
* Die Programmroutinen dienen nur der Darstellung und haben keinen Anspruch auf eine  
* korrekte Funktion, insbesondere mit Blick auf die Sicherheit ! 
* Prüfen Sie die Sicherheit bevor das Programm in der echten Welt eingesetzt wird.
* The program routines just show the function but please be aware of the security part - 
* check yourself before using in the real world !
*/

import java.security.Provider;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class A04_CryptoAlgorithmsMitBcFileJava11 {

	public static void main(String[] args) throws Exception {

		// add at runtime the Bouncy Castle Provider
		// the provider is available only for this application
		Security.addProvider(new BouncyCastleProvider());
		System.out.println("A04 Auflistung aller Kryptographie-Provider und unterstützten Algorithmen mit BC Datei-Ausgabe");
		// write String to textfile
		String fileName = "A04 Auflistung aller Kryptographie-Provider und unterstützten Algorithmen mit BC.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		// source
		// https://stackoverflow.com/questions/3683302/how-to-find-out-what-algorithm-encryption-are-supported-by-my-jvm/3683915#3683915
		for (Provider provider : Security.getProviders()) {
			System.out.println("Provider: " + provider.getName() + " version: " + provider.getVersion());
			writer.write("Provider: " + provider.getName() + " version: " + provider.getVersion() + "\n");
			for (Provider.Service service : provider.getServices()) {
				System.out.printf("  Type: %-30s  Algorithm: %-30s\n", service.getType(), service.getAlgorithm());
				String output = String.format("  Type: %-30s  Algorithm: %-30s\n", service.getType(), service.getAlgorithm());
				writer.write(output);
			}
		}
		writer.close();
		System.out.println("Datei erzeugt, Programm beendet");
	}
}