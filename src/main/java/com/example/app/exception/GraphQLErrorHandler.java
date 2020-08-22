package com.example.app.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class GraphQLErrorHandler extends RuntimeException implements GraphQLError {

    public GraphQLErrorHandler(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }
}
