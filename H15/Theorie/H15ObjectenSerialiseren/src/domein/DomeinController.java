package domein;

import java.util.List;

public class DomeinController {

    private final AccountRecordRepository arRepos;

    public DomeinController() {
        arRepos = new AccountRecordRepository();
    }

    public void schrijfAccountRecordWeg(int rekeningnr, String voornaam, String familienaam, double bedrag) {

        AccountRecord ar = new AccountRecord(rekeningnr, voornaam, familienaam, bedrag);

        arRepos.voegToe(ar);
    }

    public void sluitAf() {

        arRepos.sluitAf();
    }

    public String leesAccountsUitBestand() {
        StringBuilder uitvoer = new StringBuilder();
        List<AccountRecord> lijst = arRepos.geefAlleAccounts();
        for (AccountRecord record : lijst) {
            uitvoer.append(String.format("%-10d%-12s%-12s%10.2f\n",
                    record.getAccount(), record.getFirstName(),
                    record.getLastName(), record.getBalance()));
        }
        return uitvoer.toString();
    }
}
