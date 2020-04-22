package pl.com.phptravels.core.base;

public interface BaseAssertion {
    <G extends BasePage, T extends Assertion<G>> T check(Class<T> tClass) throws RuntimeException;
}
