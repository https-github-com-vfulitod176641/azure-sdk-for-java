/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_05_01;

import com.microsoft.azure.Resource;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The parameters specifying the resource whose effective routes are being
 * requested.
 */
public class EffectiveRoutesParameters {
    /**
     * The resource whose effective routes are being requested.
     */
    @JsonProperty(value = "resourceId")
    private Resource resourceId;

    /**
     * The type of the specified resource like RouteTable,
     * ExpressRouteConnection, HubVirtualNetworkConnection, VpnConnection and
     * P2SConnection.
     */
    @JsonProperty(value = "virtualWanResourceType")
    private String virtualWanResourceType;

    /**
     * Get the resource whose effective routes are being requested.
     *
     * @return the resourceId value
     */
    public Resource resourceId() {
        return this.resourceId;
    }

    /**
     * Set the resource whose effective routes are being requested.
     *
     * @param resourceId the resourceId value to set
     * @return the EffectiveRoutesParameters object itself.
     */
    public EffectiveRoutesParameters withResourceId(Resource resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * Get the type of the specified resource like RouteTable, ExpressRouteConnection, HubVirtualNetworkConnection, VpnConnection and P2SConnection.
     *
     * @return the virtualWanResourceType value
     */
    public String virtualWanResourceType() {
        return this.virtualWanResourceType;
    }

    /**
     * Set the type of the specified resource like RouteTable, ExpressRouteConnection, HubVirtualNetworkConnection, VpnConnection and P2SConnection.
     *
     * @param virtualWanResourceType the virtualWanResourceType value to set
     * @return the EffectiveRoutesParameters object itself.
     */
    public EffectiveRoutesParameters withVirtualWanResourceType(String virtualWanResourceType) {
        this.virtualWanResourceType = virtualWanResourceType;
        return this;
    }

}
