package eu.circletouch.users.beans;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Company {

    private Long id;
    private String code;
    private String name;
    private String vatNumber;
    private String vatCountryCode;

    private List<CompanyRole> companyRoles = new LinkedList<>();

}
