package inspired.tx.domain;

import inspired.tx.domain.Types.AccountHolder;
import inspired.tx.domain.Types.BIC;
import inspired.tx.domain.Types.Balance;
import inspired.tx.domain.Types.IBAN;

public class Account {

    private IBAN iban;
    private BIC bic;
    private AccountHolder holder;
    private TransactionLog transactions ;

    public Account(IBAN iban, BIC bic, AccountHolder holder, TransactionLog transactions) {
        this.iban = iban;
        this.bic = bic;
        this.holder = holder;
        this.transactions = transactions;
    }

    public AccountRef toRef() {
        return new AccountRef(iban, bic, holder);
    }

    public record AccountRef(IBAN iban, BIC bic, AccountHolder holder) {
    }

    public Balance getBalance() {
        return transactions.calculateBalance();
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban=" + iban +
                ", bic=" + bic +
                ", holder=" + holder +
                '}';
    }
}
