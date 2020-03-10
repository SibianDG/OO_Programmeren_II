module FXVoorbeeld1 {
	exports gui;
	exports main;

	requires javafx.base;
	requires javafx.graphics;
	requires javafx.controls;
	
	opens gui to javafx.graphics;
}
