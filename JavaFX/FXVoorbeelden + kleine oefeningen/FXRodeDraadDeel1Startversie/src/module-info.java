module FXRodeDraadDeel1Startversie {
	exports persistentie;
	exports main;
	exports domein;

	requires javafx.base;
	requires javafx.graphics;
	requires javafx.controls;
	
	opens gui to javafx.graphics;
}