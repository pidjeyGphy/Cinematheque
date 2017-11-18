package Test;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 
 * @author Pierre-Joseph
 */
@ManagedBean
@SessionScoped
public class ImagesView {
    private List<String> pictures;

    public ImagesView() {
    }
    
    
    @PostConstruct
    public void init(){
        pictures = new ArrayList<>();
        for (int i = 1; i<=13  ; i++){
            pictures.add("T"+i+".JPG");
        }
    }
    
    public List<String> getPictures(){
        return pictures;
        
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
    
    
    
    
}