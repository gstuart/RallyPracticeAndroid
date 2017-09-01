package crazyeels.akcrallypractice.models;

import java.net.URL;

public class Card {
    private Integer cardNumber;
    private String cardDetail;
    private String level;
    private String image;
    private URL videoLink;

    public Card(Integer number, String detail, String level, String image, URL videoLink) {
        this.cardNumber = number;
        this.cardDetail = detail;
        this.level = level;
        this.image = image;
        this.videoLink = videoLink;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public String getCardDetail() {
        return cardDetail;
    }

    public String getLevel() {
        return level;
    }

    public String getImage() {
        return image;
    }

    public URL getVideoLink() { return videoLink; }

}
