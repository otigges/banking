package inspired.tx.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

public final class Types {

    public record IBAN(String iban){}
    public record Currency(String code, String name){}
    public record BIC(String bic){}
    public record AccountHolder(String id, String name){}
    public record MonetaryAmount(BigDecimal amount, Currency currency){}
    public record Balance(MonetaryAmount amount, LocalDate bookingDate){}
    public record Transaction(
        String id,
        Account.AccountRef payer,
        Account.AccountRef payee,
        MonetaryAmount amount,
        Instant initiationTime,
        LocalTime bookingDate,
        LocalTime valueDate){}

}
