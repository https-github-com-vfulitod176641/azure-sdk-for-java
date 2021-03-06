/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlabs.v2018_09_15;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.devtestlabs.v2018_09_15.implementation.ServiceRunnerInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.devtestlabs.v2018_09_15.implementation.DevTestLabsManager;
import java.util.Map;

/**
 * Type representing ServiceRunner.
 */
public interface ServiceRunner extends HasInner<ServiceRunnerInner>, Indexable, Refreshable<ServiceRunner>, Updatable<ServiceRunner.Update>, HasManager<DevTestLabsManager> {
    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the identity value.
     */
    IdentityProperties identity();

    /**
     * @return the location value.
     */
    String location();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * @return the type value.
     */
    String type();

    /**
     * The entirety of the ServiceRunner definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithLab, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of ServiceRunner definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a ServiceRunner definition.
         */
        interface Blank extends WithLab {
        }

        /**
         * The stage of the servicerunner definition allowing to specify Lab.
         */
        interface WithLab {
           /**
            * Specifies resourceGroupName, labName.
            * @param resourceGroupName The name of the resource group
            * @param labName The name of the lab
            * @return the next definition stage
            */
            WithCreate withExistingLab(String resourceGroupName, String labName);
        }

        /**
         * The stage of the servicerunner definition allowing to specify Identity.
         */
        interface WithIdentity {
            /**
             * Specifies identity.
             * @param identity The identity of the resource
             * @return the next definition stage
             */
            WithCreate withIdentity(IdentityProperties identity);
        }

        /**
         * The stage of the servicerunner definition allowing to specify Location.
         */
        interface WithLocation {
            /**
             * Specifies location.
             * @param location The location of the resource
             * @return the next definition stage
             */
            WithCreate withLocation(String location);
        }

        /**
         * The stage of the servicerunner definition allowing to specify Tags.
         */
        interface WithTags {
            /**
             * Specifies tags.
             * @param tags The tags of the resource
             * @return the next definition stage
             */
            WithCreate withTags(Map<String, String> tags);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<ServiceRunner>, DefinitionStages.WithIdentity, DefinitionStages.WithLocation, DefinitionStages.WithTags {
        }
    }
    /**
     * The template for a ServiceRunner update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<ServiceRunner>, UpdateStages.WithIdentity, UpdateStages.WithLocation, UpdateStages.WithTags {
    }

    /**
     * Grouping of ServiceRunner update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the servicerunner update allowing to specify Identity.
         */
        interface WithIdentity {
            /**
             * Specifies identity.
             * @param identity The identity of the resource
             * @return the next update stage
             */
            Update withIdentity(IdentityProperties identity);
        }

        /**
         * The stage of the servicerunner update allowing to specify Location.
         */
        interface WithLocation {
            /**
             * Specifies location.
             * @param location The location of the resource
             * @return the next update stage
             */
            Update withLocation(String location);
        }

        /**
         * The stage of the servicerunner update allowing to specify Tags.
         */
        interface WithTags {
            /**
             * Specifies tags.
             * @param tags The tags of the resource
             * @return the next update stage
             */
            Update withTags(Map<String, String> tags);
        }

    }
}
