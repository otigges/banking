package inspired.tx.domain;

import inspired.tx.domain.Types.Balance;
import inspired.tx.domain.Types.Currency;
import inspired.tx.domain.Types.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * This log contains transactions for an account.
 */
public abstract class TransactionLog {

    private final Currency currency;

    protected TransactionLog(Currency currency) {
        this.currency = currency;
    }

    public Balance calculateBalance() {
        return calculateBalance(LocalDate.now());
    }

    public Balance calculateBalance(LocalDate bookingDate) {
        BigDecimal sum = transactions().map(tx -> tx.amount().amount()).reduce(BigDecimal.ZERO, BigDecimal::add);
        return new Balance(new Types.MonetaryAmount(sum, currency), bookingDate);
    }

    protected abstract Stream<Transaction> transactions();
    protected abstract Stream<Transaction> transactionsSince(LocalDate bookingDate);
    protected abstract long transactionsSize();

}
