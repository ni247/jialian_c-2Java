package com.csii.pccc.core;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import com.csii.pccc.exception.SignException;
import com.csii.pccc.util.Assert;

/**
 * KeyProvider.java 证书处理类
 *
 * @version 1.0
 * @since 1.0
 */

public class KeyProvider
{
  private static final String DEFAULT_KEYSTORE = "/lib/security/cacerts";
  private static final String JAVA_HOME = "java.home";
  private KeyStore keystore;

  public KeyProvider(KeyStore keystore)
  {
    this.keystore = keystore;
  }

  public static KeyStore getInstance(String keyStoreType, String keystoreFilePath, String keystorePassword) {
    if (keystoreFilePath == null)
    {
      String javahomePath = System.getProperty("java.home");
      keystoreFilePath = javahomePath + "/lib/security/cacerts";
    }

    char[] pwd = (keystorePassword == null) ? null : keystorePassword.toCharArray();

    InputStream is = null;
    try
    {
//      KeyStore localKeyStore1;
      is = new BufferedInputStream(new FileInputStream(keystoreFilePath));

      KeyStore keystore = KeyStore.getInstance((null == keyStoreType) ? KeyStore.getDefaultType() : keyStoreType);

      keystore.load(is, pwd);
      return keystore;
    } catch (Exception e) {
    	e.printStackTrace();
    }
    finally {
      if (is != null)
        try {
          is.close();
        } catch (IOException e) {
          throw new SignException(e);
        }
    }
	return null;
  }

  public Certificate getCertificate(String alias)
    throws SignException
  {
    Assert.notNull(this.keystore, "keystore is null.");
    Assert.notNull(alias, "certificate alias is null.");
    try {
      return this.keystore.getCertificate(alias);
    } catch (KeyStoreException ex) {
      throw new SignException(ex);
    }
  }

  public Certificate[] getCertificateChain(String alias)
    throws SignException
  {
    Assert.notNull(this.keystore, "keystore is null.");
    Assert.notNull(alias, "certificate chain alias is null.");
    try {
      return this.keystore.getCertificateChain(alias);
    } catch (KeyStoreException ex) {
      throw new SignException(ex);
    }
  }

  public PrivateKey getPrivateKey(String alias, String privatekeyPassword)
    throws SignException
  {
    Assert.notNull(this.keystore, "keystore is null.");
    Assert.notNull(alias, "private key alias is null.");
    try {
      return ((PrivateKey)this.keystore.getKey(alias, (privatekeyPassword == null) ? null : privatekeyPassword.toCharArray()));
    } catch (Exception ex) {
      throw new SignException(ex);
    }
  }
  
  public static X509Certificate getCert(String certData) throws SignException {

		X509Certificate cert = null;
		BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(certData.trim().getBytes()));
		CertificateFactory cf;
		if("".equals(certData)){
			throw new SignException("publickey is null.");
		}
		try {
			cf = CertificateFactory.getInstance("X.509");
			cert = (X509Certificate) cf.generateCertificate(is);
		} catch (CertificateException e) {
			throw new SignException(e);
		}
		return cert;
	}
  
}
