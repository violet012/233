import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TextInputControl;

public class A5javaFX extends Application{
    // Instances variables
    private BankAccount PLACEHOLDER = new BankAccount(new Customer("John Doe", 1), 500.00);
    private Label illegal = new Label("Illegal amount entered");
    private Label accountName, accountBalance;
    private TextField txtAmount;

    /**
     * main method
     */
    public static void main(String[] args)
    {
       launch(args);
    }

    //checks if entered amount is of type double
    boolean isDouble(String input){
        try{
            Double.parseDouble(input);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    /**
     * start method
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Using a BorderPane as the root and then adding individual layers into it
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10,20,10,20));
        illegal.setTextFill(Color.FIREBRICK);
        illegal.setPadding(new Insets(5, 10, 5, 5));
        illegal.setVisible(false);

        // Add two labels to VBox and add to root on top border
        VBox toplabels = new VBox(2);
        accountName = new Label("Account Holder: " + PLACEHOLDER.getAccountHolder().getName());
        accountBalance = new Label("Balance: " + PLACEHOLDER.getBalance());

        // set text colour
        accountName.setTextFill(Color.STEELBLUE);
        accountBalance.setTextFill(Color.STEELBLUE);

        //set text size
        accountName.setFont(Font.font(16));
        accountBalance.setFont(Font.font(16));

        //getchildren
        toplabels.getChildren().add(accountName);
        toplabels.getChildren().add(accountBalance);

        // center labels
        toplabels.setAlignment(Pos.CENTER);
        root.setTop(toplabels);

        //FlowPane layout for enter amount textbox
        FlowPane middleText = new FlowPane();
        middleText.getChildren().add(new Label("Enter amount:"));
        txtAmount = new TextField("Enter value");
        txtAmount.setPrefWidth(100);
        middleText.getChildren().add(txtAmount);
        middleText.getChildren().add(illegal);

        //padding so the textbox isn't too large
        middleText.setPadding(new Insets(15,20,20,10));
        middleText.setAlignment(Pos.CENTER);
        root.setCenter(middleText);

        // Add withdraw and deposit buttons in the HBox and then add to BorderPane root on the bottom
        HBox buttons = new HBox(10);
        Button withdrawButton = new Button("Withdraw");
        buttons.getChildren().add(withdrawButton);
        Button depositButton = new Button("Deposit");
        buttons.getChildren().add(depositButton);
        buttons.setAlignment(Pos.CENTER);
        root.setBottom(buttons);

        /**
         * Event handlers for the button clicks to call the deposit or withdraw methods from BankAccount class
         */
        withdrawButton.setOnAction(new EventHandler<ActionEvent>()
	    {
            /**
             * handle for withdrawing
             */
        @Override
            public void handle(ActionEvent event)
            {
                //if the amount entered is a double
                if(isDouble(txtAmount.getText())){
                    double temp = Double.parseDouble(txtAmount.getText());
                    //if the value is greater than 0 and the value is not greater than the balance
                    if(temp > 0.0 && !(temp>PLACEHOLDER.getBalance())){
                        illegal.setVisible(false);
                        //withdraw
                        PLACEHOLDER.withdraw(temp);
                        accountBalance.setText("Balance: " + String.format("%.2f",  PLACEHOLDER.getBalance()));
                    } else
                    //if they entered an invalid amount to withdraw, show that they cannot withdraw
                        illegal.setVisible(true);
                }
                else
                //if the user entered a non double number, show that they cannot do that
                    illegal.setVisible(true);
                txtAmount.clear();
            }
        }
	    );
        depositButton.setOnAction(new EventHandler<ActionEvent>()
	    {
            /**
             * handle for deposit
             */
	   	@Override
            public void handle(ActionEvent event)
            {
                // if the amount entered is a double
                if(isDouble(txtAmount.getText())){
                    double temp = Double.parseDouble(txtAmount.getText());
                    // amount must be greater than 0 to deposit
                    if(temp>0.0){
                        illegal.setVisible(false);
                        // deposit the amount entered
                        PLACEHOLDER.deposit(temp);
                        accountBalance.setText("Balance: " + String.format("%.2f",  PLACEHOLDER.getBalance()));
                    }else
                    // if entered an invalid number to deposit, show that they cannot deposit
                        illegal.setVisible(true);
                }else
                //if the user entered a non double number, show that they cannot do that
                    illegal.setVisible(true);
                txtAmount.clear();
            }
	    }
	    );

        // BackgroundFill for the background and adds to the BorderPane layout
        BackgroundFill backgroundColour = new BackgroundFill(Color.SEASHELL, null, new Insets(0,0,0,0));
        root.setBackground(new Background(backgroundColour));

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("BankGUI2");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
