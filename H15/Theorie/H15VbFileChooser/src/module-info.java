module H15VbFileChooser {
	exports persistentie;
	exports gui;
	exports main;
	exports domein;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens gui to javafx.graphics, javafx.fxml;
}