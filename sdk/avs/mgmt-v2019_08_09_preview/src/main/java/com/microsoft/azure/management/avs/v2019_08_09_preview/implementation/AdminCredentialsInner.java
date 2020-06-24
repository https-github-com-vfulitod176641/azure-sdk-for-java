/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.avs.v2019_08_09_preview.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Administrative credentials for accessing vCenter and NSX-T.
 */
public class AdminCredentialsInner {
    /**
     * NSX-T Manager username.
     */
    @JsonProperty(value = "nsxtUsername", access = JsonProperty.Access.WRITE_ONLY)
    private String nsxtUsername;

    /**
     * NSX-T Manager password.
     */
    @JsonProperty(value = "nsxtPassword", access = JsonProperty.Access.WRITE_ONLY)
    private String nsxtPassword;

    /**
     * vCenter admin username.
     */
    @JsonProperty(value = "vcenterUsername", access = JsonProperty.Access.WRITE_ONLY)
    private String vcenterUsername;

    /**
     * vCenter admin password.
     */
    @JsonProperty(value = "vcenterPassword", access = JsonProperty.Access.WRITE_ONLY)
    private String vcenterPassword;

    /**
     * Get nSX-T Manager username.
     *
     * @return the nsxtUsername value
     */
    public String nsxtUsername() {
        return this.nsxtUsername;
    }

    /**
     * Get nSX-T Manager password.
     *
     * @return the nsxtPassword value
     */
    public String nsxtPassword() {
        return this.nsxtPassword;
    }

    /**
     * Get vCenter admin username.
     *
     * @return the vcenterUsername value
     */
    public String vcenterUsername() {
        return this.vcenterUsername;
    }

    /**
     * Get vCenter admin password.
     *
     * @return the vcenterPassword value
     */
    public String vcenterPassword() {
        return this.vcenterPassword;
    }

}
