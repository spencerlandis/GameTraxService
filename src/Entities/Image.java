package Entities;

import javax.persistence.*;

/**
 * Created by spencerlandis on 4/19/14.
 */
@Entity @Table(name = "image")
public class Image {
    private Integer image_id;
    private String iconUrl;
    private String mediumUrl;
    private String screenUrl;
    private String smallUrl;
    private String thumbUrl;
    private String tinyUrl;

    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    @Basic
    @Column(name = "icon_url")
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Basic
    @Column(name = "medium_url")
    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    @Basic
    @Column(name = "screen_url")
    public String getScreenUrl() {
        return screenUrl;
    }

    public void setScreenUrl(String screenUrl) {
        this.screenUrl = screenUrl;
    }

    @Basic
    @Column(name = "small_url")
    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    @Basic
    @Column(name = "thumb_url")
    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    @Basic
    @Column(name = "tiny_url")
    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (iconUrl != null ? !iconUrl.equals(image.iconUrl) : image.iconUrl != null) return false;
        if (image_id != null ? !image_id.equals(image.image_id) : image.image_id != null) return false;
        if (mediumUrl != null ? !mediumUrl.equals(image.mediumUrl) : image.mediumUrl != null) return false;
        if (screenUrl != null ? !screenUrl.equals(image.screenUrl) : image.screenUrl != null) return false;
        if (smallUrl != null ? !smallUrl.equals(image.smallUrl) : image.smallUrl != null) return false;
        if (thumbUrl != null ? !thumbUrl.equals(image.thumbUrl) : image.thumbUrl != null) return false;
        if (tinyUrl != null ? !tinyUrl.equals(image.tinyUrl) : image.tinyUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = image_id != null ? image_id.hashCode() : 0;
        result = 31 * result + (iconUrl != null ? iconUrl.hashCode() : 0);
        result = 31 * result + (mediumUrl != null ? mediumUrl.hashCode() : 0);
        result = 31 * result + (screenUrl != null ? screenUrl.hashCode() : 0);
        result = 31 * result + (smallUrl != null ? smallUrl.hashCode() : 0);
        result = 31 * result + (thumbUrl != null ? thumbUrl.hashCode() : 0);
        result = 31 * result + (tinyUrl != null ? tinyUrl.hashCode() : 0);
        return result;
    }
}
