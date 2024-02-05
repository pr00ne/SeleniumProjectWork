package hu.masterfield.datatypes;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

/**
 * A Savings típusú accountok megadásakor használt adatok osztályba szervezése.
 */
public class Saving {
    //fiók típusa
    // Saving
    // Money Matket
    @CsvBindByName(column = "accountTypes")
    private String accountTypes;

    //tulajdonos típus
    // Individual
    // Joint
    @CsvBindByName(column = "ownershipTypes")
    private String ownershipTypes;

    // accout name
    @CsvBindByName(column = "accountName")
    private String accountName;

    // opening balance
    @CsvBindByName(column = "openingBalance")
    private String openingBalance;
}