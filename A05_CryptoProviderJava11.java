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
* Funktion: Auflistung aller Kryptographie-Provider in Java
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

public class A05_CryptoProviderJava11 {
	
	public static void main(String[] args) {

		System.out.println("A05 Auflistung aller Kryptographie-Provider");
		// source https://stackoverflow.com/questions/3683302/how-to-find-out-what-algorithm-encryption-are-supported-by-my-jvm/3683915#3683915
		for (Provider provider : Security.getProviders()) {
			System.out.println("Provider: " + provider.getName() + " version: " + provider.getVersion());
		}
	}
}

/*
A05 Auflistung aller Kryptographie-Provider
Provider: SUN version: 11.0
Provider: SunRsaSign version: 11.0
Provider: SunEC version: 11.0
Provider: SunJSSE version: 11.0
Provider: SunJCE version: 11.0
Provider: SunJGSS version: 11.0
Provider: SunSASL version: 11.0
Provider: XMLDSig version: 11.0
Provider: SunPCSC version: 11.0
Provider: JdkLDAP version: 11.0
Provider: JdkSASL version: 11.0
Provider: SunMSCAPI version: 11.0
Provider: SunPKCS11 version: 11.0
*/