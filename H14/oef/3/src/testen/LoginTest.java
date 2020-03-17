package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Login;

class LoginTest
{

    private Login log1, log2;

    @BeforeEach
    public void before()
    {
        log1 = new Login("Sonia vandermeersch4","jd20jd17");
        log2 = new Login();
    }

    @Test
    public void setGebruikersnaam_tweedeDeelNaamEindigtNietOpCijfer_werptException()
    {

        Assertions.assertThrows(IllegalArgumentException.class , () -> {log1.setGebruikersnaam("Sonia vandermeersch");});
    }

    @Test
    public void setWachtwoord_wachtwoordTeKort_werptException()
    {

        Assertions.assertThrows(IllegalArgumentException.class , () -> { log1.setWachtwoord("jd");});
    }

    @Test
    public void setGebruikersnaam_eersteDeelNaamGeenHoofdletter_werptException()
    {

        Assertions.assertThrows(IllegalArgumentException.class , () -> {   log1.setGebruikersnaam("sonia vandermeersch4");});
    }

    @Test
    public void setWachtwoord_wachtwoordBevat1Cijfer_werptException()
    {

        Assertions.assertThrows(IllegalArgumentException.class , () -> {   log1.setWachtwoord("jdkkk4");});
    }

    @Test
    public void setGebruikersnaam_eersteDeelNaamTeKort_werptException()
    {

        Assertions.assertThrows(IllegalArgumentException.class , () -> {    log1.setGebruikersnaam("An vandermeersch4");});
    }

    @Test
    public void setWachtwoord_wachtwoordMetHoofdletter_werptException()
    {

        Assertions.assertThrows(IllegalArgumentException.class , () -> {      log1.setWachtwoord("Jdkkk4l2");});
    }

    @Test
    public void setGebruikersnaam_nullWaarde_werptException()
    {

        Assertions.assertThrows(IllegalArgumentException.class , () -> {   log2.setGebruikersnaam(null);});
    }

    @Test
    public void setWachtwoord_wachtwoordNull_werptException()
    {

        Assertions.assertThrows(IllegalArgumentException.class , () -> {    log2.setWachtwoord(null);});
    }
}


