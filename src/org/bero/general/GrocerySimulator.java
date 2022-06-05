package org.bero.general;

public class GrocerySimulator {

    private static final Runner groceryRunner;

    static {
        final var versionResolver = new VersionResolver();
        final var factory = new Factory();
        groceryRunner = new Runner(factory, versionResolver);
    }

    public static void simulate() {
        groceryRunner.run();
    }
}
