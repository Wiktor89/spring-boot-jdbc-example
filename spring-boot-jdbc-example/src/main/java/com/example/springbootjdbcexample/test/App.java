package com.example.springbootjdbcexample.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.*;


public class App {
    private static CreditSupportCertificateInfo certificate;

    public static void main (String[] args) throws IOException, CertificateException, CRLException {
        System.out.println (new App ().getX509CRL ("sert/A000CZ01.cer").toString ());
        //BC is the ID for the Bouncy Castle provider;
//        Provider bc2 = Security.getProvider ("BC");
//        Security.addProvider (new BouncyCastleProvider ());
//        Provider[] bc1 = Security.getProviders ();
//        Provider bc = Security.getProvider ("SunJCE");
//        if (bc == null) {  // SunJCE
//            System.out.println ("Bouncy Castle provider is NOT available");
//        } else {
//            System.out.println ("Bouncy Castle provider is available");
//        }
//        CertificateFactory factory = CertificateFactory.getInstance ("X.509");
//        InputStream fis = null;
//        fis = new FileInputStream ("C:\\Users\\VGrigorenko\\r29\\testCertificate\\Komarov.cer ");
//
//        X509Certificate checkResultCertificate = (X509Certificate) factory.generateCertificate (fis);
//        certificate = new CreditSupportCertificateInfo ();
//
//
//        certificate.setSerialNumber (checkResultCertificate.getSerialNumber ().toString ());
//        certificate.setValidNotBefore (checkResultCertificate.getNotBefore ());
//        certificate.setValidNotAfter (checkResultCertificate.getNotAfter ());
//
//        certificate.setOwner (checkResultCertificate.getSubjectDN ().getName ());
//
//        String owner = checkResultCertificate.getSubjectDN ().getName ();
//        String issuer = checkResultCertificate.getIssuerDN ().getName ();
//        System.out.println ("\nOwner getName:  " + owner);
//        System.out.println ("\nIssuer getName:  " + issuer);
//        System.out.println ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
//
//        String regex = "(,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
//        String regexKeyValue = " *= *";
//        String[] pairs;
//        for (String keyValue : owner.split (regex, -1)) {
//            pairs = keyValue.split (regexKeyValue, 2);
//            if ((pairs.length > 1) && !(pairs[1].trim ().isEmpty ())) { // Если у нас получилась пара ключ->значение и значение не пустое, то:
//                definitionValueOfOwner (pairs[0], pairs[1]);
//            }
//        }
//
//        for (String keyValue : issuer.split (regex, -1)) {
//            pairs = keyValue.split (regexKeyValue, 2);
//            if ((pairs.length > 1) && !(pairs[1].trim ().isEmpty ())) {
//                definitionValueOfIssuer (pairs[0], pairs[1]);
//            }
//        }
        //factory.generateCRL()
        //checkResultCertificate.getCriticalExtensionOIDs();
        //System.out.println(checkResultCertificate.getCRL);
        //System.out.println(checkResultCertificate.getCriticalExtensionOIDs());


//            X509CRL crl = (X509CRL) factory.generateCRL(fis);
//            System.out.println(crl.getRevokedCertificates());

//            Set s = checkResultCertificate..getRevokedCertificates();
//            if (s != null && s.isEmpty() == false) {
//                Iterator t = s.iterator();
//                while (t.hasNext()) {
//                    X509CRLEntry entry = (X509CRLEntry) t.next();
//                    System.out.println("serial number = " + entry.getSerialNumber().toString(16));
//                    System.out.println("revocation date = " + entry.getRevocationDate());
//                    System.out.println("extensions = " + entry.hasExtensions());
//                }
//            }
    }

    private X509CRL getX509CRL (String certFile) throws IOException, CRLException {
        X509CRL crl = null;
        ClassLoader loader = getClass ().getClassLoader ();
        File file = new File (loader.getResource (certFile).getFile ());
        if (file.exists ()) {
            try (InputStream inStream = new FileInputStream (file)) {
                CertificateFactory factory = CertificateFactory.getInstance ("X.509");
//                CertificateFactory factory = CertificateFactory.getInstance ("X.509", new BouncyCastleProvider ());
//                X509Certificate x509Certificate = (X509Certificate) factory.generateCertificate (inStream);
                CRL crl1 = factory.generateCRL (inStream);
                System.out.println ();
            } catch (CertificateException e) {
                e.printStackTrace ();
            }
        }
        return crl;
    }

    private static void definitionValueOfOwner (String key, String value) {
        switch (key) {
            case "СНИЛС":
                certificate.setOwnerSnils (value);
                break;

            case "ОГРН":
                certificate.setOwnerOGRN (value);
                break;

            case "ИНН":
                certificate.setOwnerINN (value);
                break;

            case "C":
                certificate.setOwnerCountry (value);
                break;

            case "ST":
                certificate.setOwnerStateOrProvince (value);
                break;

            case "L":
                certificate.setOwnerLocality (value);
                break;

            case "O":
                certificate.setOwnerOrganization (value);
                break;

            case "CN":
                certificate.setOwnerCommonName (value);
                break;

            case "STREET":
                certificate.setOwnerStreet (value);
                break;

            case "TITLE":
                certificate.setOwnerTitle (value);
                break;

            case "G":
                certificate.setOwnerGivenName (value);
                break;

            case "SN":
                certificate.setOwnerSureName (value);
                break;
        }
    }

    private static void definitionValueOfIssuer (String key, String value) {
        switch (key) {
            case "EMAIL":
                certificate.setIssuerEmail (value);
                break;

            case "ОГРН":
                certificate.setIssuerOGRN (value);
                break;

            case "ИНН":
                certificate.setIssuerINN (value);
                break;

            case "C":
                certificate.setIssuerCountry (value);
                break;

            case "ST":
                certificate.setIssuerStateOrProvince (value);
                break;

            case "L":
                certificate.setIssuerLocality (value);
                break;

            case "STREET":
                certificate.setIssuerStreet (value);
                break;

            case "OU":
                certificate.setOrganizationalUnit (value);
                break;

            case "O":
                certificate.setOrganization (value);
                break;

            case "CN":
                certificate.setIssuerCommonName (value);
                break;
        }
    }
}