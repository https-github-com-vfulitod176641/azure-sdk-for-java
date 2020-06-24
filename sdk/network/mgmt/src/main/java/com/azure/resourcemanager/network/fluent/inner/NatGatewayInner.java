// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent.inner;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.management.Resource;
import com.azure.core.management.SubResource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.network.models.NatGatewaySku;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The NatGateway model. */
@JsonFlatten
@Fluent
public class NatGatewayInner extends Resource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(NatGatewayInner.class);

    /*
     * The nat gateway SKU.
     */
    @JsonProperty(value = "sku")
    private NatGatewaySku sku;

    /*
     * A list of availability zones denoting the zone in which Nat Gateway
     * should be deployed.
     */
    @JsonProperty(value = "zones")
    private List<String> zones;

    /*
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag")
    private String etag;

    /*
     * The idle timeout of the nat gateway.
     */
    @JsonProperty(value = "properties.idleTimeoutInMinutes")
    private Integer idleTimeoutInMinutes;

    /*
     * An array of public ip addresses associated with the nat gateway
     * resource.
     */
    @JsonProperty(value = "properties.publicIpAddresses")
    private List<SubResource> publicIpAddresses;

    /*
     * An array of public ip prefixes associated with the nat gateway resource.
     */
    @JsonProperty(value = "properties.publicIpPrefixes")
    private List<SubResource> publicIpPrefixes;

    /*
     * An array of references to the subnets using this nat gateway resource.
     */
    @JsonProperty(value = "properties.subnets", access = JsonProperty.Access.WRITE_ONLY)
    private List<SubResource> subnets;

    /*
     * The resource GUID property of the nat gateway resource.
     */
    @JsonProperty(value = "properties.resourceGuid")
    private String resourceGuid;

    /*
     * The provisioning state of the NatGateway resource. Possible values are:
     * 'Updating', 'Deleting', and 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState")
    private String provisioningState;

    /*
     * Resource ID.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Get the sku property: The nat gateway SKU.
     *
     * @return the sku value.
     */
    public NatGatewaySku sku() {
        return this.sku;
    }

    /**
     * Set the sku property: The nat gateway SKU.
     *
     * @param sku the sku value to set.
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withSku(NatGatewaySku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the zones property: A list of availability zones denoting the zone in which Nat Gateway should be deployed.
     *
     * @return the zones value.
     */
    public List<String> zones() {
        return this.zones;
    }

    /**
     * Set the zones property: A list of availability zones denoting the zone in which Nat Gateway should be deployed.
     *
     * @param zones the zones value to set.
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withZones(List<String> zones) {
        this.zones = zones;
        return this;
    }

    /**
     * Get the etag property: A unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Set the etag property: A unique read-only string that changes whenever the resource is updated.
     *
     * @param etag the etag value to set.
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Get the idleTimeoutInMinutes property: The idle timeout of the nat gateway.
     *
     * @return the idleTimeoutInMinutes value.
     */
    public Integer idleTimeoutInMinutes() {
        return this.idleTimeoutInMinutes;
    }

    /**
     * Set the idleTimeoutInMinutes property: The idle timeout of the nat gateway.
     *
     * @param idleTimeoutInMinutes the idleTimeoutInMinutes value to set.
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withIdleTimeoutInMinutes(Integer idleTimeoutInMinutes) {
        this.idleTimeoutInMinutes = idleTimeoutInMinutes;
        return this;
    }

    /**
     * Get the publicIpAddresses property: An array of public ip addresses associated with the nat gateway resource.
     *
     * @return the publicIpAddresses value.
     */
    public List<SubResource> publicIpAddresses() {
        return this.publicIpAddresses;
    }

    /**
     * Set the publicIpAddresses property: An array of public ip addresses associated with the nat gateway resource.
     *
     * @param publicIpAddresses the publicIpAddresses value to set.
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withPublicIpAddresses(List<SubResource> publicIpAddresses) {
        this.publicIpAddresses = publicIpAddresses;
        return this;
    }

    /**
     * Get the publicIpPrefixes property: An array of public ip prefixes associated with the nat gateway resource.
     *
     * @return the publicIpPrefixes value.
     */
    public List<SubResource> publicIpPrefixes() {
        return this.publicIpPrefixes;
    }

    /**
     * Set the publicIpPrefixes property: An array of public ip prefixes associated with the nat gateway resource.
     *
     * @param publicIpPrefixes the publicIpPrefixes value to set.
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withPublicIpPrefixes(List<SubResource> publicIpPrefixes) {
        this.publicIpPrefixes = publicIpPrefixes;
        return this;
    }

    /**
     * Get the subnets property: An array of references to the subnets using this nat gateway resource.
     *
     * @return the subnets value.
     */
    public List<SubResource> subnets() {
        return this.subnets;
    }

    /**
     * Get the resourceGuid property: The resource GUID property of the nat gateway resource.
     *
     * @return the resourceGuid value.
     */
    public String resourceGuid() {
        return this.resourceGuid;
    }

    /**
     * Set the resourceGuid property: The resource GUID property of the nat gateway resource.
     *
     * @param resourceGuid the resourceGuid value to set.
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withResourceGuid(String resourceGuid) {
        this.resourceGuid = resourceGuid;
        return this;
    }

    /**
     * Get the provisioningState property: The provisioning state of the NatGateway resource. Possible values are:
     * 'Updating', 'Deleting', and 'Failed'.
     *
     * @return the provisioningState value.
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Set the provisioningState property: The provisioning state of the NatGateway resource. Possible values are:
     * 'Updating', 'Deleting', and 'Failed'.
     *
     * @param provisioningState the provisioningState value to set.
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
        return this;
    }

    /**
     * Get the id property: Resource ID.
     *
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: Resource ID.
     *
     * @param id the id value to set.
     * @return the NatGatewayInner object itself.
     */
    public NatGatewayInner withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (sku() != null) {
            sku().validate();
        }
    }
}
