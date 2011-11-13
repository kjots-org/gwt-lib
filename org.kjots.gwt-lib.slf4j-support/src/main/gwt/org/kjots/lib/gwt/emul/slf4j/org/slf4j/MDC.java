/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.slf4j;

import java.util.Map;

import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.spi.MDCAdapter;

/**
 * MDC.
 * <p>
 * Created: 13th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class MDC {
  private static final String NULL_MDCA_URL = "http://www.slf4j.org/codes.html#null_MDCA";
  
  // TODO: Implement this properly.
  private static MDCAdapter mdcAdapter = new NOPMDCAdapter();
  
  // This constructor has been copied verbatim from source of the upstream MDC class.
  private MDC() {
  }

  // This method has been copied verbatim from source of the upstream MDC class.
  public static void put(String key, String val)
      throws IllegalArgumentException {
    if (key == null) {
      throw new IllegalArgumentException("key parameter cannot be null");
    }
    if (mdcAdapter == null) {
      throw new IllegalStateException("MDCAdapter cannot be null. See also "
          + NULL_MDCA_URL);
    }
    mdcAdapter.put(key, val);
  }

  // This method has been copied verbatim from source of the upstream MDC class.
  public static String get(String key) throws IllegalArgumentException {
    if (key == null) {
      throw new IllegalArgumentException("key parameter cannot be null");
    }

    if (mdcAdapter == null) {
      throw new IllegalStateException("MDCAdapter cannot be null. See also "
          + NULL_MDCA_URL);
    }
    return mdcAdapter.get(key);
  }

  // This method has been copied verbatim from source of the upstream MDC class.
  public static void remove(String key) throws IllegalArgumentException {
    if (key == null) {
      throw new IllegalArgumentException("key parameter cannot be null");
    }

    if (mdcAdapter == null) {
      throw new IllegalStateException("MDCAdapter cannot be null. See also "
          + NULL_MDCA_URL);
    }
    mdcAdapter.remove(key);
  }

  // This method has been copied verbatim from source of the upstream MDC class.
  public static void clear() {
    if (mdcAdapter == null) {
      throw new IllegalStateException("MDCAdapter cannot be null. See also "
          + NULL_MDCA_URL);
    }
    mdcAdapter.clear();
  }

  // This method has been copied verbatim from source of the upstream MDC class.
  public static Map getCopyOfContextMap() {
    if (mdcAdapter == null) {
      throw new IllegalStateException("MDCAdapter cannot be null. See also "
          + NULL_MDCA_URL);
    }
    return mdcAdapter.getCopyOfContextMap();
  }

  // This method has been copied verbatim from source of the upstream MDC class.
  public static void setContextMap(Map contextMap) {
    if (mdcAdapter == null) {
      throw new IllegalStateException("MDCAdapter cannot be null. See also "
          + NULL_MDCA_URL);
    }
    mdcAdapter.setContextMap(contextMap);
  }

  // This method has been copied verbatim from source of the upstream MDC class.
  public static MDCAdapter getMDCAdapter() {
    return mdcAdapter;
  }
}
