/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entites.Feedback;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author narug
 */
public interface IServicesFeedback {
    public List<Feedback> ShowFeedback() throws SQLException;
    public void AddFeedback(Feedback f);
    public void DeleteFeedback(Feedback f);
    public void ModifyFeedback(Feedback f );
}