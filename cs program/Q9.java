/*
 Q9. Implement a Bank Account having Instance variables: Account Number, Balance and having methods:
     float Deposit (float x)
     float withdraw (float x)
     int get account no ()
     float get balance ()
     tax deduction ()
     Then implement class Bank having an array list of accounts of type BankAccount.
     Implement following methods:
     AddAccount in Bank
     Get Total balance in Bank
     Get account number with max. and min. balance Find an account given a bank account no.
     Count no. of accounts having atleast specific balance
 */
package javapractical;

/**
 *
 * @author SH
 */
public class Q9 {
     public static void main(String args[]){
        Bank PNB=new Bank("PNB");
        for(int i=0;i<100;i++){
            PNB.AddAccount();
        }
        PNB.getAccount(60).Deposit(1000);
        PNB.getAccount(60).withdraw(999);
        System.out.print(PNB.getAccount(60).getBalance());
    }
}
class BankConstant{
    public static float TotalBalance=0;
    public static float MinimumBalance=100;
    public static float PercentageofTax=5;
    public static int MaxBankAccounts=100;
    public static int TotalAccounts=0;
    public static String Msg="";
}
class BankAccount{
    private int AccountNumber;
    private float Balance;
    BankAccount(int AccountNumber){
        this.AccountNumber=AccountNumber;
        this.Balance=0;
    }
    float Deposit (float x){
        this.Balance+=x;
        BankConstant.TotalBalance+=x;
        return this.Balance;
    }
    float withdraw (float x){
        if(this.Balance-x>BankConstant.MinimumBalance){
            this.Balance-=x;
            BankConstant.TotalBalance-=x;
        }
        else BankConstant.Msg="Balance is less than : "+BankConstant.MinimumBalance;
        return this.Balance;
    }
    int getAccountNo (){
        return this.AccountNumber;
    }
    float getBalance (){
        return this.Balance;
    }
    float deduction (){
        return this.Balance*(BankConstant.PercentageofTax/100);
    }
}
class Bank{
    private BankAccount Accounts [];
    String Name;
    Bank(String Name){
        this.Name=Name;
        this.Accounts=new BankAccount[BankConstant.MaxBankAccounts];
    }
    boolean AddAccount(){
        boolean flag=false;
        try{
            this.Accounts[BankConstant.TotalAccounts]=new BankAccount(++BankConstant.TotalAccounts);
            flag=true;
        }
        catch(ArrayIndexOutOfBoundsException e){
            BankConstant.Msg=e.getMessage();
        }
        return flag;
    }
    float getTotalBalance(){
        return BankConstant.TotalBalance;
    }
    int getAccountWithMaxBalance(){
        int Account=1;
        for(int i=0;i<Accounts.length;i++){
            if(Accounts[i].getBalance()>Accounts[Account].getBalance())Account=Accounts[i].getAccountNo();
        }
        return Account;
    }
    int getAccountWithMinBalance(){
        int Account=1;
        for(int i=0;i<Accounts.length;i++){
            if(Accounts[i].getBalance()<Accounts[Account].getBalance())Account=Accounts[i].getAccountNo();
        }
        return Account;
    }
    BankAccount getAccount(int AccountNo){
        for(int i=0;i<this.Accounts.length;i++){
            if(this.Accounts[i].getAccountNo()==AccountNo)return this.Accounts[i];
        }
        return null;
    }
    int CountAccountWithSpecficBalance(float specBalance){
        int sum=0;
        for(int i=0;i<Accounts.length;i++){
            if(Accounts[i].getBalance()>specBalance)sum++;
        }
        return sum;
    }
}
