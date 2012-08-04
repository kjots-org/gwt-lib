/* 
 * Copyright © 2012 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.webMessage.client.request;

/**
 * Response Handler.
 * <p>
 * Created: 4th August 2012.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.1
 */
public interface ResponseHandler {
  /**
   * Handle the given response to the given request.
   *
   * @param request The request.
   * @param response The response.
   */
  public void onResponse(Request request, Response response);
}
