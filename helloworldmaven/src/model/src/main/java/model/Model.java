package model;

import java.util.Observable;

import shared.model.IModel;
import shared.model.entity.HelloWorld;

public final class Model extends Observable implements IModel {

    private HelloWorld helloWorld;

    public Model() {
        this.helloWorld = new HelloWorld();
    }

    public HelloWorld getHelloWorld() {
        return this.helloWorld;
    }

    private void setHelloWorld(final HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
        this.setChanged();
        this.notifyObservers();
    }

    public Observable getObservable() {
        return this;
    }

    public String getMessage() {
        // TODO Auto-generated method stub
        return null;
    }

    public void loadHelloWorld(final String key) {
        if (key == "GB") {
            this.setHelloWorld(new HelloWorld(0, "GB", "Good Morning"));
        } else {
            this.setHelloWorld(new HelloWorld(0, "FR", "Bonjour le monde"));
        }
        /*
         * try {
         * final DAOHelloWorld daoHelloWorld = new
         * DAOHelloWorld(DBConnection.getInstance().getConnection());
         * this.setHelloWorld(daoHelloWorld.find(key));
         * } catch (final SQLException e) {
         * e.printStackTrace();
         * }
         */
    }
}
