// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.search.documents.indexes;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.search.documents.SearchClient;
import com.azure.search.documents.indexes.models.AnalyzeTextOptions;
import com.azure.search.documents.indexes.models.AnalyzedTokenInfo;
import com.azure.search.documents.indexes.models.LexicalAnalyzerName;
import com.azure.search.documents.indexes.models.LexicalTokenizerName;
import com.azure.search.documents.indexes.models.SearchIndex;
import com.azure.search.documents.indexes.models.SearchIndexStatistics;
import com.azure.search.documents.indexes.models.SearchServiceStatistics;
import com.azure.search.documents.indexes.models.SynonymMap;

/**
 * Synchronous Client to manage and query indexes, as well as manage Synonym Map, on a Cognitive Search service
 */
@ServiceClient(builder = SearchIndexClientBuilder.class)
public final class SearchIndexClient {
    private final SearchIndexAsyncClient asyncClient;

    SearchIndexClient(SearchIndexAsyncClient searchIndexAsyncClient) {
        this.asyncClient = searchIndexAsyncClient;
    }

    /**
     * Gets the {@link HttpPipeline} powering this client.
     *
     * @return the pipeline.
     */
    HttpPipeline getHttpPipeline() {
        return this.asyncClient.getHttpPipeline();
    }

    /**
     * Gets the endpoint for the Azure Cognitive Search service.
     *
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.asyncClient.getEndpoint();
    }

    /**
     * Initializes a new {@link SearchClient} using the given Index name and the same configuration as the
     * SearchServiceClient.
     *
     * @param indexName the name of the Index for the client
     * @return a {@link SearchClient} created from the service client configuration
     */
    public SearchClient getSearchClient(String indexName) {
        return asyncClient.getSearchClientBuilder(indexName).buildClient();
    }

    /**
     * Creates a new Azure Cognitive Search index
     *
     * @param index definition of the index to create
     * @return the created Index.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SearchIndex createIndex(SearchIndex index) {
        return createIndexWithResponse(index, Context.NONE).getValue();
    }

    /**
     * Creates a new Azure Cognitive Search index
     *
     * @param index definition of the index to create
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return a response containing the created Index.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<SearchIndex> createIndexWithResponse(SearchIndex index, Context context) {
        return asyncClient.createIndexWithResponse(index, context).block();
    }

    /**
     * Retrieves an index definition from the Azure Cognitive Search.
     *
     * @param indexName the name of the index to retrieve
     * @return the Index.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SearchIndex getIndex(String indexName) {
        return getIndexWithResponse(indexName, Context.NONE).getValue();
    }

    /**
     * Retrieves an index definition from the Azure Cognitive Search.
     *
     * @param indexName the name of the index to retrieve
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return a response containing the Index.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<SearchIndex> getIndexWithResponse(String indexName, Context context) {
        return asyncClient.getIndexWithResponse(indexName, context).block();
    }

    /**
     * Returns statistics for the given index, including a document count and storage usage.
     *
     * @param indexName the name of the index for which to retrieve statistics
     * @return the index statistics result.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SearchIndexStatistics getIndexStatistics(String indexName) {
        return getIndexStatisticsWithResponse(indexName, Context.NONE).getValue();
    }

    /**
     * Returns statistics for the given index, including a document count and storage usage.
     *
     * @param indexName the name of the index for which to retrieve statistics
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return a response containing the index statistics result.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<SearchIndexStatistics> getIndexStatisticsWithResponse(String indexName, Context context) {
        return asyncClient.getIndexStatisticsWithResponse(indexName, context).block();
    }

    /**
     * Lists all indexes available for an Azure Cognitive Search service.
     *
     * @return the list of indexes.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<SearchIndex> listIndexes() {
        return listIndexes(Context.NONE);
    }

    /**
     * Lists all indexes available for an Azure Cognitive Search service.
     *
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return the list of indexes.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<SearchIndex> listIndexes(Context context) {
        return new PagedIterable<>(asyncClient.listIndexes(context));
    }

    /**
     * Lists all index names for an Azure Cognitive Search service.
     *
     * @return the list of index names.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<String> listIndexNames() {
        return listIndexNames(Context.NONE);
    }

    /**
     * Lists all indexes names for an Azure Cognitive Search service.
     *
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return the list of index names.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<String> listIndexNames(Context context) {
        return new PagedIterable<>(asyncClient.listIndexNames(context));
    }

    /**
     * Creates a new Azure Cognitive Search index or updates an index if it already exists.
     *
     * @param index the definition of the index to create or update
     * @return the index that was created or updated.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SearchIndex createOrUpdateIndex(SearchIndex index) {
        return createOrUpdateIndexWithResponse(index, false, false, Context.NONE).getValue();
    }

    /**
     * Creates a new Azure Cognitive Search index or updates an index if it already exists.
     *
     * @param index the {@link SearchIndex} to create or update
     * @param allowIndexDowntime allows new analyzers, tokenizers, token filters, or char filters to be added to an
     * index by taking the index offline for at least a few seconds. This temporarily causes indexing and query requests
     * to fail. Performance and write availability of the index can be impaired for several minutes after the index is
     * updated, or longer for very large indexes.
     * @param onlyIfUnchanged {@code true} to update if the {@code index} is the same as the current service value.
     * {@code false} to always update existing value.
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return a response containing the Index that was created or updated.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<SearchIndex> createOrUpdateIndexWithResponse(SearchIndex index, boolean allowIndexDowntime,
        boolean onlyIfUnchanged, Context context) {
        return asyncClient.createOrUpdateIndexWithResponse(index, allowIndexDowntime, onlyIfUnchanged, context).block();
    }

    /**
     * Deletes an Azure Cognitive Search index and all the documents it contains.
     *
     * @param indexName the name of the index to delete
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void deleteIndex(String indexName) {
        deleteIndexWithResponse(new SearchIndex(indexName), false, Context.NONE);
    }

    /**
     * Deletes an Azure Cognitive Search index and all the documents it contains.
     *
     * @param index the Search {@link SearchIndex} to delete.
     * @param onlyIfUnchanged {@code true} to delete if the {@code index} is the same as the current service value.
     * {@code false} to always delete existing value.
     * @param context additional context that is passed through the Http pipeline during the service call
     * @return a response signalling completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> deleteIndexWithResponse(SearchIndex index, boolean onlyIfUnchanged, Context context) {
        String etag = onlyIfUnchanged ? index.getETag() : null;
        return asyncClient.deleteIndexWithResponse(index.getName(), etag, context).block();
    }

    /**
     * Shows how an analyzer breaks text into tokens.
     *
     * @param indexName the name of the index for which to test an analyzer
     * @param analyzeTextOptions the text and analyzer or analysis components to test. Requires to provide either {@link
     * LexicalTokenizerName} or {@link LexicalAnalyzerName}.
     * @return analyze result.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<AnalyzedTokenInfo> analyzeText(String indexName, AnalyzeTextOptions analyzeTextOptions) {
        return analyzeText(indexName, analyzeTextOptions, Context.NONE);
    }

    /**
     * Shows how an analyzer breaks text into tokens.
     *
     * @param indexName the name of the index for which to test an analyzer
     * @param analyzeTextOptions the text and analyzer or analysis components to test. Requires to provide either {@link
     * LexicalTokenizerName} or {@link LexicalAnalyzerName}.
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return analyze result.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<AnalyzedTokenInfo> analyzeText(String indexName, AnalyzeTextOptions analyzeTextOptions,
        Context context) {
        return new PagedIterable<>(asyncClient.analyzeText(indexName, analyzeTextOptions, context));
    }

    /**
     * Creates a new Azure Cognitive Search synonym map.
     *
     * @param synonymMap the definition of the synonym map to create
     * @return the created {@link SynonymMap}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SynonymMap createSynonymMap(SynonymMap synonymMap) {
        return createSynonymMapWithResponse(synonymMap, Context.NONE).getValue();
    }

    /**
     * Creates a new Azure Cognitive Search synonym map.
     *
     * @param synonymMap the definition of the synonym map to create
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return a response containing the created SynonymMap.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<SynonymMap> createSynonymMapWithResponse(SynonymMap synonymMap, Context context) {
        return asyncClient.createSynonymMapWithResponse(synonymMap, context).block();
    }

    /**
     * Retrieves a synonym map definition.
     *
     * @param synonymMapName name of the synonym map to retrieve
     * @return the {@link SynonymMap} definition
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SynonymMap getSynonymMap(String synonymMapName) {
        return getSynonymMapWithResponse(synonymMapName, Context.NONE).getValue();
    }

    /**
     * Retrieves a synonym map definition.
     *
     * @param synonymMapName name of the synonym map to retrieve
     * @param context a context that is passed through the HTTP pipeline during the service call
     * @return a response containing the SynonymMap.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<SynonymMap> getSynonymMapWithResponse(String synonymMapName, Context context) {
        return asyncClient.getSynonymMapWithResponse(synonymMapName, context).block();
    }

    /**
     * Lists all synonym maps available for an Azure Cognitive Search service.
     *
     * @return the list of synonym maps.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<SynonymMap> listSynonymMaps() {
        return listSynonymMaps(Context.NONE);
    }

    /**
     * Lists all synonym maps available for an Azure Cognitive Search service.
     *
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return the list of synonym map names.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<SynonymMap> listSynonymMaps(Context context) {
        return new PagedIterable<>(asyncClient.listSynonymMaps(context));
    }

    /**
     * Lists all synonym maps names for an Azure Cognitive Search service.
     *
     * @return the list of synonym maps.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<String> listSynonymMapNames() {
        return listSynonymMapNames(Context.NONE);
    }

    /**
     * Lists all synonym maps names for an Azure Cognitive Search service.
     *
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return the list of synonym map names.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<String> listSynonymMapNames(Context context) {
        return new PagedIterable<>(asyncClient.listSynonymMapNames(context));
    }

    /**
     * Creates a new Azure Cognitive Search synonym map or updates a synonym map if it already exists.
     *
     * @param synonymMap the definition of the synonym map to create or update
     * @return the synonym map that was created or updated.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SynonymMap createOrUpdateSynonymMap(SynonymMap synonymMap) {
        return createOrUpdateSynonymMapWithResponse(synonymMap, false, Context.NONE).getValue();
    }

    /**
     * Creates a new Azure Cognitive Search synonym map or updates a synonym map if it already exists.
     *
     * @param synonymMap the definition of the synonym map to create or update
     * @param onlyIfUnchanged {@code true} to update if the {@code synonymMap} is the same as the current service value.
     * {@code false} to always update existing value.
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return a response containing the synonym map that was created or updated.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<SynonymMap> createOrUpdateSynonymMapWithResponse(SynonymMap synonymMap,
        boolean onlyIfUnchanged, Context context) {
        return asyncClient.createOrUpdateSynonymMapWithResponse(synonymMap, onlyIfUnchanged, context)
            .block();
    }

    /**
     * Deletes an Azure Cognitive Search synonym map.
     *
     * @param synonymMapName the name of the synonym map to delete
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void deleteSynonymMap(String synonymMapName) {
        deleteSynonymMapWithResponse(new SynonymMap(synonymMapName), false, Context.NONE);
    }

    /**
     * Deletes an Azure Cognitive Search synonym map.
     *
     * @param synonymMap the {@link SynonymMap} to delete.
     * @param onlyIfUnchanged {@code true} to delete if the {@code synonymMap} is the same as the current service value.
     * {@code false} to always delete existing value.
     * @param context additional context that is passed through the Http pipeline during the service call
     * @return a response signalling completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> deleteSynonymMapWithResponse(SynonymMap synonymMap, boolean onlyIfUnchanged,
        Context context) {
        String etag = onlyIfUnchanged ? synonymMap.getETag() : null;
        return asyncClient.deleteSynonymMapWithResponse(synonymMap.getName(), etag, context).block();
    }

    /**
     * Returns service level statistics for a search service, including service counters and limits.
     *
     * @return the search service statistics result.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SearchServiceStatistics getServiceStatistics() {
        return getServiceStatisticsWithResponse(Context.NONE).getValue();
    }

    /**
     * Returns service level statistics for a search service, including service counters and limits.
     *
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return the search service statistics result.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<SearchServiceStatistics> getServiceStatisticsWithResponse(Context context) {
        return asyncClient.getServiceStatisticsWithResponse(context).block();
    }
}
