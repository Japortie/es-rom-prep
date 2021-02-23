package eu.mschuette.psx.rommanager;

import java.util.Objects;

public class Game {
    private String path;
    private String name;
    private String thumbnail;
    private String image;
    private String marquee;
    private String video;
    private String rating;
    private String desc;
    private String releasedate;
    private String developer;
    private String publisher;
    private String genre;
    private String players;

    public Game() {
    }

    public Game(String path, String name, String thumbnail, String image, String marquee, String video, String rating, String desc, String releasedate, String developer, String publisher, String genre, String players) {
        this.path = path;
        this.name = name;
        this.thumbnail = thumbnail;
        this.image = image;
        this.marquee = marquee;
        this.video = video;
        this.rating = rating;
        this.desc = desc;
        this.releasedate = releasedate;
        this.developer = developer;
        this.publisher = publisher;
        this.genre = genre;
        this.players = players;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMarquee() {
        return marquee;
    }

    public void setMarquee(String marquee) {
        this.marquee = marquee;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(path, game.path) && Objects.equals(name, game.name) && Objects.equals(thumbnail, game.thumbnail) && Objects.equals(image, game.image) && Objects.equals(marquee, game.marquee) && Objects.equals(video, game.video) && Objects.equals(rating, game.rating) && Objects.equals(desc, game.desc) && Objects.equals(releasedate, game.releasedate) && Objects.equals(developer, game.developer) && Objects.equals(publisher, game.publisher) && Objects.equals(genre, game.genre) && Objects.equals(players, game.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, name, thumbnail, image, marquee, video, rating, desc, releasedate, developer, publisher, genre, players);
    }

    @Override
    public String toString() {
        return "Game{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", image='" + image + '\'' +
                ", marquee='" + marquee + '\'' +
                ", video='" + video + '\'' +
                ", rating='" + rating + '\'' +
                ", desc='" + desc + '\'' +
                ", releasedate='" + releasedate + '\'' +
                ", developer='" + developer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", players='" + players + '\'' +
                '}';
    }
}
