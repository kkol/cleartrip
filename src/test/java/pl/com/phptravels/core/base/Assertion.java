package pl.com.phptravels.core.base;

public class Assertion <T extends BasePage> {
    protected T page;

    public T endAssertion(){
        return page;
    }
    public void setPage(T page){
        this.page = page;
    }
}
