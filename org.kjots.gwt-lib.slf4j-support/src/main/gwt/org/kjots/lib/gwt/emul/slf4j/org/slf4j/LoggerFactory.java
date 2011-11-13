/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.slf4j;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

/**
 * Logger Factory.
 * <p>
 * Created: 13th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public final class LoggerFactory {
  private static NOPLoggerFactory NOP_FALLBACK_FACTORY = new NOPLoggerFactory();
  
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
    // TODO: Implement this properly.
    return NOP_FALLBACK_FACTORY;
  }
}
