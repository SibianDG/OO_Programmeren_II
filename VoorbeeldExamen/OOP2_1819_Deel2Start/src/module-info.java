module OOP2_1819_Deel2 {	

	exports gui;
	exports main;
	exports domein;
	exports testen;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	requires org.junit.jupiter.api;
	
	opens gui to javafx.graphics, javafx.fxml;
}