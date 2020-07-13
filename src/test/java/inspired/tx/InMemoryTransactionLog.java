package inspired.tx;

import inspired.tx.domain.Currencies;
import inspired.tx.domain.TransactionLog;
import inspired.tx.domain.Types.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InMemoryTransactionLog extends TransactionLog {

    private final List<Transaction> transactions = new ArrayList<>();

    public InMemoryTransactionLog() {
        super(Currencies.EUR);
    }

    @Override
    protected Stream<Transaction> transactions() {
        return transactions.stream();
    }

    @Override
    protected Stream<Transaction> transactionsSince(LocalDate bookingDate) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    protected long transactionsSize() {
        return transactions.size();
    }
}
