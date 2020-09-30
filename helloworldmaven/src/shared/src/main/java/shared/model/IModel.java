package shared.model;

import java.util.Observable;

import shared.model.entity.HelloWorld;

public interface IModel {
    void loadHelloWorld(String key);

    HelloWorld getHelloWorld();

    Observable getObservable();
}
