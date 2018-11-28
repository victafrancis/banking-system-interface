
package assignment2;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Assignment2 extends Application implements EventHandler<ActionEvent> {
    
    //Members:
    //Maria Lilian Yang - 101151657
    //Francis Victa - 101159185
    
    private  Scene home,addScene,depositScene,withdrawScene,listScene,transferScene;
    Stage window;  // represents main Stage globally
    Button btnAddMenu,btnDepositMenu,btnWithdrawMenu,btnTransferMenu,btnListMenu,btnAdd,btnHome,btnListHome;
    Button btnDeposit, btnDepositHome, btnWithdraw, btnWithdrawHome, btnTransfer, btnTransferHome;
    TextField custName,custAccNum,custBalance;
    TextArea accountList;
    TextField depositAccNum, depositAmt, withdrawAccNum, withdrawAmt,transferAccNumFrom, transferAccNumTo, transferAmount;
    private Bank bank;
    Label lblAddMessage,lblAddMessage2,lblAddMessageErr, lblDepositMessage,lblDepositMessage2,lblDepositMessageErr, lblWithdrawMessage,lblWithdrawMessage2,
            lblWithdrawMessageErr,lblTransferMessage, lblTransferMessage2, lblTransferMessageErr;
    
    public void init(){
        bank = new Bank();
    }
    
    public void start(Stage primaryStage){
        window = primaryStage;
        // setting up Home Scene
        HBox homeTitle = new HBox();
        homeTitle.setAlignment(Pos.CENTER);
        Label lblHomeTitle = new Label("TRUSTY BANK\n ");
        lblHomeTitle.setFont(new Font("Arial", 18)); 
        lblHomeTitle.setStyle("-fx-font-weight: bold");
        homeTitle.getChildren().add(lblHomeTitle);
        Label lblHomeMenu = new Label("Welcome to Trusty Bank. Please select an option from below:\n ");
        btnAddMenu = new Button("Add");btnAddMenu.setOnAction(this);btnAddMenu.setMaxWidth(Double.MAX_VALUE);
        btnDepositMenu = new Button("Deposit");btnDepositMenu.setOnAction(this);btnDepositMenu.setMaxWidth(Double.MAX_VALUE);
        btnWithdrawMenu = new Button("Withdraw");btnWithdrawMenu.setOnAction(this);btnWithdrawMenu.setMaxWidth(Double.MAX_VALUE);
        btnTransferMenu = new Button("Transfer");btnTransferMenu.setOnAction(this);btnTransferMenu.setMaxWidth(Double.MAX_VALUE);
        btnListMenu = new Button("List");btnListMenu.setOnAction(this);btnListMenu.setMaxWidth(Double.MAX_VALUE);
        VBox homeLayout = new VBox();
        homeLayout.setAlignment(Pos.CENTER);
        homeLayout.getChildren().addAll(homeTitle,lblHomeMenu,btnAddMenu,btnDepositMenu,btnWithdrawMenu,btnTransferMenu,btnListMenu);
        homeLayout.setStyle("-fx-background-color: lightcyan"); //set bg color
        home = new Scene(homeLayout,500,500);
        
        // setting up Add Scene
        HBox addTitle = new HBox();
        addTitle.setAlignment(Pos.CENTER);
        Label lblAddTitle = new Label("ADD ACCOUNT\n ");
        lblAddTitle.setStyle("-fx-font-weight: bold");
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
        
        HBox addMessage = new HBox();
        HBox addMessage2 = new HBox();
        addMessage.setAlignment(Pos.CENTER);
        addMessage2.setAlignment(Pos.CENTER);
        lblAddMessage = new Label("");
        lblAddMessage2 = new Label("");
        lblAddMessageErr =  new Label("");
        lblAddMessage.setTextFill(Color.web("#008000"));
        lblAddMessage2.setTextFill(Color.web("#008000"));
        lblAddMessage.setStyle("-fx-font-weight: bold");
        lblAddMessageErr.setTextFill(Color.web("#DC143C"));
        lblAddMessageErr.setStyle("-fx-font-weight: bold");
        addMessage.getChildren().add(lblAddMessage);
        addMessage2.getChildren().add(lblAddMessage2);
        addMessage.getChildren().add(lblAddMessageErr);
        
        addLayout.getChildren().addAll(addTitle,lblName,custName,lblAccNum,custAccNum,lblBalance,custBalance,btnAdd,btnHome,addMessage,addMessage2);
        addLayout.setStyle("-fx-background-color: lightcyan"); //set bg color
        addScene = new Scene(addLayout,500,500);
        
    
        //setting up Deposit Scene
        HBox depositTitle = new HBox();
        depositTitle.setAlignment(Pos.CENTER);
        Label lblDepositTitle = new Label("DEPOSIT\n ");
        lblDepositTitle.setStyle("-fx-font-weight: bold");
        depositTitle.getChildren().add(lblDepositTitle);
        Label lblDepAccNum = new Label("Account#:");
        depositAccNum = new TextField();
        Label lblDepAmount = new Label("Amount:");
        depositAmt = new TextField();
        btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(this);
        btnDepositHome = new Button("Back");
        btnDepositHome.setOnAction(this);
      
        
        HBox depositMessage = new HBox();
        HBox depositMessage2 = new HBox();
        depositMessage.setAlignment(Pos.CENTER);
        depositMessage2.setAlignment(Pos.CENTER);
        lblDepositMessage = new Label("");
        lblDepositMessage2 = new Label("");
        lblDepositMessageErr = new Label("");
        lblDepositMessage.setTextFill(Color.web("#008000"));
        lblDepositMessage2.setTextFill(Color.web("#008000"));
        lblDepositMessageErr.setTextFill(Color.web("#DC143C"));
        lblDepositMessage.setStyle("-fx-font-weight: bold");
        lblDepositMessageErr.setStyle("-fx-font-weight: bold");
        depositMessage.getChildren().add(lblDepositMessage);
        depositMessage2.getChildren().add(lblDepositMessage2);
        depositMessage.getChildren().add(lblDepositMessageErr);
        
        VBox depositLayout = new VBox();
        depositLayout.setAlignment(Pos.CENTER_LEFT);
        depositLayout.getChildren().addAll(depositTitle,lblDepAccNum,depositAccNum,lblDepAmount,depositAmt,btnDeposit,btnDepositHome, depositMessage, depositMessage2);
        depositLayout.setStyle("-fx-background-color: lightcyan"); //set bg color
        depositScene = new Scene(depositLayout,500,500);
        
        
         
        //setting up Withdraw Scene
        HBox withdrawTitle = new HBox();
        withdrawTitle.setAlignment(Pos.CENTER);
        Label lblWithdrawTitle = new Label("WITHDRAW\n ");
        lblWithdrawTitle.setStyle("-fx-font-weight: bold");
        withdrawTitle.getChildren().add(lblWithdrawTitle);
        Label lblWithAccNum = new Label("Account#:");
        withdrawAccNum = new TextField();
        Label lblWithAmount = new Label("Amount:");
        withdrawAmt = new TextField();
        btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(this);
        btnWithdrawHome = new Button("Back");
        btnWithdrawHome.setOnAction(this);
        
        HBox withdrawMessage = new HBox();
        HBox withdrawMessage2 = new HBox();
        withdrawMessage.setAlignment(Pos.CENTER);
        withdrawMessage2.setAlignment(Pos.CENTER);
        lblWithdrawMessage = new Label("");
        lblWithdrawMessage2 = new Label("");
        lblWithdrawMessageErr = new Label("");
        lblWithdrawMessage.setTextFill(Color.web("#008000"));
        lblWithdrawMessage2.setTextFill(Color.web("#008000"));
        lblWithdrawMessageErr.setTextFill(Color.web("#DC143C"));
        lblWithdrawMessageErr.setStyle("-fx-font-weight: bold");
        lblWithdrawMessage.setStyle("-fx-font-weight: bold");
        withdrawMessage.getChildren().add(lblWithdrawMessage);
        withdrawMessage2.getChildren().add(lblWithdrawMessage2);
        withdrawMessage.getChildren().add(lblWithdrawMessageErr);
        
        VBox withdrawLayout = new VBox();
        withdrawLayout.setAlignment(Pos.CENTER_LEFT);
        withdrawLayout.getChildren().addAll(withdrawTitle,lblWithAccNum,withdrawAccNum,lblWithAmount,withdrawAmt,btnWithdraw,btnWithdrawHome,withdrawMessage,withdrawMessage2);
        withdrawLayout.setStyle("-fx-background-color: lightcyan"); //set bg color
        withdrawScene = new Scene(withdrawLayout,500,500);
        
        
         //setting up Withdraw Scene
        HBox transferTitle = new HBox();
        transferTitle.setAlignment(Pos.CENTER);
        Label lblTransferTitle = new Label("TRANSFER\n ");
        lblTransferTitle.setStyle("-fx-font-weight: bold");
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
        
        HBox transferMessage = new HBox();
        HBox transferMessage2 = new HBox();
        transferMessage.setAlignment(Pos.CENTER);
        transferMessage2.setAlignment(Pos.CENTER);
        lblTransferMessage = new Label("");
        lblTransferMessage2 = new Label("");
        lblTransferMessageErr = new Label("");
        lblTransferMessage.setTextFill(Color.web("#008000"));
        lblTransferMessage2.setTextFill(Color.web("#008000"));
        lblTransferMessageErr.setTextFill(Color.web("#DC143C"));
        lblTransferMessage.setStyle("-fx-font-weight: bold");
        lblTransferMessageErr.setStyle("-fx-font-weight: bold");
        transferMessage.getChildren().add(lblTransferMessage);
        transferMessage2.getChildren().add(lblTransferMessage2);
        transferMessage.getChildren().add(lblTransferMessageErr);
        
       
        VBox transferLayout = new VBox();
        transferLayout.setAlignment(Pos.CENTER_LEFT);
        transferLayout.getChildren().addAll(transferTitle,lblTransferAccFrom,transferAccNumFrom,lblTransferAccTo,transferAccNumTo,lblTransferAmount, transferAmount,btnTransfer,btnTransferHome, transferMessage, transferMessage2);
        transferLayout.setStyle("-fx-background-color: lightcyan");
        transferScene = new Scene(transferLayout,500,500);
        
        // setting up List Scene
        Label lblShow = new Label("List of accounts...");
        accountList = new TextArea();
        btnListHome = new Button("Back");btnListHome.setOnAction(this);btnListHome.setMaxWidth(Double.MAX_VALUE);
        VBox listLayout =new VBox();
        listLayout.getChildren().addAll(lblShow,accountList,btnListHome);
        listLayout.setStyle("-fx-background-color: lightcyan");
        listScene = new Scene (listLayout,500,500);
         
        window.setScene(home);
        window.show();
    }
    
    public void stop(){
        
    }
    
    // Label lblAddMessageSucc,lblAddMessageFail, lblDepositMessageSucc,lblDepositMessageFail, lblWithdrawMessageSucc, lblWithdrawMessageFail,
    //        lblTransferMessageSucc, lblTransferMessageFail;
    public void handle(ActionEvent e){
        
        //open add menu
        if (e.getSource()==btnAddMenu){
            lblAddMessage.setText("");
            lblAddMessage2.setText("");
            lblAddMessageErr.setText("");
            window.setScene(addScene);
            
        }
        //Add a new customer account
        if (e.getSource()==btnAdd){
            lblAddMessage.setText("");
            lblAddMessage2.setText("");
            lblAddMessageErr.setText("");
            
            try{
                
                String name = custName.getText();
                long accNum = Long.parseLong(custAccNum.getText());
                double balance = Double.parseDouble(custBalance.getText());

                if( !name.isEmpty()){

                    if(bank.addAccount(accNum, balance, name)){

                    lblAddMessage.setText("Successfully added new account!");
                    lblAddMessage2.setText("\nAccount#: "+
                          accNum+"\tBalance: $"+balance+"\tName: "+name);
                    
                    }else{
                    
                        lblAddMessageErr.setText("Please change entered to valid acct. no. and/ valid amount..");
                    
                    }

                    }else{

                        lblAddMessageErr.setText("Please enter name input..");
                    }               
                custName.clear();
                custAccNum.clear();
                custBalance.clear();
                
            }catch(Exception error){
                
            lblAddMessageErr.setText("Please enter valid input..");
            
            }
            
            
        }
        
        //opens deposit window
        if (e.getSource()==btnDepositMenu){
            lblDepositMessage.setText("");
            lblDepositMessage2.setText("");
            lblDepositMessageErr.setText("");
            window.setScene(depositScene);
        }
        //deposit amount to account
        if (e.getSource()==btnDeposit){
            lblDepositMessage.setText("");
            lblDepositMessage2.setText("");
            lblDepositMessageErr.setText("");
            
            try{

                long accNum = Long.parseLong(depositAccNum.getText());
                double amount = Double.parseDouble(depositAmt.getText());
                
                if(bank.findAccount(accNum) != -1){
                    
                    if(amount > 0){
                        
                    bank.depositAccount(accNum, amount);
                    
                    lblDepositMessage.setText("Successfully deposited amount!");
                    lblDepositMessage2.setText("\n$"+amount+" to Account #:" +accNum);
                    
                    }else{
                        
                    lblDepositMessageErr.setText("Invalid Amount");
                    
                    }
                    
               }else{
                    
                    lblDepositMessageErr.setText("Invalid Account No.");
                
                }
             
                depositAccNum.clear();
                depositAmt.clear();
                
            }catch(Exception error){
                
                lblDepositMessageErr.setText("Please enter valid input..");

            }
            
        }
        
        //opens withdraw window
        if (e.getSource()==btnWithdrawMenu){
            lblWithdrawMessage.setText("");
            lblWithdrawMessage2.setText("");
            lblWithdrawMessageErr.setText("");
           
            window.setScene(withdrawScene);
        }
        //withdraw amount from account
        if (e.getSource()==btnWithdraw){
            
            lblWithdrawMessage.setText("");
            lblWithdrawMessage2.setText("");
            lblWithdrawMessageErr.setText("");
            
            try{
                
                long accNum = Long.parseLong(withdrawAccNum.getText());
                double amount = Double.parseDouble(withdrawAmt.getText());
                
               if(bank.findAccount(accNum) != -1){
                   
                    if(bank.withdrawAccount(accNum, amount)){
                    
                    lblWithdrawMessage.setText("Successfully withdrawn amount!");
                    lblWithdrawMessage2.setText(" \n$"+amount+" from Account #:" +accNum);
                    
                    }else{
                        
                    lblWithdrawMessageErr.setText("Amount is larger than your balance..");
                    }
                    
                }else{
                    lblWithdrawMessageErr.setText("Invalid Acct. No.");
                }
             
                withdrawAccNum.clear();
                withdrawAmt.clear();
               
            }catch(Exception error){
                
                lblWithdrawMessageErr.setText("Please enter valid input..");
            }
        }
        
        //opens transfer window
        if (e.getSource()==btnTransferMenu){
            lblTransferMessage.setText("");
            lblTransferMessage2.setText("");
            lblTransferMessageErr.setText("");
            window.setScene(transferScene);
        }
        //transfer amount
        if (e.getSource()==btnTransfer){
            lblTransferMessage.setText("");
            lblTransferMessage2.setText("");
            lblTransferMessageErr.setText("");
            
            try{
                
                long accNumFrom = Long.parseLong(transferAccNumFrom.getText());
                long accNumTo = Long.parseLong(transferAccNumTo.getText());
                double amount = Double.parseDouble(transferAmount.getText());
                
                if(bank.findAccount(accNumFrom) != -1 && bank.findAccount(accNumTo) != -1){
                
                    if(bank.transfer(accNumFrom, accNumTo, amount)){
                        
                        lblTransferMessage.setText("Successfully deposited amount!" );
                        lblTransferMessage2.setText("From Account #: "+accNumFrom+"\t$"+amount+"\tTo Account #:"+accNumTo);
                
                    }else{
                    
                        lblTransferMessageErr.setText("Entered amount is invalid..");
                    }
                
                
                }else{
                    
                    lblTransferMessageErr.setText("Please enter valid accounts..");

                }
            
                transferAccNumFrom.clear();
                transferAccNumTo.clear();
                transferAmount.clear();
                
            }catch(Exception error){
                
                lblTransferMessageErr.setText("Please enter valid input..");
            }
        }
        
        //open list accounts
        if (e.getSource()==btnListMenu){
            
            accountList.setText(bank.printAccounts());
            window.setScene(listScene);
            System.out.println(bank.printAccounts());
        }
        //home or back button pressed
        if (e.getSource()==btnHome || e.getSource()==btnListHome || e.getSource()==btnDepositHome || e.getSource()==btnWithdrawHome || e.getSource()==btnTransferHome){
            
            window.setScene(home);
        }
        
       
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}