
package assignment2;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Assignment2 extends Application implements EventHandler<ActionEvent> {
    private  Scene home,addScene,depositScene,withdrawScene,listScene,transferScene;
    Stage window;  // represents main Stage globally
    Button btnAddMenu,btnDepositMenu,btnWithdrawMenu,btnTransferMenu,btnListMenu,btnAdd,btnHome,btnListHome;
    Button btnDeposit, btnDepositHome, btnWithdraw, btnWithdrawHome, btnTransfer, btnTransferHome;
    TextField custName,custAccNum,custBalance;
    TextArea accountList;
    TextField depositAccNum, depositAmt, withdrawAccNum, withdrawAmt,transferAccNumFrom, transferAccNumTo, transferAmount;
    private Bank bank;
    
    public void init(){
        bank = new Bank();
    }
    
    public void start(Stage primaryStage){
        window = primaryStage;
        // setting up Home Scene
        Label lblHomeMenu = new Label("Welcome to Trusty Bank. Please select an option from below:\n ");
        btnAddMenu = new Button("Add");btnAddMenu.setOnAction(this);btnAddMenu.setMaxWidth(Double.MAX_VALUE);
        btnDepositMenu = new Button("Deposit");btnDepositMenu.setOnAction(this);btnDepositMenu.setMaxWidth(Double.MAX_VALUE);
        btnWithdrawMenu = new Button("Withdraw");btnWithdrawMenu.setOnAction(this);btnWithdrawMenu.setMaxWidth(Double.MAX_VALUE);
        btnTransferMenu = new Button("Transfer");btnTransferMenu.setOnAction(this);btnTransferMenu.setMaxWidth(Double.MAX_VALUE);
        btnListMenu = new Button("List");btnListMenu.setOnAction(this);btnListMenu.setMaxWidth(Double.MAX_VALUE);
        VBox homeLayout = new VBox();
        homeLayout.setAlignment(Pos.CENTER);
        homeLayout.getChildren().addAll(lblHomeMenu,btnAddMenu,btnDepositMenu,btnWithdrawMenu,btnTransferMenu,btnListMenu);
        home = new Scene(homeLayout,500,500);
        
        // setting up Add Scene
        HBox addTitle = new HBox();
        addTitle.setAlignment(Pos.CENTER);
        Label lblAddTitle = new Label("ADD ACCOUNT\n ");
        addTitle.getChildren().add(lblAddTitle);
        Label lblName =new Label("Name:");
        custName = new TextField();
        Label lblAccNum =new Label("Account#:");
        custAccNum=new TextField(); 
        Label lblBalance =new Label("Balance:");
        custBalance = new TextField();
        btnAdd = new Button("Add Account");btnAdd.setOnAction(this);
        btnHome = new Button("Back");btnHome.setOnAction(this);
        VBox addLayout =new VBox();
        addLayout.setAlignment(Pos.CENTER_LEFT);
        addLayout.getChildren().addAll(addTitle,lblName,custName,lblAccNum,custAccNum,lblBalance,custBalance,btnAdd,btnHome);
        addScene = new Scene(addLayout,500,500);
        
        //setting up Deposit Scene
        HBox depositTitle = new HBox();
        depositTitle.setAlignment(Pos.CENTER);
        Label lblDepositTitle = new Label("DEPOSIT\n ");
        depositTitle.getChildren().add(lblDepositTitle);
        Label lblDepAccNum = new Label("Account#:");
        depositAccNum = new TextField();
        Label lblDepAmount = new Label("Amount:");
        depositAmt = new TextField();
        btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(this);
        btnDepositHome = new Button("Back");
        btnDepositHome.setOnAction(this);
        VBox depositLayout = new VBox();
        depositLayout.setAlignment(Pos.CENTER_LEFT);
        depositLayout.getChildren().addAll(depositTitle,lblDepAccNum,depositAccNum,lblDepAmount,depositAmt,btnDeposit,btnDepositHome);
        depositScene = new Scene(depositLayout,500,500);
        
        //setting up Withdraw Scene
        HBox withdrawTitle = new HBox();
        withdrawTitle.setAlignment(Pos.CENTER);
        Label lblWithdrawTitle = new Label("WITHDRAW\n ");
        withdrawTitle.getChildren().add(lblWithdrawTitle);
        Label lblWithAccNum = new Label("Account#:");
        withdrawAccNum = new TextField();
        Label lblWithAmount = new Label("Amount:");
        withdrawAmt = new TextField();
        btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(this);
        btnWithdrawHome = new Button("Back");
        btnWithdrawHome.setOnAction(this);
        VBox withdrawLayout = new VBox();
        withdrawLayout.setAlignment(Pos.CENTER_LEFT);
        withdrawLayout.getChildren().addAll(withdrawTitle,lblWithAccNum,withdrawAccNum,lblWithAmount,withdrawAmt,btnWithdraw,btnWithdrawHome);
        withdrawScene = new Scene(withdrawLayout,500,500);
        
        //setting up transfer Scene
        HBox transferTitle = new HBox();
        transferTitle.setAlignment(Pos.CENTER);
        Label lblTransferTitle = new Label("TRANSFER\n ");
        transferTitle.getChildren().add(lblTransferTitle);
        Label lblTransferAccFrom = new Label("From Account#:");
        transferAccNumFrom = new TextField();
        Label lblTransferAccTo = new Label("To Account#:");
        transferAccNumTo = new TextField();
        Label lblTransferAmount = new Label("Amount:");
        transferAmount = new TextField();
        btnTransfer = new Button("Transfer");
        btnTransfer.setOnAction(this);
        btnTransferHome = new Button("Back");
        btnTransferHome.setOnAction(this);
        VBox transferLayout = new VBox();
        transferLayout.setAlignment(Pos.CENTER_LEFT);
        transferLayout.getChildren().addAll(transferTitle,lblTransferAccFrom,transferAccNumFrom,lblTransferAccTo,transferAccNumTo,lblTransferAmount, transferAmount,btnTransfer,btnTransferHome);
        transferScene = new Scene(transferLayout,500,500);
        
        // setting up List Scene
        Label lblShow = new Label("List of accounts...");
        accountList = new TextArea();
        btnListHome = new Button("Back");btnListHome.setOnAction(this);btnListHome.setMaxWidth(Double.MAX_VALUE);
        VBox listLayout =new VBox();
        listLayout.getChildren().addAll(lblShow,accountList,btnListHome);
        listScene = new Scene (listLayout,500,500);
         
        window.setScene(home);
        window.show();
    }
    
    public void stop(){
        
    }
    
    
    public void handle(ActionEvent e){
        
        //open add menu
        if (e.getSource()==btnAddMenu){
            System.out.println("add Menu btn pressed (on menu scene)");
            window.setScene(addScene);
        }
        //Add a new customer account
        if (e.getSource()==btnAdd){
            System.out.println("add btn pressed (on add scene)");
            String name = custName.getText();
            long accNum = Long.parseLong(custAccNum.getText());
            double balance = Double.parseDouble(custBalance.getText());
            bank.addAccount(accNum, balance, name);
            custName.clear();
            custAccNum.clear();
            custBalance.clear();
        }
        
        //opens deposit window
        if (e.getSource()==btnDepositMenu){
            System.out.println("deposit menu btn pressed");
            window.setScene(depositScene);
        }
        //deposit amount to account
        if (e.getSource()==btnDeposit){
            System.out.println("deposit btn pressed (on deposit scene)");
            long accNum = Long.parseLong(depositAccNum.getText());
            double amount = Double.parseDouble(depositAmt.getText());
            bank.depositAccount(accNum, amount);
            depositAccNum.clear();
            depositAmt.clear();
        }
        
        //opens withdraw window
        if (e.getSource()==btnWithdrawMenu){
            System.out.println("withdraw menu btn pressed");
            window.setScene(withdrawScene);
        }
        //withdraw amount from account
        if (e.getSource()==btnWithdraw){
            System.out.println("withdraw btn pressed (on withdraw scene)");
            long accNum = Long.parseLong(withdrawAccNum.getText());
            double amount = Double.parseDouble(withdrawAmt.getText());
            bank.withdrawAccount(accNum, amount);
            withdrawAccNum.clear();
            withdrawAmt.clear();
        }
        
        //opens transfer window
        if (e.getSource()==btnTransferMenu){
            System.out.println("transfer meny btn pressed");
            window.setScene(transferScene);
        }
        //transfer amount
        if (e.getSource()==btnTransfer){
            System.out.println("transfer btn pressed (on transfer scene)");
            long accNumFrom = Long.parseLong(transferAccNumFrom.getText());
            long accNumTo = Long.parseLong(transferAccNumTo.getText());
            double amount = Double.parseDouble(transferAmount.getText());
            bank.transfer(accNumFrom, accNumTo, amount);
            transferAccNumFrom.clear();
            transferAccNumTo.clear();
            transferAmount.clear();
        }
        
        //open list accounts
        if (e.getSource()==btnListMenu){
            System.out.println("list accounts btn pressed (on menu scene)");
            accountList.setText(bank.printAccounts());
            window.setScene(listScene);
            System.out.println(bank.printAccounts());
        }
        //home or back button pressed
        if (e.getSource()==btnHome||e.getSource()==btnListHome||e.getSource()==btnDepositHome||e.getSource()==btnWithdrawHome||e.getSource()==btnTransferHome){
            System.out.println("back btn pressed (on add scene or list scene)");
            window.setScene(home);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}