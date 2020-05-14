package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domein.*;

public class BonusCodeTest {

    private BonusCode bc1, bc2;

    @Test
    public void controleerBonusCode_normaal_OK() {
        bc1 = new BonusCode("A12345ABC");
    }

    @Test
    public void controleerBonusCode_kleineLetters_exception() {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new BonusCode("AbC12345AbC");});
    }

    @Test
    public void controleerBonusCode_begintNietMetB_exception() {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new BonusCode("B12345ACD");});
    }

    @Test
    public void controleerBonusCode_nietGenoegLetters_exception() {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new BonusCode("A12345BC");});
    }

    @Test
    public void controleerBonusCode_nietGenoegCijfers_exception() {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new BonusCode("A1234BCD");});
    }

    @Test
    public void controleerBonusCode_teveelCijfers_exception() {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new BonusCode("A123456BCD");});
    }

    @Test
    public void controleerBonusCode_vreemdeTekensBijCijfers_exception() {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new BonusCode("A12$45BCD");});
    }

    @Test
    public void controleerBonusCode_vreemdeTekensBijLetters_exception() {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new BonusCode("A12345$BC");});
    }

    @Test
    public void controleerBonusCode_cijfersBijLetters_exception() {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new BonusCode("A12345B4C");});
    }

    @Test
    public void controleerBonusCode_lettersBijCijfers_exception() {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new BonusCode("A123A5BCD");});
    }

    @Test
    public void equals_gelijk_true() {
        bc1 = new BonusCode("A12345BCD");
        bc2 = new BonusCode("A12345BCD");

        assertEquals(bc1, bc2);
    }

    @Test
    public void equals_verschillend_false() {
        bc1 = new BonusCode("A12345ABC");
        bc2 = new BonusCode("A67890ABC");

        assertNotEquals(bc1, bc2);
    }

    @Test
    public void equals_StringEnCode_false() {
        bc1 = new BonusCode("A12345ABC");

        assertNotEquals(bc1, "test");
    }

    @Test
    public void equals_nullEnCode_false() {
        bc1 = new BonusCode("A12345ABC");

        assertNotEquals(bc1, null);
    }
    
    @Test
    public void zijnOpeenvolgendeBonusCodes_gelijk_true() {
        bc1 = new BonusCode("A12345ABC");
        bc2 = new BonusCode("A12345ABC");
        assertTrue(BonusCode.zijnOpeenvolgendeBonusCodes(bc1, bc2));
    }
    
    @Test
    public void zijnOpeenvolgendeBonusCodes_binnen150_true() {
        bc1 = new BonusCode("A10000ABC");
        bc2 = new BonusCode("A10050ABC");
        assertTrue(BonusCode.zijnOpeenvolgendeBonusCodes(bc1, bc2));
    }
    
    @Test
    public void zijnOpeenvolgendeBonusCodes_150_true() {
        bc1 = new BonusCode("A10000ABC");
        bc2 = new BonusCode("A10150ABC");
        assertTrue(BonusCode.zijnOpeenvolgendeBonusCodes(bc1, bc2));
    }
    
    @Test
    public void zijnOpeenvolgendeBonusCodes_151_false() {
        bc1 = new BonusCode("A10000ABC");
        bc2 = new BonusCode("A10151ABC");
        assertFalse(BonusCode.zijnOpeenvolgendeBonusCodes(bc1, bc2));
    }
    
    @Test
    public void zijnOpeenvolgendeBonusCodes_lettersOngelijk_false() {
        bc1 = new BonusCode("A10000ABC");
        bc2 = new BonusCode("A10001DEF");
        assertFalse(BonusCode.zijnOpeenvolgendeBonusCodes(bc1, bc2));
    }
}
