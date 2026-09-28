package io.dlrwee.vectors.vector;

import io.dlrwee.vectors.VectorsConstants;
import org.assertj.core.util.DoubleComparator;

/**
 * Utility class providing mathematical operations for {@link Vector2} and {@link Vector3} instances.
 * <p>
 * All coordinate comparisons and precision-dependent operations within this class
 * are performed with an absolute tolerance threshold of {@code 1e-9}.
 *
 * @author dlrwee
 * @version 1.0
 */
public final class Vectors {
    private static final DoubleComparator COMPARATOR = new DoubleComparator(VectorsConstants.OFFSET);

    private Vectors() {
        throw new AssertionError("Vectors is a utl class and cannot be instantiated");
    }

    // === ADD ===

    /**
     * Adds two two-dimensional vectors together.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new {@link Vector2} representing the sum of the two vectors
     */
    public static Vector2 add(Vector2 a, Vector2 b) {
        return new Vector2(
                a.x() + b.x(),
                a.y() + b.y()
        );
    }

    /**
     * Adds two three-dimensional vectors together.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new {@link Vector3} representing the sum of the two vectors
     */
    public static Vector3 add(Vector3 a, Vector3 b) {
        return new Vector3(
                a.x() + b.x(),
                a.y() + b.y(),
                a.z() + b.z()
        );
    }

    // === SUBTRACT ===

    /**
     * Subtracts the second two-dimensional vector from the first one.
     *
     * @param a the vector to be subtracted from
     * @param b the vector to subtract
     * @return a new {@link Vector2} representing the difference between the two vectors
     */
    public static Vector2 subtract(Vector2 a, Vector2 b) {
        return new Vector2(
                a.x() - b.x(),
                a.y() - b.y()
        );
    }

    /**
     * Subtracts the second three-dimensional vector from the first one.
     *
     * @param a the vector to be subtracted from
     * @param b the vector to subtract
     * @return a new {@link Vector3} representing the difference between the two vectors
     */
    public static Vector3 subtract(Vector3 a, Vector3 b) {
        return new Vector3(
                a.x() - b.x(),
                a.y() - b.y(),
                a.z() - b.z()
        );
    }

    // === MULTIPLY ===

    /**
     * Multiplies a two-dimensional vector by a scalar value.
     *
     * @param vector the vector to scale
     * @param scalar the scalar value to multiply by
     * @return a new {@link Vector2} scaled by the given scalar
     */
    public static Vector2 multiply(Vector2 vector, double scalar) {
        return new Vector2(
                vector.x() * scalar,
                vector.y() * scalar
        );
    }

    /**
     * Multiplies a three-dimensional vector by a scalar value.
     *
     * @param vector the vector to scale
     * @param scalar the scalar value to multiply by
     * @return a new {@link Vector3} scaled by the given scalar
     */
    public static Vector3 multiply(Vector3 vector, double scalar) {
        return new Vector3(
                vector.x() * scalar,
                vector.y() * scalar,
                vector.z() * scalar
        );
    }

    // === DIVIDE ===

    /**
     * Divides a two-dimensional vector by a scalar value.
     *
     * @param vector the vector to divide
     * @param scalar the scalar value to divide by
     * @return a new {@link Vector2} divided by the given scalar
     * @throws ArithmeticException if the scalar value is zero (within the precision offset)
     */
    public static Vector2 divide(Vector2 vector, double scalar) {
        if (isZeroWithOffset(scalar)) {
            throw new ArithmeticException("Division by zero");
        }

        return new Vector2(
                vector.x() / scalar,
                vector.y() / scalar
        );
    }

    /**
     * Divides a three-dimensional vector by a scalar value.
     *
     * @param vector the vector to divide
     * @param scalar the scalar value to divide by
     * @return a new {@link Vector3} divided by the given scalar
     * @throws ArithmeticException if the scalar value is zero (within the precision offset)
     */
    public static Vector3 divide(Vector3 vector, double scalar) {
        if (isZeroWithOffset(scalar)) {
            throw new ArithmeticException("Division by zero");
        }

        return new Vector3(
                vector.x() / scalar,
                vector.y() / scalar,
                vector.z() / scalar
        );
    }

    // === NEGATE ===

    /**
     * Negates a two-dimensional vector, inverting the sign of each coordinate.
     *
     * @param vector the vector to negate
     * @return a new {@link Vector2} pointing in the opposite direction
     */
    public static Vector2 negate(Vector2 vector) {
        return new Vector2(
                vector.x() * -1,
                vector.y() * -1
        );
    }

    /**
     * Negates a three-dimensional vector, inverting the sign of each coordinate.
     *
     * @param vector the vector to negate
     * @return a new {@link Vector3} pointing in the opposite direction
     */
    public static Vector3 negate(Vector3 vector) {
        return new Vector3(
                vector.x() * -1,
                vector.y() * -1,
                vector.z() * -1
        );
    }

    // === DOT PRODUCT ===

    /**
     * Calculates the dot product of two two-dimensional vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return the scalar result of the dot product
     */
    public static double dotProduct(Vector2 a, Vector2 b) {
        return (a.x() * b.x()) + (a.y() * b.y());
    }

    /**
     * Calculates the dot product of two three-dimensional vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return the scalar result of the dot product
     */
    public static double dotProduct(Vector3 a, Vector3 b) {
        return (a.x() * b.x()) + (a.y() * b.y()) + (a.z() * b.z());
    }

    // === CROSS PRODUCT ===

    /**
     * Calculates the cross product of two three-dimensional vectors.
     * <p>
     * The resulting vector is perpendicular to both input vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new {@link Vector3} representing the cross product vector
     */
    public static Vector3 crossProduct(Vector3 a, Vector3 b) {
        double aX = a.x();
        double aY = a.y();
        double aZ = a.z();

        double bX = b.x();
        double bY = b.y();
        double bZ = b.z();

        double cX = aY * bZ - aZ * bY;
        double cY = aZ * bX - aX * bZ;
        double cZ = aX * bY - aY * bX;

        return new Vector3(cX, cY, cZ);
    }

    // === LENGTH ===

    /**
     * Calculates the length (magnitude) of a two-dimensional vector.
     *
     * @param vector the vector whose length is to be calculated
     * @return the length of the vector
     */
    public static double length(Vector2 vector) {
        return Math.sqrt(
                Math.pow(vector.x(), 2) + Math.pow(vector.y(), 2)
        );
    }

    /**
     * Calculates the length (magnitude) of a three-dimensional vector.
     *
     * @param vector the vector whose length is to be calculated
     * @return the length of the vector
     */
    public static double length(Vector3 vector) {
        return Math.sqrt(
                Math.pow(vector.x(), 2) +
                        Math.pow(vector.y(), 2) +
                        Math.pow(vector.z(), 2)
        );
    }

    // === NORMALIZE ===

    /**
     * Normalizes a two-dimensional vector, scaling it to a length of 1.
     *
     * @param vector the vector to normalize
     * @return a new unit {@link Vector2} pointing in the same direction
     * @throws ArithmeticException if the vector is a zero vector (within the precision offset)
     */
    public static Vector2 normalize(Vector2 vector) {
        double length = length(vector);
        if (isZeroWithOffset(length)) {
            throw new ArithmeticException("Vector must not be zero");
        }

        return new Vector2(
                vector.x() / length,
                vector.y() / length
        );
    }

    /**
     * Normalizes a three-dimensional vector, scaling it to a length of 1.
     *
     * @param vector the vector to normalize
     * @return a new unit {@link Vector3} pointing in the same direction
     * @throws ArithmeticException if the vector is a zero vector (within the precision offset)
     */
    public static Vector3 normalize(Vector3 vector) {
        double length = length(vector);
        if (isZeroWithOffset(length)) {
            throw new ArithmeticException("Vector must not be zero");
        }

        return new Vector3(
                vector.x() / length,
                vector.y() / length,
                vector.z() / length
        );
    }

    // === DISTANCE ===

    /**
     * Calculates the Euclidean distance between two two-dimensional vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return the distance between the two vectors
     */
    public static double distance(Vector2 a, Vector2 b) {
        return Math.sqrt(
                Math.pow(a.x() - b.x(), 2) + Math.pow(a.y() - b.y(), 2)
        );
    }

    /**
     * Calculates the Euclidean distance between two three-dimensional vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return the distance between the two vectors
     */
    public static double distance(Vector3 a, Vector3 b) {
        return Math.sqrt(
                Math.pow(a.x() - b.x(), 2) +
                        Math.pow(a.y() - b.y(), 2) +
                        Math.pow(a.z() - b.z(), 2)
        );
    }

    // === ANGLE ===

    /**
     * Calculates the angle between two two-dimensional vectors.
     * <p>
     * The resulting angle is returned in radians and lies within the range [0, &pi;].
     * The calculation clamps the cosine value to the range [-1.0, 1.0] to prevent
     * potential floating-point inaccuracies from causing NaN results.
     *
     * @param a the first vector
     * @param b the second vector
     * @return the angle between the two vectors in radians
     * @throws ArithmeticException if either vector is a zero vector
     */
    public static double angle(Vector2 a, Vector2 b) {
        if (isZero(a) || isZero(b)) {
            throw new ArithmeticException("Both vectors must not be 0");
        }

        double aLength = length(a);
        double bLength = length(b);

        double cosTheta = Math.clamp(dotProduct(a, b) / (aLength * bLength), -1.0, 1.0);
        return Math.acos(cosTheta);
    }

    /**
     * Calculates the angle between two three-dimensional vectors.
     * <p>
     * The resulting angle is returned in radians and lies within the range [0, &pi;].
     * The calculation clamps the cosine value to the range [-1.0, 1.0] to prevent
     * potential floating-point inaccuracies from causing NaN results.
     *
     * @param a the first vector
     * @param b the second vector
     * @return the angle between the two vectors in radians
     * @throws ArithmeticException if either vector is a zero vector
     */
    public static double angle(Vector3 a, Vector3 b) {
        if (isZero(a) || isZero(b)) {
            throw new ArithmeticException("Both vectors must not be 0");
        }

        double aLength = length(a);
        double bLength = length(b);

        double cosTheta = Math.clamp(dotProduct(a, b) / (aLength * bLength), -1.0, 1.0);
        return Math.acos(cosTheta);
    }

    // === PROJECT ===

    /**
     * Projects vector {@code a} orthogonally onto vector {@code b}.
     *
     * @param a the vector to project
     * @param b the vector onto which vector {@code a} is projected
     * @return a new {@link Vector2} representing the vector projection of {@code a} onto {@code b}
     * @throws ArithmeticException if vector {@code b} is a zero vector
     */
    public static Vector2 project(Vector2 a, Vector2 b) {
        if (isZero(b)) {
            throw new ArithmeticException("Vector b must not be zero");
        }

        double firstDot = dotProduct(a, b);
        double secondDot = dotProduct(b, b);
        double scalar = firstDot / secondDot;

        return multiply(b, scalar);
    }

    /**
     * Projects vector {@code a} orthogonally onto vector {@code b}.
     *
     * @param a the vector to project
     * @param b the vector onto which vector {@code a} is projected
     * @return a new {@link Vector3} representing the vector projection of {@code a} onto {@code b}
     * @throws ArithmeticException if vector {@code b} is a zero vector
     */
    public static Vector3 project(Vector3 a, Vector3 b) {
        if (isZero(b)) {
            throw new ArithmeticException("Vector b must not be zero");
        }

        double firstDot = dotProduct(a, b);
        double secondDot = dotProduct(b, b);
        double scalar = firstDot / secondDot;

        return multiply(b, scalar);
    }

    // === IS EQUAL ===

    /**
     * Checks if two two-dimensional vectors are equal within a specified tolerance threshold.
     *
     * @param a the first vector
     * @param b the second vector
     * @param tolerance the maximum absolute difference allowed between coordinates
     * @return {@code true} if the coordinates are equal within the given tolerance, {@code false} otherwise
     */
    public static boolean isEqual(Vector2 a, Vector2 b, double tolerance) {
        DoubleComparator comparator = new DoubleComparator(tolerance);

        return comparator.compare(a.x(), b.x()) == 0 &&
                comparator.compare(a.y(), b.y()) == 0;
    }

    /**
     * Checks if two three-dimensional vectors are equal within a specified tolerance threshold.
     *
     * @param a the first vector
     * @param b the second vector
     * @param tolerance the maximum absolute difference allowed between coordinates
     * @return {@code true} if the coordinates are equal within the given tolerance, {@code false} otherwise
     */
    public static boolean isEqual(Vector3 a, Vector3 b, double tolerance) {
        DoubleComparator comparator = new DoubleComparator(tolerance);

        return comparator.compare(a.x(), b.x()) == 0 &&
                comparator.compare(a.y(), b.y()) == 0 &&
                comparator.compare(a.z(), b.z()) == 0;
    }

    // === IS ORTHOGONAL ===

    /**
     * Checks if two two-dimensional vectors are orthogonal (perpendicular) to each other.
     * <p>
     * The vectors are considered orthogonal if their dot product is equal to zero
     * within the default precision offset threshold of {@code 1e-9}.
     *
     * @param a the first vector
     * @param b the second vector
     * @return {@code true} if the vectors are orthogonal, {@code false} otherwise
     */
    public static boolean isOrthogonal(Vector2 a, Vector2 b) {
        return isZeroWithOffset(dotProduct(a, b));
    }

    /**
     * Checks if two three-dimensional vectors are orthogonal (perpendicular) to each other.
     * <p>
     * The vectors are considered orthogonal if their dot product is equal to zero
     * within the default precision offset threshold of {@code 1e-9}.
     *
     * @param a the first vector
     * @param b the second vector
     * @return {@code true} if the vectors are orthogonal, {@code false} otherwise
     */
    public static boolean isOrthogonal(Vector3 a, Vector3 b) {
        return isZeroWithOffset(dotProduct(a ,b));
    }

    // === IS COLLINEAR ===

    /**
     * Checks if two two-dimensional vectors are collinear.
     * <p>
     * The vectors are considered collinear if the determinant of their coordinates
     * is equal to zero within the default precision offset threshold of {@code 1e-9}.
     *
     * @param a the first vector
     * @param b the second vector
     * @return {@code true} if the vectors are collinear, {@code false} otherwise
     */
    public static boolean isCollinear(Vector2 a, Vector2 b) {
        return isZeroWithOffset(a.x() * b.y() - a.y() * b.x());
    }

    /**
     * Checks if two three-dimensional vectors are collinear.
     * <p>
     * The vectors are considered collinear if their cross product is a zero vector
     * within the default precision offset threshold of {@code 1e-9}.
     *
     * @param a the first vector
     * @param b the second vector
     * @return {@code true} if the vectors are collinear, {@code false} otherwise
     */
    public static boolean isCollinear(Vector3 a, Vector3 b) {
        return isZero(crossProduct(a, b));
    }

    // === IS ZERO ===

    /**
     * Checks if a two-dimensional vector is a zero vector.
     * <p>
     * The vector is considered zero if both of its coordinates are equal to zero
     * within the default precision offset threshold of {@code 1e-9}.
     *
     * @param vector the vector to check
     * @return {@code true} if the vector is zero, {@code false} otherwise
     */
    public static boolean isZero(Vector2 vector) {
        return isZeroWithOffset(vector.x()) &&
                isZeroWithOffset(vector.y());
    }

    /**
     * Checks if a three-dimensional vector is a zero vector.
     * <p>
     * The vector is considered zero if all of its coordinates are equal to zero
     * within the default precision offset threshold of {@code 1e-9}.
     *
     * @param vector the vector to check
     * @return {@code true} if the vector is zero, {@code false} otherwise
     */
    public static boolean isZero(Vector3 vector) {
        return isZeroWithOffset(vector.x()) &&
                isZeroWithOffset(vector.y()) &&
                isZeroWithOffset(vector.z());
    }

    private static boolean isZeroWithOffset(double value) {
        return COMPARATOR.compare(value, 0.0) == 0;
    }
}
