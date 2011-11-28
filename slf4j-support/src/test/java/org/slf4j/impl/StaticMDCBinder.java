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
package org.slf4j.impl;

import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.spi.MDCAdapter;

/**
 * Static MDC Binder.
 * <p>
 * Created: 28th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class StaticMDCBinder {
  /** The singleton instance of this class. */
  public static final StaticMDCBinder SINGLETON = new StaticMDCBinder();
  
  /** The MDC adapter. */
  private final MDCAdapter mdcAdapter = new NOPMDCAdapter();
  
  /** The MDC adapter class string. */
  private final String mdcAdapterClassStr = NOPMDCAdapter.class.getName();
  
  /**
   * Retrieve the MDC adapter.
   *
   * @return The MDC adapter.
   */
  public MDCAdapter getMDCA() {
    return this.mdcAdapter;
  }
  
  /**
   * Retrieve the MDC adapter class string.
   *
   * @return The MDC adapter class string.
   */
  public String  getMDCAdapterClassStr() {
    return this.mdcAdapterClassStr;
  }
  
  /**
   * Construct a new Static MDC Binder.
   * <p>
   * This constructor is declared <code>private</code> to prevent external
   * instantiation.
   */
  private StaticMDCBinder() {
  }
}
