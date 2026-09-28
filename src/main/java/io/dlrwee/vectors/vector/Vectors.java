package io.dlrwee.vectors.vector;

import io.dlrwee.vectors.VectorsConstants;
import org.assertj.core.util.DoubleComparator;

public final class Vectors {
    private static final DoubleComparator COMPARATOR = new DoubleComparator(VectorsConstants.OFFSET);

    private Vectors() {
        throw new AssertionError("Vectors is a utl class and cannot be instantiated");
    }

    // === ADD ===

    public static Vector2 add(Vector2 a, Vector2 b) {
        return new Vector2(
                a.x() + b.x(),
                a.y() + b.y()
        );
    }

    public static Vector3 add(Vector3 a, Vector3 b) {
        return new Vector3(
                a.x() + b.x(),
                a.y() + b.y(),
                a.z() + b.z()
        );
    }

    // === SUBTRACT ===

    public static Vector2 subtract(Vector2 a, Vector2 b) {
        return new Vector2(
                a.x() - b.x(),
                a.y() - b.y()
        );
    }

    public static Vector3 subtract(Vector3 a, Vector3 b) {
        return new Vector3(
                a.x() - b.x(),
                a.y() - b.y(),
                a.z() - b.z()
        );
    }

    // === MULTIPLY ===

    public static Vector2 multiply(Vector2 vector, double scalar) {
        return new Vector2(
                vector.x() * scalar,
                vector.y() * scalar
        );
    }

    public static Vector3 multiply(Vector3 vector, double scalar) {
        return new Vector3(
                vector.x() * scalar,
                vector.y() * scalar,
                vector.z() * scalar
        );
    }

    // === DIVIDE ===

    public static Vector2 divide(Vector2 vector, double scalar) {
        if (isZeroWithOffset(scalar)) {
            throw new ArithmeticException("Division by zero");
        }

        return new Vector2(
                vector.x() / scalar,
                vector.y() / scalar
        );
    }

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

    public static Vector2 negate(Vector2 vector) {
        return new Vector2(
                vector.x() * -1,
                vector.y() * -1
        );
    }

    public static Vector3 negate(Vector3 vector) {
        return new Vector3(
                vector.x() * -1,
                vector.y() * -1,
                vector.z() * -1
        );
    }

    // === DOT PRODUCT ===

    public static double dotProduct(Vector2 a, Vector2 b) {
        return (a.x() * b.x()) + (a.y() * b.y());
    }

    public static double dotProduct(Vector3 a, Vector3 b) {
        return (a.x() * b.x()) + (a.y() * b.y()) + (a.z() * b.z());
    }

    // === CROSS PRODUCT ===

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

    public static double length(Vector2 vector) {
        return Math.sqrt(
                Math.pow(vector.x(), 2) + Math.pow(vector.y(), 2)
        );
    }

    public static double length(Vector3 vector) {
        return Math.sqrt(
                Math.pow(vector.x(), 2) +
                        Math.pow(vector.y(), 2) +
                        Math.pow(vector.z(), 2)
        );
    }

    // === NORMALIZE ===

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

    public static double distance(Vector2 a, Vector2 b) {
        return Math.sqrt(
                Math.pow(a.x() - b.x(), 2) + Math.pow(a.y() - b.y(), 2)
        );
    }

    public static double distance(Vector3 a, Vector3 b) {
        return Math.sqrt(
                Math.pow(a.x() - b.x(), 2) +
                        Math.pow(a.y() - b.y(), 2) +
                        Math.pow(a.z() - b.z(), 2)
        );
    }

    // === ANGLE ===

    public static double angle(Vector2 a, Vector2 b) {
        if (isZero(a) || isZero(b)) {
            throw new ArithmeticException("Both vectors must not be 0");
        }

        double aLength = length(a);
        double bLength = length(b);

        double cosTheta = Math.clamp(dotProduct(a, b) / (aLength * bLength), -1.0, 1.0);
        return Math.acos(cosTheta);
    }

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

    public static Vector2 project(Vector2 a, Vector2 b) {
        if (isZero(b)) {
            throw new ArithmeticException("Vector b must not be zero");
        }

        double firstDot = dotProduct(a, b);
        double secondDot = dotProduct(b, b);
        double scalar = firstDot / secondDot;

        return multiply(b, scalar);
    }

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

    public static boolean isEqual(Vector2 a, Vector2 b, double tolerance) {
        DoubleComparator comparator = new DoubleComparator(tolerance);

        return comparator.compare(a.x(), b.x()) == 0 &&
                comparator.compare(a.y(), b.y()) == 0;
    }

    public static boolean isEqual(Vector3 a, Vector3 b, double tolerance) {
        DoubleComparator comparator = new DoubleComparator(tolerance);

        return comparator.compare(a.x(), b.x()) == 0 &&
                comparator.compare(a.y(), b.y()) == 0 &&
                comparator.compare(a.z(), b.z()) == 0;
    }

    // === IS ORTHOGONAL ===
    
    public static boolean isOrthogonal(Vector2 a, Vector2 b) {
        return isZeroWithOffset(dotProduct(a, b));
    }

    public static boolean isOrthogonal(Vector3 a, Vector3 b) {
        return isZeroWithOffset(dotProduct(a ,b));
    }

    // === IS COLLINEAR ===

    public static boolean isCollinear(Vector2 a, Vector2 b) {
        return isZeroWithOffset(a.x() * b.y() - a.y() * b.x());
    }

    public static boolean isCollinear(Vector3 a, Vector3 b) {
        return isZero(crossProduct(a, b));
    }

    // === IS ZERO ===

    public static boolean isZero(Vector2 vector) {
        return isZeroWithOffset(vector.x()) &&
                isZeroWithOffset(vector.y());
    }

    public static boolean isZero(Vector3 vector) {
        return isZeroWithOffset(vector.x()) &&
                isZeroWithOffset(vector.y()) &&
                isZeroWithOffset(vector.z());
    }

    private static boolean isZeroWithOffset(double value) {
        return COMPARATOR.compare(value, 0.0) == 0;
    }
}
