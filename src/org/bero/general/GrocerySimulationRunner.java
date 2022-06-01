package org.bero.general;

import org.bero.v0.GroceryV0;

import java.util.Map;

public class GrocerySimulationRunner {
    private static final Map<Version, VersionedGrocery> GROCERY_REGISTRY = Map.of(Version.V0, new GroceryV0());

    public static void simulate() {
        Version version = resolveVersion();
        GROCERY_REGISTRY.get(version).simulate();
    }

    private static Version resolveVersion() {
        String version = System.getenv("VERSION");
        if (version == null) {
            System.err.println("WARNING: No environment variable \"VERSION\" set. Using V0 as default");
            version = Version.V0.name(); // default fallback if env variable is missing
        }
        return Version.valueOf(version);
    }

    private enum Version {
        V0
    }
}
