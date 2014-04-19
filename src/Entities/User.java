package Entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by spencerlandis on 4/19/14.
 */
@Entity @Table(name = "user")
public class User {
    private Integer user_id;
    private String email;
    private String password;
    private List<Game> games;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (user_id != null ? !user_id.equals(user.user_id) : user.user_id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user_id != null ? user_id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @ManyToMany
    @JoinTable(name = "user_game", catalog = "slandis", schema = "", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "game_id", nullable = false))
    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
