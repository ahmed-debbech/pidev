/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Enitity.Like;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public interface IServiceLikes {
    public void add(Like k);
    public void remove(Like k);
    public boolean isExisted(Like k);
    public boolean getLike(int art, int cmt, int cl);
    public int countLikes(int art, int cmt);
}
