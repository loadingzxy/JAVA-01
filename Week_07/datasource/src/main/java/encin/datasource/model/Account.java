package encin.datasource.model;

import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


@Data
@Table(name = "account")
@ToString
public class Account {

    private String username;

    private String password;

}
