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

import org.slf4j.IMarkerFactory;
import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.spi.MarkerFactoryBinder;

/**
 * Static Marker Binder.
 * <p>
 * Created: 28th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class StaticMarkerBinder implements MarkerFactoryBinder {
  /** The singleton instance of this class. */
  public static final StaticMarkerBinder SINGLETON = new StaticMarkerBinder();
  
  /** The marker factory. */
  private final IMarkerFactory markerFactory = new BasicMarkerFactory();
  
  /** The marker factory class string. */
  private final String markerFactoryClasStr = BasicMarkerFactory.class.getName();
  
  /**
   * @see MarkerFactoryBinder#getMarkerFactory()
   */
  @Override
  public IMarkerFactory getMarkerFactory() {
    return this.markerFactory;
  }

  /**
   * @see MarkerFactoryBinder#getMarkerFactoryClassStr()
   */
  @Override
  public String getMarkerFactoryClassStr() {
    return this.markerFactoryClasStr;
  }

  /**
   * Construct a new Static Marker Binder.
   * <p>
   * This constructor is declared <code>private</code> to prevent external
   * instantiation.
   */
  private StaticMarkerBinder() {
  }
}
