/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.ui;

import org.kjots.lib.gwt.event.webMessage.client.HasWebMessageHandlers;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageEvent;
import org.kjots.lib.gwt.event.webMessage.client.WebMessageHandler;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Frame.
 * <p>
 * Drop in replacement for GWT's {@link com.google.gwt.user.client.ui.Frame Frame}
 * with support for web message events.
 * <p>
 * Created: 4th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 * @see com.google.gwt.user.client.ui.Frame
 */
public class Frame extends com.google.gwt.user.client.ui.Frame implements HasWebMessageHandlers {
  /**
   * @see com.google.gwt.user.client.ui.Frame#wrap(Element)
   */
  public static Frame wrap(Element element) {
    // Assert that the element is attached.
    assert Document.get().getBody().isOrHasChild(element);

    Frame frame = new Frame(element);

    // Mark it attached and remember it for cleanup.
    frame.onAttach();
    RootPanel.detachOnWindowClose(frame);

    return frame;
  }
  
  /**
   * Construct a new Frame.
   * 
   * @see com.google.gwt.user.client.ui.Frame#Frame()
   */
  public Frame() {
    super();
    
    WebMessageEvent.bridge(this);
  }

  /**
   * Construct a new Frame.
   *
   * @param url The URL.
   * @see com.google.gwt.user.client.ui.Frame#Frame(String)
   */
  public Frame(String url) {
    super(url);
    
    WebMessageEvent.bridge(this);
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
  
  /**
   * Construct a new Frame.
   *
   * @param element The element.
   * @see com.google.gwt.user.client.ui.Frame#Frame(Element)
   */
  protected Frame(Element element) {
    super(element);
    
    WebMessageEvent.bridge(this);
  }
}
