package com.cdk.spring.config;

import org.springframework.core.io.Resource;

import java.util.Collections;
import java.util.List;

/**
 * This class is used to hold the
 * list of schema resources
 */
public class SchemaResourceHolder {

    @SuppressWarnings("unchecked")
    private List<Resource> schemas = Collections.EMPTY_LIST;

    public SchemaResourceHolder() {
    }

    public SchemaResourceHolder(final List<Resource> schemas) {
        this.schemas = schemas;
    }

    public List<Resource> getSchemas() {
        return schemas;
    }

}
