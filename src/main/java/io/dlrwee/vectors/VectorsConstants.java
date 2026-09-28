package io.dlrwee.vectors;

/**
 * Utility class that holds global constant values used throughout the vectors library.
 *
 * @author dlrwee
 * @version 1.0
 */
public final class VectorsConstants {
    private VectorsConstants() {
        throw new AssertionError("VectorsConstants is a util class and cannot be instantiated");
    }

    /**
     * The default precision tolerance threshold (1e-9) used for floating-point
     * coordinate comparisons and zero-checks.
     */
    public static final double OFFSET = 1e-9;
}
