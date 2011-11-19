/* 
 * Copyright © 2011 Karl J. Ots <kjots@kjots.org>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.slf4j;

import java.util.Map;

import org.kjots.lib.gwt.client.slf4j.GwtMDCAdapter;
import org.slf4j.spi.MDCAdapter;

import com.google.gwt.core.client.GWT;

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
  
  private static MDCAdapter mdcAdapter = GWT.create(GwtMDCAdapter.class);
  
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
