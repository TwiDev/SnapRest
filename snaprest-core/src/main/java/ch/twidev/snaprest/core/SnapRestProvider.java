package ch.twidev.snaprest.core;

public class SnapRestProvider {

    private final SnapRestCore core;

    public SnapRestProvider() {
        this.core = new SnapRestCore();
    }

    public SnapRest getInstance() {
        return core;
    }

}
