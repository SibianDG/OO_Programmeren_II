package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import domein.Thermometer;

public class ThermometerTest {
	private Thermometer t;

	@BeforeEach
	public void before() {
		t = new Thermometer();
	}

	@Test
	public void maakThermometer_defaultWaardeAantalGraden_maaktObject() {
		Assertions.assertEquals(32, t.getAantalGraden());
	}

	@Test
	public void maakThermometer_aantalGraden14_maaktObject() {
		t = new Thermometer(14);
		Assertions.assertEquals(14, t.getAantalGraden());
	}


    @Test 
    public void maakThermometer_aantalGraden105_geeftException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> {new Thermometer(105);});
    }

	@Test
	public void maakThermometer_aantalGraden104_maaktObject() {
		t = new Thermometer(104);
		Assertions.assertEquals(104, t.getAantalGraden());
	}


    @Test 
    public void maakThermometer_aantalGraden13_geeftException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> {new Thermometer(13);});
    }
	
	@Test
	public void converteerNaarCelcius_50F_geeft10C() {
		t = new Thermometer(50);
		int conversie = t.converteerNaarCelcius();
		Assertions.assertEquals(10, conversie);
	}

	@Test
	public void converteerNaarCelcius_35F_geeft1C() {
		t = new Thermometer(35);
		int conversie = t.converteerNaarCelcius();
		Assertions.assertEquals(1, conversie);
	}

    @Test
    public void stelAantalGradenIn_1a2b3c_geeftFout()
    {
    	Assertions.assertThrows(NumberFormatException.class , () -> {t.stelAantalGradenIn("1a2b3c");;});
        
    }

    @Test
    public void stelAantalGradenIn_13_geeftFout()
    {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> {t.stelAantalGradenIn("13");;});
        
    }
    
    @Test
    public void stelAantalGradenIn_56_steltTemperatuurIn()
    {
    	t.stelAantalGradenIn("56");
    	Assertions.assertEquals(56, t.getAantalGraden());
    }
}