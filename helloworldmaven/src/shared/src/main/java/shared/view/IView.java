package shared.view;

import shared.controller.IController;

public interface IView {
    void printMessage(String message);

    void setController(IController controller);
}
