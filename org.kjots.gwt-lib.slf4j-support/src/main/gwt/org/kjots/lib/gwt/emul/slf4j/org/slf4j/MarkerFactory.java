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

import org.kjots.lib.gwt.client.slf4j.GwtMarkerFactory;

import com.google.gwt.core.client.GWT;

/**
 * Marker Factory.
 * <p>
 * Created: 13th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class MarkerFactory {
  private static final IMarkerFactory markerFactory = GWT.create(GwtMarkerFactory.class);
  
  // This constructor has been copied verbatim from source of the upstream MarkerFactory class.
  private MarkerFactory() {
  }

  // This method has been copied verbatim from source of the upstream MarkerFactory class.
  public static Marker getMarker(String name) {
    return markerFactory.getMarker(name);
  }

  // This method has been copied verbatim from source of the upstream MarkerFactory class.
  public static Marker getDetachedMarker(String name) {
    return markerFactory.getDetachedMarker(name);
  }
  
  // This method has been copied verbatim from source of the upstream MarkerFactory class.
  public static IMarkerFactory getIMarkerFactory() {
    return markerFactory;
  }
}
