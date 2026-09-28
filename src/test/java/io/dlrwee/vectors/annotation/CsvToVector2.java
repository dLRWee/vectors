package io.dlrwee.vectors.annotation;

import io.dlrwee.vectors.converter.Vector2ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@ConvertWith(Vector2ArgumentConverter.class)
public @interface CsvToVector2 {
}
