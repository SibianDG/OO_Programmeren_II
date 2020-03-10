module FXVoorbeeld7 {
	exports gui;
	exports main;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	
	opens gui to javafx.graphics;
}