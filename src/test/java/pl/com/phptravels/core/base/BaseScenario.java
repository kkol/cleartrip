package pl.com.phptravels.core.base;

public interface BaseScenario <I extends BasePage, O extends BasePage> {
    O run(I entry);
}
