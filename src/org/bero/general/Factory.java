package org.bero.general;

import org.bero.IGrocery;

import java.lang.reflect.InvocationTargetException;

import static java.lang.String.format;

class Factory {

    private static final String CONVENTIONAL_CLASS_NAME = "Grocery";
    private static final String ROOT_PACKAGE = "org.bero";

    IGrocery create(String version) {
        return createInstance(version);
    }

    private static IGrocery createInstance(String version) {
        final var groceryClass = resolveClass(version);
        try {
            final var declaredConstructor = groceryClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException
                | InstantiationException | IllegalAccessException ex) {
            throw new IllegalStateException(format("Can not create instance of %s", groceryClass.getName()), ex);
        }
    }

    @SuppressWarnings("unchecked")
    private static Class<? extends IGrocery> resolveClass(String version) {
        final var packageName = toPackage(version);
        final var className = packageName + "." + CONVENTIONAL_CLASS_NAME;
        try {
            return (Class<? extends IGrocery>) Class.forName(className);
        } catch (ClassNotFoundException ex) {
            throw new IllegalStateException(format("Can not find class with name %s at package %s",
                    CONVENTIONAL_CLASS_NAME, packageName));
        }
    }

    private static String toPackage(String version) {
        final var subpackage = version.toLowerCase();
        return ROOT_PACKAGE + "." + subpackage;
    }
}
