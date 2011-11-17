/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.slf4j;

import org.kjots.lib.gwt.client.slf4j.GwtLoggerFactory;

import com.google.gwt.core.client.GWT;

/**
 * Logger Factory.
 * <p>
 * Created: 13th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public final class LoggerFactory {
  private static final ILoggerFactory loggerFactory = GWT.create(GwtLoggerFactory.class);
  
  // This method has been copied verbatim from source of the upstream LoggerFactory class.
  public static Logger getLogger(String name) {
    ILoggerFactory iLoggerFactory = getILoggerFactory();
    return iLoggerFactory.getLogger(name);
  }

  // This method has been copied verbatim from source of the upstream LoggerFactory class.
  public static Logger getLogger(Class clazz) {
    return getLogger(clazz.getName());
  }

  public static ILoggerFactory getILoggerFactory() {
    return loggerFactory;
  }
}
