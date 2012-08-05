/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.dom;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Message Channel.
 * <p>
 * Created: 3rd August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class MessageChannel extends JavaScriptObject {
  /**
   * Create a new message channel.
   *
   * @return The message channel.
   */
  public static native MessageChannel create() /*-{
    return new MessageChannel();
  }-*/;
  
  /**
   * Retrieve the first message port.
   *
   * @return The first message port.
   */
  public final native MessagePort getPort1() /*-{
    return this.port1;
  }-*/;
  
  /**
   * Retrieve the second message port.
   *
   * @return The second message port.
   */
  public final native MessagePort getPort2() /*-{
    return this.port2;
  }-*/;
  
  /**
   * Construct a new Message Channel.
   */
  protected MessageChannel() {
  }
}
