// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for ProbeProtocol. */
public final class ProbeProtocol extends ExpandableStringEnum<ProbeProtocol> {
    /** Static value Http for ProbeProtocol. */
    public static final ProbeProtocol HTTP = fromString("Http");

    /** Static value Tcp for ProbeProtocol. */
    public static final ProbeProtocol TCP = fromString("Tcp");

    /** Static value Https for ProbeProtocol. */
    public static final ProbeProtocol HTTPS = fromString("Https");

    /**
     * Creates or finds a ProbeProtocol from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding ProbeProtocol.
     */
    @JsonCreator
    public static ProbeProtocol fromString(String name) {
        return fromString(name, ProbeProtocol.class);
    }

    /** @return known ProbeProtocol values. */
    public static Collection<ProbeProtocol> values() {
        return values(ProbeProtocol.class);
    }
}
