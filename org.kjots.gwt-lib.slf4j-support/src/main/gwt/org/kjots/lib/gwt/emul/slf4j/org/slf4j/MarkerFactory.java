/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.slf4j;

import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;
import org.slf4j.helpers.BasicMarkerFactory;

/**
 * Marker Factory.
 * <p>
 * Created: 13th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class MarkerFactory {
  // TODO: Implement this properly.
  private static IMarkerFactory markerFactory = new BasicMarkerFactory();
  
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
