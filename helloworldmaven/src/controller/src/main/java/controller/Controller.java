package controller;

import shared.controller.ControllerOrder;
import shared.controller.IController;
import shared.model.IModel;
import shared.view.IView;

public class Controller implements IController {

    private IModel model;
    private IView  view;

    public Controller(final IModel model, final IView view) {
        super();
        this.setModel(model);
        this.setView(view);
        this.getView().setController(this);
    }

    public void control() {
        this.view.printMessage(
                "Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
    }

    public void orderPerform(final ControllerOrder contollerOrder) {
        switch (contollerOrder) {
            case English:
                this.model.loadHelloWorld("GB");
                break;
            case Francais:
                this.model.loadHelloWorld("FR");
                break;
            case Deutsch:
                this.model.loadHelloWorld("DE");
                break;
            case Indonesia:
                this.model.loadHelloWorld("ID");
                break;
            default:
                break;
        }
    }

    private void setModel(final IModel model) {
        this.model = model;
    }

    private void setView(final IView view) {
        this.view = view;
    }

    private IModel getModel() {
        return this.model;
    }

    private IView getView() {
        return this.view;
    }

}
