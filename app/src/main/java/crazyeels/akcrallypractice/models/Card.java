package crazyeels.akcrallypractice.models;

import java.net.URL;

public class Card {
    private Integer cardNumber;
    private String cardDetail;
    private String level;
    private URL image;

    public Card(Integer number, String detail, String level, URL image) {
        this.cardNumber = number;
        this.cardDetail = detail;
        this.level = level;
        this.image = image;
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

    public URL getImage() {
        return image;
    }
}
