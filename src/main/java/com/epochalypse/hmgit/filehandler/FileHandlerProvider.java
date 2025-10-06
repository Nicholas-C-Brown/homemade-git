package com.epochalypse.hmgit.filehandler;

/**
 * A provider class that provides a singleton instance of a {@link FileHandler}
 */
public class FileHandlerProvider {

    private static FileHandler instance;

    private FileHandlerProvider() {
        throw new UnsupportedOperationException( "Provider class should not be instantiated." );
    }

    /**
     * Retrieves the singleton instance of {@link FileHandler}
     *
     * @return the {@link FileHandler} instance
     */
    public static FileHandler getInstance() {
        if ( instance == null ) {
            instance = new FileHandlerImpl();
        }
        return instance;
    }


}
