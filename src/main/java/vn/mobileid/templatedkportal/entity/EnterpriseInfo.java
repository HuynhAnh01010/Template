package vn.mobileid.templatedkportal.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnterpriseInfo {

    private String name;
    private String taxCode;
    private String province;
    private String location;
    private String address;
    private String presentativeName;
    private String link;

    public String getAddress() {
        if (address == null) {
            return location + ", " + province;
        } else {
            return address;
        }
    }
}
