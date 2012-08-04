/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.ui;

import org.kjots.lib.gwt.event.webMessage.client.HasWebMessageHandlers;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageEvent;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageHandler;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiConstructor;

/**
 * Named Frame.
 * <p>
 * Drop in replacement for GWT's {@link com.google.gwt.user.client.ui.NamedFrame NamedFrame}
 * with support for web message events.
 * <p>
 * Created: 4th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 * @see com.google.gwt.user.client.ui.NamedFrame
 */
public class NamedFrame extends com.google.gwt.user.client.ui.NamedFrame implements HasWebMessageHandlers {
  /**
   * Construct a new Named Frame.
   *
   * @param name The name.
   * @see com.google.gwt.user.client.ui.NamedFrame#NamedFrame(String)
   */
  @UiConstructor
  public NamedFrame(String name) {
    super(name);
  }
  
  /**
   * Add the given web message handler.
   *
   * @param webMessageHandler The web message handler.
   * @return The handler registration.
   */
  @Override
  public HandlerRegistration addWebMessageHandler(WebMessageHandler webMessageHandler) {
    return addHandler(webMessageHandler, WebMessageEvent.TYPE);
  }
}
