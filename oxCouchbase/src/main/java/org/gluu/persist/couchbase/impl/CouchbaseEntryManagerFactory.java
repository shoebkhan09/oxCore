/*
 /*
 * oxCore is available under the MIT License (2008). See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2018, Gluu
 */

package org.gluu.persist.couchbase.impl;

import java.util.Properties;

import org.gluu.persist.PersistenceEntryManagerFactory;
import org.gluu.persist.couchbase.operation.impl.CouchbaseConnectionProvider;
import org.gluu.persist.couchbase.operation.impl.CouchbaseOperationsServiceImpl;
import org.gluu.persist.exception.operation.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Couchbase Entry Manager Factory
 *
 * @author Yuriy Movchan Date: 05/31/2018
 */
public class CouchbaseEntryManagerFactory implements PersistenceEntryManagerFactory {

    private static final Logger LOG = LoggerFactory.getLogger(CouchbaseEntryManagerFactory.class);

    @Override
    public CouchbaseEntryManager createEntryManager(Properties conf) {
        CouchbaseConnectionProvider connectionProvider = new CouchbaseConnectionProvider(conf);
        connectionProvider.create();
        if (!connectionProvider.isCreated()) {
            throw new ConfigurationException(
                    String.format("Failed to create Couchbase connection pool! Result code: '%s'", connectionProvider.getCreationResultCode()));
        }
        LOG.debug("Created connectionProvider '{}' with code '{}'", connectionProvider, connectionProvider.getCreationResultCode());

        CouchbaseEntryManager CouchbaseEntryManager = new CouchbaseEntryManager(new CouchbaseOperationsServiceImpl(connectionProvider));
        LOG.info("Created CouchbaseEntryManager: {}", CouchbaseEntryManager.getOperationService());

        return CouchbaseEntryManager;
    }
}
