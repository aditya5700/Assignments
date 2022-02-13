package Assignment4;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.AssignmentQ4")

public class Config {public BankAccount getBankAccount(){
    BankAccount bankAccount1 = new BankAccount(5498,"Aditya Yadav",
            "Saving",50000);
    return bankAccount1;
}

    @Bean
    public BankAccount getBankAccount1(){
        BankAccount bankAccount1 = new BankAccount(5496,"Swanand Adai",
                "Current",60000);
        return bankAccount1;
    }


}
