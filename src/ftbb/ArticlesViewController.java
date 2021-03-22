/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftbb;

import Enitity.Article;
import Service.ServiceArticle;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Passable;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ArticlesViewController implements Initializable {

    @FXML
    private ScrollPane articles_scroller;
    @FXML
    private VBox vbox_articles;
    
    private List<Article> articles;
    @FXML
    private TextField filter;
    @FXML
    private ComboBox<String> sort;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sort.getItems().add("Sort...");
        sort.getItems().add("Sort by most liked");
        sort.getItems().add("Sort by highest comments");
        refreshArticle(null);
        filter.textProperty().addListener((observable, oldValue, newValue) -> {
            ServiceArticle sa = new ServiceArticle();
            this.articles =  sa.searchArticle(newValue);
             loadArticles(this.articles);
        });
    }    

    @FXML
    private void addArticle(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
            Pane root1 =  fxmlLoader.load(getClass().getResource("FXMLArticlesEditor.fxml").openStream());
            Passable p = Passable.getInstance();
            p.setNumberData(0);
            Stage stage = new Stage();
            stage.setTitle("Article Editor");
            stage.setScene(new Scene(root1));  
            stage.show();
    }

    @FXML
    private void refreshArticle(ActionEvent event) {
        ServiceArticle sa = new ServiceArticle();
            this.articles =  sa.showArticle();
          loadArticles(this.articles);
    }
    
    private void loadArticles(List<Article> list){
        this.vbox_articles.getChildren().clear();
            try{
                for(Article a : list){
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("FXMLPostsAdmin.fxml"));
                    Node postbox = loader.load();
                    PostsAdminController pc = loader.getController();
                    pc.setData(a);
                    this.vbox_articles.getChildren().add(postbox);
                }
            }catch(IOException e){
                   e.printStackTrace();
            }
    }
    @FXML
    private void onSelected(ActionEvent event) {
        int i = this.sort.getSelectionModel().getSelectedIndex();
        ServiceArticle sa = new ServiceArticle();
        if(i == 1){
            //sort by likes
           List<Article> l = sa.sortByLikes();
           loadArticles(l);
        }else{
            if(i == 2){
                    //sort by comments
                     List<Article> l = sa.sortByComments();
           loadArticles(l);
            }
        }
    }
    
}
