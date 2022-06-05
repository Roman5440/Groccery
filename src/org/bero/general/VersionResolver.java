package org.bero.general;

import java.util.Optional;
import java.util.regex.Pattern;

import static java.lang.String.format;

class VersionResolver {

    private static final String DEFAULT_VERSION = "V0";
    private static final Pattern PATTERN = Pattern.compile("V\\d+$");

    String resolveVersion() {
        return Optional.ofNullable(System.getenv("VERSION"))
                .map(version -> {
                    validateVersion(version);
                    return version;
                })
                .orElseGet(() -> {
                    System.err.println("WARNING: No environment variable \"VERSION\" set. Using 'V0' as default");
                    return DEFAULT_VERSION;
                });
    }

    private void validateVersion(String version) {
        if (!PATTERN.matcher(version).matches()) {
            throw new ValidationException(format("Input version '%s' mismatches required pattern" +
                    "Must start with 'V' and end with number.", version));
        }
    }
}
