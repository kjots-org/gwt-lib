/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.dom;

import org.kjots.lib.gwt.js.util.client.JsAny;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Message Event.
 * <p>
 * Created: 3rd August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public class MessageEvent extends JavaScriptObject {
  /**
   * Retrieve the data.
   *
   * @return The data.
   */
  public final native JsAny<?> getData() /*-{
    return { "value" : this.data };
  }-*/;
  
  /**
   * Retrieve the origin.
   *
   * @return The origin.
   */
  public final native String getOrigin() /*-{
    return this.origin;
  }-*/;
  
  /**
   * Retrieve the last event ID.
   *
   * @return The last event ID.
   */
  public final native String getLastEventId() /*-{
    return this.lastEventId;
  }-*/;
  
  /**
   * Retrieve the source.
   *
   * @return The source.
   */
  public final native Window getSource() /*-{
    return this.source;
  }-*/;
  
  /**
   * Retrieve the message ports.
   *
   * @return The message ports.
   */
  public final native JsArray<MessagePort> getPorts() /*-{
    return this.ports;
  }-*/;
  
  /**
   * Construct a new Message Event.
   */
  protected MessageEvent() {
  }
}
