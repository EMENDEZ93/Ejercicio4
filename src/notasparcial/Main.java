package notasparcial;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
/*
 * @author Edwin Mendez
 */

public class Main extends Application {
 
     
//contador para el promedio    
    int Promedio;
    
//variables para cada columna     
    String Column1 = "A";
    String Column2 = "B";
    String Column3 = "C";
    
//variable toma valor del resultado con respecto al promedio   
    String value3;    

//contenedor de los datos de las columnas    
    ObservableList<Map> allData = FXCollections.observableArrayList();

    //columnas de la tabla
        TableColumn<Map, String> Name = new TableColumn<>("Nombre");
        TableColumn<Map, String> Note = new TableColumn<>("Nota");
        TableColumn<Map, String> Answer = new TableColumn<>("Resultado");
    
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Ejercicio 4");
        stage.setWidth(450);
        stage.setHeight(540);
        
    //titulo y muestra para el promedio    
        Label label = new Label("- Parcial -");
        label.setFont(new Font("Arial", 20));

    //toma de variables con la que se evaluan cada columna y tamaño     
        Name.setCellValueFactory(new MapValueFactory(Column1));
        Name.setMinWidth(130);
        Note.setCellValueFactory(new MapValueFactory(Column2));
        Note.setMinWidth(130);
        Answer.setCellValueFactory(new MapValueFactory(Column3));
        Answer.setMinWidth(130);

        TableView tableView = new TableView<>(allData);
        tableView.getColumns().setAll(Name,Note,Answer);     

    //generador de notas y accion en la tablas    
        Button Act = new Button("Actualizar");
        Act.setOnAction( event -> BActionAcutalizar(label) );
        
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label,tableView,Act);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();
    }
 
    private void BActionAcutalizar(Label label) {
     
    //limpiar para generar otros valores    
        allData.clear();
        
    //arreglo de estudiantes    
        Estudiante[] estudiante = new Estudiante[30];   

    //declaracion en cero para nuevos eventos y generar promedios futuros    
        Promedio = 0;    
        
    //Dar valores aleatoriamente         
        for (int i = 0; i < estudiante.length; i++) {
            
    //dar valores de nombre y notas al arreglo de objetos "estudiantes"       
        estudiante[i] = new Estudiante("Estudiante " + ( 1 + i ),(int)(Math.random()*6));
        
    //suma de notas    
        Promedio += estudiante[i].getNota();
               
        }
    
    //promedio    
        Promedio /=estudiante.length;
    //titulo y Actualizacion del promedio    
        label.setText("- Parcial - Promedio / " + Promedio);
     //System.out.println(Promedio);
        
    //Imprimir en las tablas    
        for (int i = 0; i < estudiante.length; i++) {
        
        //condicionales para el resultado con respecto al promedio    
            if (estudiante[i].getNota() > Promedio) {
               value3 ="Superior";
            }else if (estudiante[i].getNota() < Promedio) {                
               value3 = "Inferior";    
            }else if (estudiante[i].getNota() == Promedio) {
               value3 = "Igual";    
            }
        //_________________________________________________________    
            
        
            Map<String, String> dataRow = new HashMap<>();

        //conversion de Integer a String por motivos de tablas   
            String value2 = String.valueOf(estudiante[i].getNota());

        //introducciendo valores a las columnas    
            dataRow.put(Column1, estudiante[i].getNombre());
            dataRow.put(Column2, value2);
            dataRow.put(Column3, value3);

        //toma de valores de columnas a tabla   
            allData.add(dataRow);

         }
    }


}