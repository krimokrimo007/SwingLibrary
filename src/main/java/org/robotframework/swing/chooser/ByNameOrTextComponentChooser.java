/*
 * Copyright 2008-2011 Nokia Siemens Networks Oyj
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.robotframework.swing.chooser;

import java.awt.Component;

import org.netbeans.jemmy.ComponentChooser;

public class ByNameOrTextComponentChooser implements ComponentChooser {
    private ComponentChooser byNameComponentChooser;
    private ComponentChooser byTextComponentChooser;
    private ComponentChooser byTooltipComponentChooser;

    public ByNameOrTextComponentChooser(String expectedNameOrText) {
        byNameComponentChooser = new ByNameComponentChooser(expectedNameOrText);
        byTextComponentChooser = new ByTextComponentChooser(expectedNameOrText);
        byTooltipComponentChooser = new ByTooltipComponentChooser(expectedNameOrText);
    }

    public boolean checkComponent(Component component) {
        return byNameComponentChooser.checkComponent(component)
               || byTextComponentChooser.checkComponent(component)
               || byTooltipComponentChooser.checkComponent(component);
    }

    public String getDescription() {
        return byNameComponentChooser.getDescription();
    }
}
