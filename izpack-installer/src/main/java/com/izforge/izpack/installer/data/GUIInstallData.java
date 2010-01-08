/*
 * IzPack - Copyright 2001-2008 Julien Ponge, All Rights Reserved.
 * 
 * http://izpack.org/
 * http://izpack.codehaus.org/
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

package com.izforge.izpack.installer.data;

import com.izforge.izpack.data.AutomatedInstallData;
import com.izforge.izpack.data.GUIPrefs;
import com.izforge.izpack.data.Panel;
import com.izforge.izpack.util.substitutor.VariableSubstitutor;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Properties;

/**
 * Encloses information about the install process. This class is implemented as a singleton which
 * can be easily accessed by different components of the installer. However, this implementation is
 * not thread safe.
 *
 * @author Julien Ponge <julien@izforge.com>
 * @author Johannes Lehtinen <johannes.lehtinen@iki.fi>
 */
public class GUIInstallData extends AutomatedInstallData implements Serializable {

    private static final long serialVersionUID = 4048793450990024505L;

    /**
     * The GUI preferences.
     */
    public GUIPrefs guiPrefs;

    /**
     * Contains at IzPanel constructor call the related Panel object. This is a hack
     * to allow usage of the meta data stored in the Panel object during construction of
     * the IzPanel. Do not use this member at an other place.
     */
    public Panel currentPanel;

    /**
     * The buttons highlighting color.
     */
    public Color buttonsHColor = new Color(230, 230, 230);

    public GUIInstallData(Properties variables, VariableSubstitutor variableSubstitutor) {
        super(variables, variableSubstitutor);
    }

    public void configureGuiButtons() {
        UIManager.put("OptionPane.yesButtonText", getLangpack().getString("installer.yes"));
        UIManager.put("OptionPane.noButtonText", getLangpack().getString("installer.no"));
        UIManager.put("OptionPane.cancelButtonText", getLangpack()
                .getString("installer.cancel"));
    }
}
