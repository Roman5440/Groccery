package org.bero.general;

class Runner {

    private final Factory factory;
    private final VersionResolver versionResolver;

    Runner(Factory factory, VersionResolver versionResolver) {
        this.factory = factory;
        this.versionResolver = versionResolver;
    }

    void run() {
        final var version = versionResolver.resolveVersion();
        final var grocery = factory.create(version);
        grocery.simulate();
    }
}
