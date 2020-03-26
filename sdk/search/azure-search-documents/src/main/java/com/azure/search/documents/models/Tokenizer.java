// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.documents.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Base type for tokenizers.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata.type", defaultImpl = Tokenizer.class)
@JsonTypeName("Tokenizer")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "#Microsoft.Azure.Search.ClassicTokenizer", value = ClassicTokenizer.class),
    @JsonSubTypes.Type(name = "#Microsoft.Azure.Search.EdgeNGramTokenizer", value = EdgeNGramTokenizer.class),
    @JsonSubTypes.Type(name = "#Microsoft.Azure.Search.KeywordTokenizer", value = KeywordTokenizer.class),
    @JsonSubTypes.Type(name = "#Microsoft.Azure.Search.KeywordTokenizerV2", value = KeywordTokenizerV2.class),
    @JsonSubTypes.Type(name = "#Microsoft.Azure.Search.MicrosoftLanguageTokenizer", value = MicrosoftLanguageTokenizer.class),
    @JsonSubTypes.Type(name = "#Microsoft.Azure.Search.MicrosoftLanguageStemmingTokenizer", value = MicrosoftLanguageStemmingTokenizer.class),
    @JsonSubTypes.Type(name = "#Microsoft.Azure.Search.NGramTokenizer", value = NGramTokenizer.class),
    @JsonSubTypes.Type(name = "#Microsoft.Azure.Search.PathHierarchyTokenizerV2", value = PathHierarchyTokenizerV2.class),
    @JsonSubTypes.Type(name = "#Microsoft.Azure.Search.PatternTokenizer", value = PatternTokenizer.class),
    @JsonSubTypes.Type(name = "#Microsoft.Azure.Search.StandardTokenizer", value = StandardTokenizer.class),
    @JsonSubTypes.Type(name = "#Microsoft.Azure.Search.StandardTokenizerV2", value = StandardTokenizerV2.class),
    @JsonSubTypes.Type(name = "#Microsoft.Azure.Search.UaxUrlEmailTokenizer", value = UaxUrlEmailTokenizer.class)
})
@Fluent
public abstract class Tokenizer {
    /*
     * The name of the tokenizer. It must only contain letters, digits, spaces,
     * dashes or underscores, can only start and end with alphanumeric
     * characters, and is limited to 128 characters.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * Get the name property: The name of the tokenizer. It must only contain
     * letters, digits, spaces, dashes or underscores, can only start and end
     * with alphanumeric characters, and is limited to 128 characters.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: The name of the tokenizer. It must only contain
     * letters, digits, spaces, dashes or underscores, can only start and end
     * with alphanumeric characters, and is limited to 128 characters.
     *
     * @param name the name value to set.
     * @return the Tokenizer object itself.
     */
    public Tokenizer setName(String name) {
        this.name = name;
        return this;
    }
}
