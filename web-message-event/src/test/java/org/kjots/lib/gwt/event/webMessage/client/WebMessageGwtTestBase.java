/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * Web Message GWT Test Base.
 * <p>
 * Created: 4th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public abstract class WebMessageGwtTestBase extends GWTTestCase {
  /**
   * Retrieve the name of the GWT module.
   *
   * @return The name of the GWT module.
   */
  @Override
  public final String getModuleName() {
    return "org.kjots.lib.gwt.event.webMessage.WebMessage";
  }
}
