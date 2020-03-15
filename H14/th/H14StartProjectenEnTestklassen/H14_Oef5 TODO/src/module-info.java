module H14_Oef5 {
	exports main;
	exports gui;
	exports domein;
	exports testen;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires org.junit.jupiter.api;
	
	opens main to javafx.graphics, javafx.fxml;
}