/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.client.slf4j;

import java.util.Map;

import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.spi.MDCAdapter;

/**
 * GWT MDC Adapter.
 * <p>
 * Created: 17th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class GwtMDCAdapter implements MDCAdapter {
  /** The default MDC adapter. */
  private final MDCAdapter defaultMdcAdapter = new NOPMDCAdapter();

  /**
   * @see MDCAdapter#put(String, String)
   */
  @Override
  public void put(String key, String val) {
    this.defaultMdcAdapter.put(key, val);
  }

  /**
   * @see MDCAdapter#get(String)
   */
  @Override
  public String get(String key) {
    return this.defaultMdcAdapter.get(key);
  }

  /**
   * @see MDCAdapter#remove(String)
   */
  @Override
  public void remove(String key) {
    this.defaultMdcAdapter.remove(key);
  }

  /**
   * @see MDCAdapter#clear()
   */
  @Override
  public void clear() {
    this.defaultMdcAdapter.clear();
  }

  /**
   * @see MDCAdapter#getCopyOfContextMap()
   */
  @Override
  @SuppressWarnings("rawtypes")
   public Map getCopyOfContextMap() {
    return this.defaultMdcAdapter.getCopyOfContextMap();
  }

  /**
   * @see MDCAdapter#setContextMap(Map)
   */
  @Override
  @SuppressWarnings("rawtypes")
  public void setContextMap(Map contextMap) {
    this.defaultMdcAdapter.setContextMap(contextMap);
  }
}
