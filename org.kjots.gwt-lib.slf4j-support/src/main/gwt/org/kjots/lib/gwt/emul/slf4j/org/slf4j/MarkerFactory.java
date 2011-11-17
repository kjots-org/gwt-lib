/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
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
