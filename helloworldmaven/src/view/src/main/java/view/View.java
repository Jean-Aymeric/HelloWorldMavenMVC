package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import shared.controller.ControllerOrder;
import shared.controller.IController;
import shared.model.IModel;
import shared.view.IView;

public final class View implements IView, Runnable {

    private final ViewFrame viewFrame;

    public View(final IModel model) {
        this.viewFrame = new ViewFrame(model);
        SwingUtilities.invokeLater(this);
    }

    protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_G:
                return ControllerOrder.English;
            case KeyEvent.VK_F:
                return ControllerOrder.Francais;
            case KeyEvent.VK_D:
                return ControllerOrder.Deutsch;
            case KeyEvent.VK_I:
                return ControllerOrder.Indonesia;
            default:
                return ControllerOrder.English;
        }
    }

    public void printMessage(final String message) {
        this.viewFrame.printMessage(message);
    }

    public void run() {
        this.viewFrame.setVisible(true);
    }

    public void setController(final IController controller) {
        this.viewFrame.setController(controller);
    }
}
