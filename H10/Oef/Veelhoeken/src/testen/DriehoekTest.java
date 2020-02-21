package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Driehoek;

public class DriehoekTest
{

	private Driehoek driehoek1, driehoek2;

	@BeforeEach
	public void before()
	{       
		driehoek1 = new Driehoek(3, 4, 5);
		driehoek2 = new Driehoek(1, 2, 3);
	}

	@Test
	public void maakDriehoek_zijdeAFout_werptException()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Driehoek(0, 2, 3));
	}

	@Test
	public void maakDriehoek_zijdeBFout_werptException()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Driehoek(2, 0, 3));
	}

	@Test
	public void maakDriehoek_zijdeCFout_werptException()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Driehoek(2, 3, 0));
	}

	@Test
	public void isRechthoekigeDriehoek_retourneertTrue()
	{
		Assertions.assertEquals(true, driehoek1.isRechthoekigeDriehoek());
	}

	@Test
	public void isRechthoekigeDriehoek_retourneertFalse()
	{
		Assertions.assertEquals(false, driehoek2.isRechthoekigeDriehoek());
	}
}
