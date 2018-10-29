package net.bplaced.javacrypto.general;

/*
* Herkunft/Origin: http://javacrypto.bplaced.net/
* Programmierer/Programmer: Michael Fehr
* Copyright/Copyright: frei verwendbares Programm (Public Domain)
* Copyright: This is free and unencumbered software released into the public domain.
* Lizenttext/Licence: <http://unlicense.org>
* getestet mit/tested with: Java Runtime Environment 8 Update 181 x64
* Datum/Date (dd.mm.jjjj): 25.09.2018
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

public class A04_CryptoAlgorithms {
	
	public static void main(String[] args) {

		System.out.println("A04 Auflistung aller Kryptographie-Provider und unterstützten Algorithmen");
		// source https://stackoverflow.com/questions/3683302/how-to-find-out-what-algorithm-encryption-are-supported-by-my-jvm/3683915#3683915
		for (Provider provider : Security.getProviders()) {
			System.out.println("Provider: " + provider.getName() + " version: " + provider.getVersion());
			for (Provider.Service service : provider.getServices()) {
				System.out.printf("  Type: %-30s  Algorithm: %-30s\n", service.getType(), service.getAlgorithm());
			}
		}
	}
}

/*
Auflistung aller Kryptographie-Provider und unterstützten Algorithmen
Provider: SUN version: 1.8
  Type: SecureRandom                    Algorithm: SHA1PRNG                      
  Type: Signature                       Algorithm: SHA1withDSA                   
  Type: Signature                       Algorithm: NONEwithDSA                   
  Type: Signature                       Algorithm: SHA224withDSA                 
  Type: Signature                       Algorithm: SHA256withDSA                 
  Type: KeyPairGenerator                Algorithm: DSA                           
  Type: MessageDigest                   Algorithm: MD2                           
  Type: MessageDigest                   Algorithm: MD5                           
  Type: MessageDigest                   Algorithm: SHA                           
  Type: MessageDigest                   Algorithm: SHA-224                       
  Type: MessageDigest                   Algorithm: SHA-256                       
  Type: MessageDigest                   Algorithm: SHA-384                       
  Type: MessageDigest                   Algorithm: SHA-512                       
  Type: AlgorithmParameterGenerator     Algorithm: DSA                           
  Type: AlgorithmParameters             Algorithm: DSA                           
  Type: KeyFactory                      Algorithm: DSA                           
  Type: CertificateFactory              Algorithm: X.509                         
  Type: KeyStore                        Algorithm: JKS                           
  Type: KeyStore                        Algorithm: CaseExactJKS                  
  Type: KeyStore                        Algorithm: DKS                           
  Type: Policy                          Algorithm: JavaPolicy                    
  Type: Configuration                   Algorithm: JavaLoginConfig               
  Type: CertPathBuilder                 Algorithm: PKIX                          
  Type: CertPathValidator               Algorithm: PKIX                          
  Type: CertStore                       Algorithm: LDAP                          
  Type: CertStore                       Algorithm: Collection                    
  Type: CertStore                       Algorithm: com.sun.security.IndexedCollection
Provider: SunRsaSign version: 1.8
  Type: KeyFactory                      Algorithm: RSA                           
  Type: KeyPairGenerator                Algorithm: RSA                           
  Type: Signature                       Algorithm: MD2withRSA                    
  Type: Signature                       Algorithm: MD5withRSA                    
  Type: Signature                       Algorithm: SHA1withRSA                   
  Type: Signature                       Algorithm: SHA224withRSA                 
  Type: Signature                       Algorithm: SHA256withRSA                 
  Type: Signature                       Algorithm: SHA384withRSA                 
  Type: Signature                       Algorithm: SHA512withRSA                 
Provider: SunEC version: 1.8
  Type: KeyFactory                      Algorithm: EC                            
  Type: AlgorithmParameters             Algorithm: EC                            
  Type: Signature                       Algorithm: NONEwithECDSA                 
  Type: Signature                       Algorithm: SHA1withECDSA                 
  Type: Signature                       Algorithm: SHA224withECDSA               
  Type: Signature                       Algorithm: SHA256withECDSA               
  Type: Signature                       Algorithm: SHA384withECDSA               
  Type: Signature                       Algorithm: SHA512withECDSA               
  Type: KeyPairGenerator                Algorithm: EC                            
  Type: KeyAgreement                    Algorithm: ECDH                          
Provider: SunJSSE version: 1.8
  Type: KeyFactory                      Algorithm: RSA                           
  Type: KeyPairGenerator                Algorithm: RSA                           
  Type: Signature                       Algorithm: MD2withRSA                    
  Type: Signature                       Algorithm: MD5withRSA                    
  Type: Signature                       Algorithm: SHA1withRSA                   
  Type: Signature                       Algorithm: MD5andSHA1withRSA             
  Type: KeyManagerFactory               Algorithm: SunX509                       
  Type: KeyManagerFactory               Algorithm: NewSunX509                    
  Type: TrustManagerFactory             Algorithm: SunX509                       
  Type: TrustManagerFactory             Algorithm: PKIX                          
  Type: SSLContext                      Algorithm: TLSv1                         
  Type: SSLContext                      Algorithm: TLSv1.1                       
  Type: SSLContext                      Algorithm: TLSv1.2                       
  Type: SSLContext                      Algorithm: TLS                           
  Type: SSLContext                      Algorithm: Default                       
  Type: KeyStore                        Algorithm: PKCS12                        
Provider: SunJCE version: 1.8
  Type: Cipher                          Algorithm: RSA                           
  Type: Cipher                          Algorithm: DES                           
  Type: Cipher                          Algorithm: DESede                        
  Type: Cipher                          Algorithm: DESedeWrap                    
  Type: Cipher                          Algorithm: PBEWithMD5AndDES              
  Type: Cipher                          Algorithm: PBEWithMD5AndTripleDES        
  Type: Cipher                          Algorithm: PBEWithSHA1AndDESede          
  Type: Cipher                          Algorithm: PBEWithSHA1AndRC2_40          
  Type: Cipher                          Algorithm: PBEWithSHA1AndRC2_128         
  Type: Cipher                          Algorithm: PBEWithSHA1AndRC4_40          
  Type: Cipher                          Algorithm: PBEWithSHA1AndRC4_128         
  Type: Cipher                          Algorithm: PBEWithHmacSHA1AndAES_128     
  Type: Cipher                          Algorithm: PBEWithHmacSHA224AndAES_128   
  Type: Cipher                          Algorithm: PBEWithHmacSHA256AndAES_128   
  Type: Cipher                          Algorithm: PBEWithHmacSHA384AndAES_128   
  Type: Cipher                          Algorithm: PBEWithHmacSHA512AndAES_128   
  Type: Cipher                          Algorithm: PBEWithHmacSHA1AndAES_256     
  Type: Cipher                          Algorithm: PBEWithHmacSHA224AndAES_256   
  Type: Cipher                          Algorithm: PBEWithHmacSHA256AndAES_256   
  Type: Cipher                          Algorithm: PBEWithHmacSHA384AndAES_256   
  Type: Cipher                          Algorithm: PBEWithHmacSHA512AndAES_256   
  Type: Cipher                          Algorithm: Blowfish                      
  Type: Cipher                          Algorithm: AES                           
  Type: Cipher                          Algorithm: AES_128/ECB/NoPadding         
  Type: Cipher                          Algorithm: AES_128/CBC/NoPadding         
  Type: Cipher                          Algorithm: AES_128/OFB/NoPadding         
  Type: Cipher                          Algorithm: AES_128/CFB/NoPadding         
  Type: Cipher                          Algorithm: AES_128/GCM/NoPadding         
  Type: Cipher                          Algorithm: AES_192/ECB/NoPadding         
  Type: Cipher                          Algorithm: AES_192/CBC/NoPadding         
  Type: Cipher                          Algorithm: AES_192/OFB/NoPadding         
  Type: Cipher                          Algorithm: AES_192/CFB/NoPadding         
  Type: Cipher                          Algorithm: AES_192/GCM/NoPadding         
  Type: Cipher                          Algorithm: AES_256/ECB/NoPadding         
  Type: Cipher                          Algorithm: AES_256/CBC/NoPadding         
  Type: Cipher                          Algorithm: AES_256/OFB/NoPadding         
  Type: Cipher                          Algorithm: AES_256/CFB/NoPadding         
  Type: Cipher                          Algorithm: AES_256/GCM/NoPadding         
  Type: Cipher                          Algorithm: AESWrap                       
  Type: Cipher                          Algorithm: AESWrap_128                   
  Type: Cipher                          Algorithm: AESWrap_192                   
  Type: Cipher                          Algorithm: AESWrap_256                   
  Type: Cipher                          Algorithm: RC2                           
  Type: Cipher                          Algorithm: ARCFOUR                       
  Type: KeyGenerator                    Algorithm: DES                           
  Type: KeyGenerator                    Algorithm: DESede                        
  Type: KeyGenerator                    Algorithm: Blowfish                      
  Type: KeyGenerator                    Algorithm: AES                           
  Type: KeyGenerator                    Algorithm: RC2                           
  Type: KeyGenerator                    Algorithm: ARCFOUR                       
  Type: KeyGenerator                    Algorithm: HmacMD5                       
  Type: KeyGenerator                    Algorithm: HmacSHA1                      
  Type: KeyGenerator                    Algorithm: HmacSHA224                    
  Type: KeyGenerator                    Algorithm: HmacSHA256                    
  Type: KeyGenerator                    Algorithm: HmacSHA384                    
  Type: KeyGenerator                    Algorithm: HmacSHA512                    
  Type: KeyPairGenerator                Algorithm: DiffieHellman                 
  Type: AlgorithmParameterGenerator     Algorithm: DiffieHellman                 
  Type: KeyAgreement                    Algorithm: DiffieHellman                 
  Type: AlgorithmParameters             Algorithm: DiffieHellman                 
  Type: AlgorithmParameters             Algorithm: DES                           
  Type: AlgorithmParameters             Algorithm: DESede                        
  Type: AlgorithmParameters             Algorithm: PBE                           
  Type: AlgorithmParameters             Algorithm: PBEWithMD5AndDES              
  Type: AlgorithmParameters             Algorithm: PBEWithMD5AndTripleDES        
  Type: AlgorithmParameters             Algorithm: PBEWithSHA1AndDESede          
  Type: AlgorithmParameters             Algorithm: PBEWithSHA1AndRC2_40          
  Type: AlgorithmParameters             Algorithm: PBEWithSHA1AndRC2_128         
  Type: AlgorithmParameters             Algorithm: PBEWithSHA1AndRC4_40          
  Type: AlgorithmParameters             Algorithm: PBEWithSHA1AndRC4_128         
  Type: AlgorithmParameters             Algorithm: PBES2                         
  Type: AlgorithmParameters             Algorithm: PBEWithHmacSHA1AndAES_128     
  Type: AlgorithmParameters             Algorithm: PBEWithHmacSHA224AndAES_128   
  Type: AlgorithmParameters             Algorithm: PBEWithHmacSHA256AndAES_128   
  Type: AlgorithmParameters             Algorithm: PBEWithHmacSHA384AndAES_128   
  Type: AlgorithmParameters             Algorithm: PBEWithHmacSHA512AndAES_128   
  Type: AlgorithmParameters             Algorithm: PBEWithHmacSHA1AndAES_256     
  Type: AlgorithmParameters             Algorithm: PBEWithHmacSHA224AndAES_256   
  Type: AlgorithmParameters             Algorithm: PBEWithHmacSHA256AndAES_256   
  Type: AlgorithmParameters             Algorithm: PBEWithHmacSHA384AndAES_256   
  Type: AlgorithmParameters             Algorithm: PBEWithHmacSHA512AndAES_256   
  Type: AlgorithmParameters             Algorithm: Blowfish                      
  Type: AlgorithmParameters             Algorithm: AES                           
  Type: AlgorithmParameters             Algorithm: GCM                           
  Type: AlgorithmParameters             Algorithm: RC2                           
  Type: AlgorithmParameters             Algorithm: OAEP                          
  Type: KeyFactory                      Algorithm: DiffieHellman                 
  Type: SecretKeyFactory                Algorithm: DES                           
  Type: SecretKeyFactory                Algorithm: DESede                        
  Type: SecretKeyFactory                Algorithm: PBEWithMD5AndDES              
  Type: SecretKeyFactory                Algorithm: PBEWithMD5AndTripleDES        
  Type: SecretKeyFactory                Algorithm: PBEWithSHA1AndDESede          
  Type: SecretKeyFactory                Algorithm: PBEWithSHA1AndRC2_40          
  Type: SecretKeyFactory                Algorithm: PBEWithSHA1AndRC2_128         
  Type: SecretKeyFactory                Algorithm: PBEWithSHA1AndRC4_40          
  Type: SecretKeyFactory                Algorithm: PBEWithSHA1AndRC4_128         
  Type: SecretKeyFactory                Algorithm: PBEWithHmacSHA1AndAES_128     
  Type: SecretKeyFactory                Algorithm: PBEWithHmacSHA224AndAES_128   
  Type: SecretKeyFactory                Algorithm: PBEWithHmacSHA256AndAES_128   
  Type: SecretKeyFactory                Algorithm: PBEWithHmacSHA384AndAES_128   
  Type: SecretKeyFactory                Algorithm: PBEWithHmacSHA512AndAES_128   
  Type: SecretKeyFactory                Algorithm: PBEWithHmacSHA1AndAES_256     
  Type: SecretKeyFactory                Algorithm: PBEWithHmacSHA224AndAES_256   
  Type: SecretKeyFactory                Algorithm: PBEWithHmacSHA256AndAES_256   
  Type: SecretKeyFactory                Algorithm: PBEWithHmacSHA384AndAES_256   
  Type: SecretKeyFactory                Algorithm: PBEWithHmacSHA512AndAES_256   
  Type: SecretKeyFactory                Algorithm: PBKDF2WithHmacSHA1            
  Type: SecretKeyFactory                Algorithm: PBKDF2WithHmacSHA224          
  Type: SecretKeyFactory                Algorithm: PBKDF2WithHmacSHA256          
  Type: SecretKeyFactory                Algorithm: PBKDF2WithHmacSHA384          
  Type: SecretKeyFactory                Algorithm: PBKDF2WithHmacSHA512          
  Type: Mac                             Algorithm: HmacMD5                       
  Type: Mac                             Algorithm: HmacSHA1                      
  Type: Mac                             Algorithm: HmacSHA224                    
  Type: Mac                             Algorithm: HmacSHA256                    
  Type: Mac                             Algorithm: HmacSHA384                    
  Type: Mac                             Algorithm: HmacSHA512                    
  Type: Mac                             Algorithm: HmacPBESHA1                   
  Type: Mac                             Algorithm: PBEWithHmacSHA1               
  Type: Mac                             Algorithm: PBEWithHmacSHA224             
  Type: Mac                             Algorithm: PBEWithHmacSHA256             
  Type: Mac                             Algorithm: PBEWithHmacSHA384             
  Type: Mac                             Algorithm: PBEWithHmacSHA512             
  Type: Mac                             Algorithm: SslMacMD5                     
  Type: Mac                             Algorithm: SslMacSHA1                    
  Type: KeyStore                        Algorithm: JCEKS                         
  Type: KeyGenerator                    Algorithm: SunTlsPrf                     
  Type: KeyGenerator                    Algorithm: SunTls12Prf                   
  Type: KeyGenerator                    Algorithm: SunTlsMasterSecret            
  Type: KeyGenerator                    Algorithm: SunTlsKeyMaterial             
  Type: KeyGenerator                    Algorithm: SunTlsRsaPremasterSecret      
Provider: SunJGSS version: 1.8
  Type: GssApiMechanism                 Algorithm: 1.2.840.113554.1.2.2          
  Type: GssApiMechanism                 Algorithm: 1.3.6.1.5.5.2                 
Provider: SunSASL version: 1.8
  Type: SaslClientFactory               Algorithm: DIGEST-MD5                    
  Type: SaslClientFactory               Algorithm: NTLM                          
  Type: SaslClientFactory               Algorithm: GSSAPI                        
  Type: SaslClientFactory               Algorithm: EXTERNAL                      
  Type: SaslClientFactory               Algorithm: PLAIN                         
  Type: SaslClientFactory               Algorithm: CRAM-MD5                      
  Type: SaslServerFactory               Algorithm: CRAM-MD5                      
  Type: SaslServerFactory               Algorithm: GSSAPI                        
  Type: SaslServerFactory               Algorithm: DIGEST-MD5                    
  Type: SaslServerFactory               Algorithm: NTLM                          
Provider: XMLDSig version: 1.8
  Type: TransformService                Algorithm: http://www.w3.org/2006/12/xml-c14n11#WithComments
  Type: TransformService                Algorithm: http://www.w3.org/2000/09/xmldsig#base64
  Type: TransformService                Algorithm: http://www.w3.org/TR/1999/REC-xslt-19991116
  Type: TransformService                Algorithm: http://www.w3.org/2001/10/xml-exc-c14n#
  Type: TransformService                Algorithm: http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments
  Type: TransformService                Algorithm: http://www.w3.org/2000/09/xmldsig#enveloped-signature
  Type: TransformService                Algorithm: http://www.w3.org/2002/06/xmldsig-filter2
  Type: XMLSignatureFactory             Algorithm: DOM                           
  Type: TransformService                Algorithm: http://www.w3.org/TR/2001/REC-xml-c14n-20010315
  Type: TransformService                Algorithm: http://www.w3.org/2001/10/xml-exc-c14n#WithComments
  Type: TransformService                Algorithm: http://www.w3.org/2006/12/xml-c14n11
  Type: TransformService                Algorithm: http://www.w3.org/TR/1999/REC-xpath-19991116
  Type: KeyInfoFactory                  Algorithm: DOM                           
Provider: SunPCSC version: 1.8
  Type: TerminalFactory                 Algorithm: PC/SC                         
Provider: SunMSCAPI version: 1.8
  Type: SecureRandom                    Algorithm: Windows-PRNG                  
  Type: KeyStore                        Algorithm: Windows-MY                    
  Type: KeyStore                        Algorithm: Windows-ROOT                  
  Type: Signature                       Algorithm: NONEwithRSA                   
  Type: Signature                       Algorithm: SHA1withRSA                   
  Type: Signature                       Algorithm: SHA256withRSA                 
  Type: Signature                       Algorithm: SHA384withRSA                 
  Type: Signature                       Algorithm: SHA512withRSA                 
  Type: Signature                       Algorithm: MD5withRSA                    
  Type: Signature                       Algorithm: MD2withRSA                    
  Type: KeyPairGenerator                Algorithm: RSA                           
  Type: Cipher                          Algorithm: RSA                           
  Type: Cipher                          Algorithm: RSA/ECB/PKCS1Padding  
*/