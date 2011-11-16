/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.gwt.event.signal.shared

import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.mockito.ArgumentCaptor
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers
import org.scalatest.mock.MockitoSugar
import org.scalatest.GivenWhenThen
import org.scalatest.Spec

import com.google.gwt.event.shared.EventBus
import com.google.gwt.event.shared.GwtEvent

/**
 * Signal Specification.
 * <p>
 * Created: 16th November 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
@RunWith(classOf[JUnitRunner])
class SignalSpec extends Spec
  with GivenWhenThen
  with MustMatchers
  with MockitoSugar {
  
  describe("A Signal") {
    it("should fire a SignalEvent when raised on an EventBus") {
      given("a Signal and an EventBus")
      val signal = new Signal("TestSignal")
      val eventBus = mock[EventBus]
      
      when("the Signal is raised on the EventBus")
      signal.raise(eventBus)
      
      then("a SignalEvent is fired on the EventBus")
      val argument = ArgumentCaptor.forClass(classOf[GwtEvent[_]])
      
      verify(eventBus).fireEvent(argument.capture())
      
      argument.getValue().isInstanceOf[SignalEvent] must be (true)
      
      and("the SignalEvent contains the Signal")
      argument.getValue().asInstanceOf[SignalEvent].getSignal() must be theSameInstanceAs (signal)
    }
  }
}
