package helloworld.entities;

import javax.persistence.*;

@Entity(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int client_id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;
}
