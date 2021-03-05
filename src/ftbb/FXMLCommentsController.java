/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftbb;

import Enitity.Article;
import Enitity.Comment;
import Service.ServiceComment;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.Utilities;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FXMLCommentsController implements Initializable {

    @FXML
    private TableView<Comment> listcomments;
    @FXML
    private Button ref_but;
    @FXML
    private Button ban_but;
    
    @FXML
    private TextField article_id;
    
    
    @FXML
    private AnchorPane panecom;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       refreshComment(null);
    }    
    public void receiveId(String id){
        article_id.setText(id);
    }
    @FXML
    private void refreshComment(ActionEvent event) {
        ServiceComment sc = new ServiceComment();
        TableColumn t8 = new TableColumn("Client Name");
        t8.setCellValueFactory(new PropertyValueFactory<Comment, String>("client_id"));
        TableColumn t9 = new TableColumn("Content");
        t9.setCellValueFactory(new PropertyValueFactory<Comment, String>("content"));
        listcomments.getColumns().addAll(t8,t9);
        String i = "63438507";
        List<Comment> l = sc.showComment(i);
        ObservableList<Comment> data =FXCollections.observableArrayList(l);
        listcomments.setItems(data);
    }

    @FXML
    private void banComment(ActionEvent event) {
        Comment c = listcomments.getSelectionModel().getSelectedItem();
        if(c == null){
             Utilities.alert("WARNING!", "Please select a comment from the list.");
        }else{
            ServiceComment sc = new ServiceComment();
            sc.delComment(c);
        }
    }

    
    
}
