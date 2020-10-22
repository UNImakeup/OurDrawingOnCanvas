package sample;

import QuoteMachine.Quote;
import QuoteMachine.QuoteMachine;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class QuoteUpdater implements Runnable {

    Controller controller;
    QuoteMachine quoteMachine;

    public  QuoteUpdater (Controller controller, QuoteMachine quoteMachine)
    {
        this.controller = controller;
        this.quoteMachine = quoteMachine;
    }

    @Override
    public void run() {

        while (true) {

            Quote quote = quoteMachine.getQuote();
            Platform.runLater(
                    new Runnable() {
                        @Override
                        public void run() {
                            controller.updateQuote(quote.getQuote(), quote.getSource());
                        }
                    });

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
