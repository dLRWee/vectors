package io.dlrwee.vectors.converter;

import io.dlrwee.vectors.vector.Vector2;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public final class Vector2ArgumentConverter implements ArgumentConverter {
    private static final String SPLITERATOR = ";";

    @Override
    public Object convert(Object source, ParameterContext context)
            throws ArgumentConversionException {
        if (!(source instanceof String)) {
            throw new ArgumentConversionException("Argument must be an instance of String");
        }

        try {
            String[] parts = ((String) source).split(SPLITERATOR);
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);
            return new Vector2(x, y);
        } catch (Exception e) {
            String message = String.format("Could not convert '%s' to Vector2", source);
            throw new ArgumentConversionException(message);
        }
    }
}
