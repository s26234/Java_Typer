module com.mj.typer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mj.typer to javafx.fxml;
    exports com.mj.typer;
}