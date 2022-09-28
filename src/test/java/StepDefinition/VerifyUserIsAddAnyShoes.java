package StepDefinition;

import org.testng.annotations.Test;
import java.io.IOException;

public class VerifyUserIsAddAnyShoes extends BaseClass {
    public void addShoesInCart() throws IOException {
        pageFactory.getUserRegisteration().registeringUser();
        pageFactory.getApparel().addShoes();
        pageFactory.getLogin().login();
        pageFactory.getElectronics().checkout();
        pageFactory.getElectronics().billing();
        pageFactory.getComputer().shippingMethod();
        pageFactory.getComputer().paymentMethod();
        pageFactory.getComputer().confirmOrder();
        pageFactory.getComputer().checkoutConfirm();
    }

}
