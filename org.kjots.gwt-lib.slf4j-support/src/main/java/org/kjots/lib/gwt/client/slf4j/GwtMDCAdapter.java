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
