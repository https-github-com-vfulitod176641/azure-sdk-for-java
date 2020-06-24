/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * def
 */

package com.microsoft.azure.management.network.v2020_05_01.implementation;

import com.microsoft.azure.arm.resources.collection.implementation.GroupableResourcesCoreImpl;
import com.microsoft.azure.management.network.v2020_05_01.PublicIPPrefixes;
import com.microsoft.azure.management.network.v2020_05_01.PublicIPPrefix;
import rx.Observable;
import rx.Completable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import com.microsoft.azure.arm.resources.ResourceUtilsCore;
import com.microsoft.azure.arm.utils.RXMapper;
import rx.functions.Func1;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.Page;

class PublicIPPrefixesImpl extends GroupableResourcesCoreImpl<PublicIPPrefix, PublicIPPrefixImpl, PublicIPPrefixInner, PublicIPPrefixesInner, NetworkManager>  implements PublicIPPrefixes {
    protected PublicIPPrefixesImpl(NetworkManager manager) {
        super(manager.inner().publicIPPrefixes(), manager);
    }

    @Override
    protected Observable<PublicIPPrefixInner> getInnerAsync(String resourceGroupName, String name) {
        PublicIPPrefixesInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, name);
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        PublicIPPrefixesInner client = this.inner();
        return client.deleteAsync(resourceGroupName, name).toCompletable();
    }

    @Override
    public Observable<String> deleteByIdsAsync(Collection<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Observable.empty();
        }
        Collection<Observable<String>> observables = new ArrayList<>();
        for (String id : ids) {
            final String resourceGroupName = ResourceUtilsCore.groupFromResourceId(id);
            final String name = ResourceUtilsCore.nameFromResourceId(id);
            Observable<String> o = RXMapper.map(this.inner().deleteAsync(resourceGroupName, name), id);
            observables.add(o);
        }
        return Observable.mergeDelayError(observables);
    }

    @Override
    public Observable<String> deleteByIdsAsync(String...ids) {
        return this.deleteByIdsAsync(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public void deleteByIds(Collection<String> ids) {
        if (ids != null && !ids.isEmpty()) {
            this.deleteByIdsAsync(ids).toBlocking().last();
        }
    }

    @Override
    public void deleteByIds(String...ids) {
        this.deleteByIds(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public PagedList<PublicIPPrefix> listByResourceGroup(String resourceGroupName) {
        PublicIPPrefixesInner client = this.inner();
        return this.wrapList(client.listByResourceGroup(resourceGroupName));
    }

    @Override
    public Observable<PublicIPPrefix> listByResourceGroupAsync(String resourceGroupName) {
        PublicIPPrefixesInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMapIterable(new Func1<Page<PublicIPPrefixInner>, Iterable<PublicIPPrefixInner>>() {
            @Override
            public Iterable<PublicIPPrefixInner> call(Page<PublicIPPrefixInner> page) {
                return page.items();
            }
        })
        .map(new Func1<PublicIPPrefixInner, PublicIPPrefix>() {
            @Override
            public PublicIPPrefix call(PublicIPPrefixInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PagedList<PublicIPPrefix> list() {
        PublicIPPrefixesInner client = this.inner();
        return this.wrapList(client.list());
    }

    @Override
    public Observable<PublicIPPrefix> listAsync() {
        PublicIPPrefixesInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<PublicIPPrefixInner>, Iterable<PublicIPPrefixInner>>() {
            @Override
            public Iterable<PublicIPPrefixInner> call(Page<PublicIPPrefixInner> page) {
                return page.items();
            }
        })
        .map(new Func1<PublicIPPrefixInner, PublicIPPrefix>() {
            @Override
            public PublicIPPrefix call(PublicIPPrefixInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PublicIPPrefixImpl define(String name) {
        return wrapModel(name);
    }

    @Override
    protected PublicIPPrefixImpl wrapModel(PublicIPPrefixInner inner) {
        return  new PublicIPPrefixImpl(inner.name(), inner, manager());
    }

    @Override
    protected PublicIPPrefixImpl wrapModel(String name) {
        return new PublicIPPrefixImpl(name, new PublicIPPrefixInner(), this.manager());
    }

}
