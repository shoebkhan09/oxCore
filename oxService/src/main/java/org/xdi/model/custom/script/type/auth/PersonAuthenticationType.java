/*
 * oxCore is available under the MIT License (2008). See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2014, Gluu
 */

package org.xdi.model.custom.script.type.auth;

import java.util.List;
import java.util.Map;

import org.xdi.model.AuthenticationScriptUsageType;
import org.xdi.model.SimpleCustomProperty;
import org.xdi.model.custom.script.type.BaseExternalType;

/**
 * Base interface for external authentication python script
 *
 * @author Yuriy Movchan Date: 08/21/2012
 */
public interface PersonAuthenticationType extends BaseExternalType {

    boolean isValidAuthenticationMethod(AuthenticationScriptUsageType usageType, Map<String, SimpleCustomProperty> configurationAttributes);

    String getAlternativeAuthenticationMethod(AuthenticationScriptUsageType usageType,
            Map<String, SimpleCustomProperty> configurationAttributes);

    boolean authenticate(Map<String, SimpleCustomProperty> configurationAttributes, Map<String, String[]> requestParameters, int step);

    int getNextStep(Map<String, SimpleCustomProperty> configurationAttributes, Map<String, String[]> requestParameters, int step);

    boolean prepareForStep(Map<String, SimpleCustomProperty> configurationAttributes, Map<String, String[]> requestParameters, int step);

    int getCountAuthenticationSteps(Map<String, SimpleCustomProperty> configurationAttributes);

    String getPageForStep(Map<String, SimpleCustomProperty> configurationAttributes, int step);

    List<String> getExtraParametersForStep(Map<String, SimpleCustomProperty> configurationAttributes, int step);

    boolean logout(Map<String, SimpleCustomProperty> configurationAttributes, Map<String, String[]> requestParameters);

    String getLogoutExternalUrl(Map<String, SimpleCustomProperty> configurationAttributes, Map<String, String[]> requestParameters);

    Map<String, String> getAuthenticationMethodClaims();

}
