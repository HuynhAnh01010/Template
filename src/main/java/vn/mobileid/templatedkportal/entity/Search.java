package vn.mobileid.templatedkportal.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Search {
    private String idSearchMST;
    
    public Search() {
        super();
    }

    public Search(String idSearchMST) {
        this.idSearchMST = idSearchMST;
    }
}
