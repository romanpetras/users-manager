package eu.circletouch.users.beans;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class User {

    private Long id;
    private String username;
    private String lastName;
    private String firstName;
    private String email;
    private Long companyId;

    private List<UsersGroup> groups = new LinkedList<>();
    private Company company;
}
