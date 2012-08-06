/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.dom;

/**
 * IFrame Element.
 * <p>
 * Created: 6th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class IFrameElement extends com.google.gwt.dom.client.IFrameElement {
  /**
   * Retrieve the content window.
   *
   * @return The content window.
   */
  public final native Window getContentWindow() /*-{
    return this.contentWindow;
  }-*/;
  
  /**
   * Construct a new IFrame Element.
   */
  protected IFrameElement() {
  }
}
