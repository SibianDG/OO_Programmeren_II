module ExamenKaartSpel
{
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	
	opens startup to javafx.graphics;
    opens gui to javafx.graphics;
}