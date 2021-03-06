/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.apimanagement.v2019_12_01.implementation;

import com.microsoft.azure.management.apimanagement.v2019_12_01.DiagnosticContract;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.apimanagement.v2019_12_01.AlwaysLog;
import com.microsoft.azure.management.apimanagement.v2019_12_01.SamplingSettings;
import com.microsoft.azure.management.apimanagement.v2019_12_01.PipelineDiagnosticSettings;
import com.microsoft.azure.management.apimanagement.v2019_12_01.HttpCorrelationProtocol;
import com.microsoft.azure.management.apimanagement.v2019_12_01.Verbosity;

class DiagnosticContractImpl extends CreatableUpdatableImpl<DiagnosticContract, DiagnosticContractInner, DiagnosticContractImpl> implements DiagnosticContract, DiagnosticContract.Definition, DiagnosticContract.Update {
    private String resourceGroupName;
    private String serviceName;
    private String diagnosticId;
    private String cifMatch;
    private String uifMatch;
    private final ApiManagementManager manager;

    DiagnosticContractImpl(String name, ApiManagementManager manager) {
        super(name, new DiagnosticContractInner());
        this.manager = manager;
        // Set resource name
        this.diagnosticId = name;
        //
    }

    DiagnosticContractImpl(DiagnosticContractInner inner, ApiManagementManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.diagnosticId = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.serviceName = IdParsingUtils.getValueFromIdByName(inner.id(), "service");
        this.diagnosticId = IdParsingUtils.getValueFromIdByName(inner.id(), "diagnostics");
        // set other parameters for create and update
    }

    @Override
    public ApiManagementManager manager() {
        return this.manager;
    }

    @Override
    public Observable<DiagnosticContract> createResourceAsync() {
        DiagnosticsInner client = this.manager().inner().diagnostics();
        return client.createOrUpdateAsync(this.resourceGroupName, this.serviceName, this.diagnosticId, this.inner(), this.cifMatch)
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<DiagnosticContract> updateResourceAsync() {
        DiagnosticsInner client = this.manager().inner().diagnostics();
        return client.createOrUpdateAsync(this.resourceGroupName, this.serviceName, this.diagnosticId, this.inner(), this.uifMatch)
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<DiagnosticContractInner> getInnerAsync() {
        DiagnosticsInner client = this.manager().inner().diagnostics();
        return null; // NOP getInnerAsync implementation as get is not supported
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }


    @Override
    public AlwaysLog alwaysLog() {
        return this.inner().alwaysLog();
    }

    @Override
    public PipelineDiagnosticSettings backend() {
        return this.inner().backend();
    }

    @Override
    public PipelineDiagnosticSettings frontend() {
        return this.inner().frontend();
    }

    @Override
    public HttpCorrelationProtocol httpCorrelationProtocol() {
        return this.inner().httpCorrelationProtocol();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public Boolean logClientIp() {
        return this.inner().logClientIp();
    }

    @Override
    public String loggerId() {
        return this.inner().loggerId();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public SamplingSettings sampling() {
        return this.inner().sampling();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public Verbosity verbosity() {
        return this.inner().verbosity();
    }

    @Override
    public DiagnosticContractImpl withResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    @Override
    public DiagnosticContractImpl withServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    @Override
    public DiagnosticContractImpl withLoggerId(String loggerId) {
        this.inner().withLoggerId(loggerId);
        return this;
    }

    @Override
    public DiagnosticContractImpl withIfMatch(String ifMatch) {
        if (isInCreateMode()) {
            this.cifMatch = ifMatch;
        } else {
            this.uifMatch = ifMatch;
        }
        return this;
    }

    @Override
    public DiagnosticContractImpl withAlwaysLog(AlwaysLog alwaysLog) {
        this.inner().withAlwaysLog(alwaysLog);
        return this;
    }

    @Override
    public DiagnosticContractImpl withBackend(PipelineDiagnosticSettings backend) {
        this.inner().withBackend(backend);
        return this;
    }

    @Override
    public DiagnosticContractImpl withFrontend(PipelineDiagnosticSettings frontend) {
        this.inner().withFrontend(frontend);
        return this;
    }

    @Override
    public DiagnosticContractImpl withHttpCorrelationProtocol(HttpCorrelationProtocol httpCorrelationProtocol) {
        this.inner().withHttpCorrelationProtocol(httpCorrelationProtocol);
        return this;
    }

    @Override
    public DiagnosticContractImpl withLogClientIp(Boolean logClientIp) {
        this.inner().withLogClientIp(logClientIp);
        return this;
    }

    @Override
    public DiagnosticContractImpl withSampling(SamplingSettings sampling) {
        this.inner().withSampling(sampling);
        return this;
    }

    @Override
    public DiagnosticContractImpl withVerbosity(Verbosity verbosity) {
        this.inner().withVerbosity(verbosity);
        return this;
    }

}
