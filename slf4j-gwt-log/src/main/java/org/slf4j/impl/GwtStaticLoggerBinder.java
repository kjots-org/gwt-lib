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

import org.kjots.lib.gwt.client.slf4j.GwtLogLoggerFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * Static Logger Binder.
 * <p>
 * Created: 20th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class GwtStaticLoggerBinder implements LoggerFactoryBinder {
  /** The requested API version. */
  public static String REQUESTED_API_VERSION = "1.6.99";
  
  /** The singleton instance of this class. */
  private static final GwtStaticLoggerBinder SINGLETON = new GwtStaticLoggerBinder();
  
  /** The logger factory. */
  private final ILoggerFactory loggerFactory = new GwtLogLoggerFactory();
  
  /** The logger factory class string. */
  private final String loggerFactoryClassStr = GwtLogLoggerFactory.class.getName();
  
  /**
   * Retrieve the singleton instance of this class.
   *
   * @return The singleton instance of this class.
   */
  public static final GwtStaticLoggerBinder getSingleton() {
    return SINGLETON;
  }
  
  /**
   * @see LoggerFactoryBinder#getLoggerFactory()
   */
  @Override
  public ILoggerFactory getLoggerFactory() {
    return this.loggerFactory;
  }
  
  /**
   * @see LoggerFactoryBinder#getLoggerFactoryClassStr()
   */
  @Override
  public String getLoggerFactoryClassStr() {
    return this.loggerFactoryClassStr;
  }

  /**
   * Construct a new Static Logger Binder.
   * <p>
   * This constructor is declared <code>private</code> to prevent external
   * instantiation.
   */
  private GwtStaticLoggerBinder() {
  }
}
