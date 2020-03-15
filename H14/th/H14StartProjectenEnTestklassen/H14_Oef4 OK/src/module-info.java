module H14_Oef4 {


	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires org.junit.jupiter.api;
	
	opens main to javafx.graphics, javafx.fxml;
}