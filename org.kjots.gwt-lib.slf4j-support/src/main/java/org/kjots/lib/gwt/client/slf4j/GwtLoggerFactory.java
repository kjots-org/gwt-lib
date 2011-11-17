/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.client.slf4j;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.helpers.NOPLoggerFactory;

/**
 * GWT Logger Factory.
 * <p>
 * Created: 17th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class GwtLoggerFactory implements ILoggerFactory {
  /** The default logger factory. */
  private final ILoggerFactory defaultLoggerFactory = new NOPLoggerFactory();

  /**
   * @see ILoggerFactory#getLogger(String)
   */
  @Override
  public Logger getLogger(String name) {
    return this.defaultLoggerFactory.getLogger(name);
  }
}
