/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.client;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * SLF4J Support GWT Test Base.
 * <p>
 * Created: 13th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class Slf4jSupportGwtTestBase extends GWTTestCase {
  /**
   * Retrieve the name of the GWT module.
   *
   * @return The name of the GWT module.
   */
  @Override
  public final String getModuleName() {
    return "org.kjots.lib.gwt.Slf4jSupportTest";
  }
}
