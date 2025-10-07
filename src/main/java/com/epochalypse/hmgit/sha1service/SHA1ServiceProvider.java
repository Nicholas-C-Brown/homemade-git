package com.epochalypse.hmgit.sha1service;

import javax.annotation.Nonnull;

public class SHA1ServiceProvider {

    private static SHA1Service instance;

    private SHA1ServiceProvider() {
        throw new UnsupportedOperationException( "Provider class should not be instantiated." );
    }

    /**
     * Retrieves the singleton instance of {@link SHA1Service}
     *
     * @return the {@link SHA1Service} instance (Is never null)
     */
    @Nonnull
    public static SHA1Service getInstance() {
        if ( instance == null ) {
            instance = new SHA1ServiceImpl();
        }
        return instance;
    }

}
