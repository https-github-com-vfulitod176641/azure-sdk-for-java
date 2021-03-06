/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2018_06_01.implementation;

import com.microsoft.azure.SubResource;
import java.util.List;
import com.microsoft.azure.management.network.v2018_06_01.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * VirtualHub Resource.
 */
@JsonFlatten
@SkipParentValidation
public class VirtualHubInner extends Resource {
    /**
     * The VirtualWAN to which the VirtualHub belongs.
     */
    @JsonProperty(value = "properties.virtualWan")
    private SubResource virtualWan;

    /**
     * list of all vnet connections with this VirtualHub.
     */
    @JsonProperty(value = "properties.hubVirtualNetworkConnections")
    private List<HubVirtualNetworkConnectionInner> hubVirtualNetworkConnections;

    /**
     * Address-prefix for this VirtualHub.
     */
    @JsonProperty(value = "properties.addressPrefix")
    private String addressPrefix;

    /**
     * The provisioning state of the resource. Possible values include:
     * 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState")
    private ProvisioningState provisioningState;

    /**
     * Gets a unique read-only string that changes whenever the resource is
     * updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * Resource ID.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Get the VirtualWAN to which the VirtualHub belongs.
     *
     * @return the virtualWan value
     */
    public SubResource virtualWan() {
        return this.virtualWan;
    }

    /**
     * Set the VirtualWAN to which the VirtualHub belongs.
     *
     * @param virtualWan the virtualWan value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withVirtualWan(SubResource virtualWan) {
        this.virtualWan = virtualWan;
        return this;
    }

    /**
     * Get list of all vnet connections with this VirtualHub.
     *
     * @return the hubVirtualNetworkConnections value
     */
    public List<HubVirtualNetworkConnectionInner> hubVirtualNetworkConnections() {
        return this.hubVirtualNetworkConnections;
    }

    /**
     * Set list of all vnet connections with this VirtualHub.
     *
     * @param hubVirtualNetworkConnections the hubVirtualNetworkConnections value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withHubVirtualNetworkConnections(List<HubVirtualNetworkConnectionInner> hubVirtualNetworkConnections) {
        this.hubVirtualNetworkConnections = hubVirtualNetworkConnections;
        return this;
    }

    /**
     * Get address-prefix for this VirtualHub.
     *
     * @return the addressPrefix value
     */
    public String addressPrefix() {
        return this.addressPrefix;
    }

    /**
     * Set address-prefix for this VirtualHub.
     *
     * @param addressPrefix the addressPrefix value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withAddressPrefix(String addressPrefix) {
        this.addressPrefix = addressPrefix;
        return this;
    }

    /**
     * Get the provisioning state of the resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Set the provisioning state of the resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @param provisioningState the provisioningState value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withProvisioningState(ProvisioningState provisioningState) {
        this.provisioningState = provisioningState;
        return this;
    }

    /**
     * Get gets a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get resource ID.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set resource ID.
     *
     * @param id the id value to set
     * @return the VirtualHubInner object itself.
     */
    public VirtualHubInner withId(String id) {
        this.id = id;
        return this;
    }

}
