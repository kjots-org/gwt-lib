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

import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;
import org.slf4j.helpers.BasicMarkerFactory;

/**
 * GWT Marker Factory.
 * <p>
 * Created: 17th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class GwtMarkerFactory implements IMarkerFactory {
  /** The default marker factory. */
  private final IMarkerFactory defaultMarkerFactory = new BasicMarkerFactory();

  /**
   * @see IMarkerFactory#getMarker(String)
   */
  @Override
  public Marker getMarker(String name) {
    return this.defaultMarkerFactory.getMarker(name);
  }

  /**
   * @see IMarkerFactory#exists(String)
   */
  @Override
  public boolean exists(String name) {
    return this.defaultMarkerFactory.exists(name);
  }

  /**
   * @see IMarkerFactory#detachMarker(String)
   */
  @Override
  public boolean detachMarker(String name) {
    return this.defaultMarkerFactory.detachMarker(name);
  }

  /**
   * @see IMarkerFactory#getDetachedMarker(String)
   */
  @Override
  public Marker getDetachedMarker(String name) {
    return this.defaultMarkerFactory.getDetachedMarker(name);
  }
}
