/* 
 * Copyright © 2011 Karl J. Ots <kjots@kjots.org>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kjots.lib.gwt.app.client.activity;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Application Activity Manager.
 * <p>
 * Created: 27th December 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
@Singleton
public class ApplicationActivityManager extends ActivityManager {
  /**
   * Construct a new Application Activity Manager.
   *
   * @param activityMapper The activity mapper.
   * @param eventBus The event bus.
   */
  @Inject
  public ApplicationActivityManager(ActivityMapper activityMapper, EventBus eventBus) {
    super(activityMapper, eventBus);
    
    this.setDisplay(new AcceptsOneWidget() {
      @Override
      public void setWidget(IsWidget w) {
        RootPanel rootPanel = RootPanel.get();
        
        rootPanel.clear();
        rootPanel.add(w.asWidget());
      }
    });
  }
}
