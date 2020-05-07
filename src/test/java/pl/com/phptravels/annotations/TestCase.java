package pl.com.phptravels.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestCase {
    /**
     * Should match the id of particular tested test case from the Management Test Case tool
     */
    String[] id();
}
