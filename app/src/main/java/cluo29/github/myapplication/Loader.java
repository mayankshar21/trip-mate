package cluo29.github.myapplication;

/**
 *Author: Mayank Tomar(1020005)
 *This is a class used to keep track of ASync method calls for webApi's
 */
public class Loader {

    Boolean isLoading;

    public Loader(){
        isLoading = true;
    }

    public void setLoading(Boolean loading) {
        isLoading = loading;
    }

    public Boolean getLoading() {
        return isLoading;
    }
}
