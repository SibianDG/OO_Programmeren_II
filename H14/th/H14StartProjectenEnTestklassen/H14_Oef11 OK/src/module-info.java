module H14_Oef11 {
	exports gui;
	exports main;
	exports domein;
	exports testen;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires org.junit.jupiter.api;
	
	opens main to javafx.graphics, javafx.fxml;
}