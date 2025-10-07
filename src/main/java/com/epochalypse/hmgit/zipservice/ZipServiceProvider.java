package com.epochalypse.hmgit.zipservice;

public class ZipServiceProvider {

    private static ZipService instance;

    private ZipServiceProvider() {
        throw new UnsupportedOperationException( "Provider class should not be instantiated." );
    }

    /**
     * Retrieves the singleton instance of {@link ZipService}
     *
     * @return the {@link ZipService} instance
     */
    public static ZipService getInstance() {
        if ( instance == null ) {
            instance = new ZipServiceImpl();
        }
        return instance;
    }

}
