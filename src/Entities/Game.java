package Entities;

import javax.persistence.*;

/**
 * Created by spencerlandis on 4/19/14.
 */
@Entity @Table(name = "game")
public class Game {
    private Integer game_id;
    private String name;
    private String deck;
    private String siteDetailUrl;
    private Image image;

    @Id
    @Column(name = "game_id")
    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "deck")
    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    @Basic
    @Column(name = "site_detail_url")
    public String getSiteDetailUrl() {
        return siteDetailUrl;
    }

    public void setSiteDetailUrl(String siteDetailUrl) {
        this.siteDetailUrl = siteDetailUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (deck != null ? !deck.equals(game.deck) : game.deck != null) return false;
        if (game_id != null ? !game_id.equals(game.game_id) : game.game_id != null) return false;
        if (name != null ? !name.equals(game.name) : game.name != null) return false;
        if (siteDetailUrl != null ? !siteDetailUrl.equals(game.siteDetailUrl) : game.siteDetailUrl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = game_id != null ? game_id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (deck != null ? deck.hashCode() : 0);
        result = 31 * result + (siteDetailUrl != null ? siteDetailUrl.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "image", referencedColumnName = "image_id", nullable = false)
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
