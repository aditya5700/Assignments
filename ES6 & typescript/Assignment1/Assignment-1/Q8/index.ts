export{}
class Account{
    id: any;
    name: any;
    balance: any;
    constructor(id, name, balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    totalBalance(){
        return this.balance;
    }
} 

class SavingAccount extends Account{
    constructor(id, name, balance, interest){
        super(id, name, balance = balance + (balance*interest)/100);
    }
}

class CurrentAccount extends Account{
    constructor(id, name, balance, cash_credit){
        super(id, name, balance = balance+cash_credit);
    }
}

let savingAccount = new SavingAccount(11721, "Aditya", 10000, 5);
let currentAccount = new CurrentAccount(11722, "Atul", 14000, 12);

console.log(savingAccount.totalBalance());
console.log(currentAccount.totalBalance());