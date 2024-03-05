package src.MagazineStuff;

public class Magazine {
    private String name;
    private String genre;
    private String content;
    private String author;

    public Magazine(String name, String genre, String content, String author) {
        this.name = name;
        this.genre = genre;
        this.content = content;
        this.author = author;
    }
    
    public void displayContent() {
        System.out.println(content);
    }
    
    public String getName() {
        return name;
    }
    
    public String getGenre() {
        return genre;
    }
    public String getAuthor() {
        return author;
    }
    public void changeName(String name) {
        this.name = name;
    }
    public void changeGenre(String genre) {
        this.genre = genre;
    }
    public void changeContent(String content) {
        this.content = content;
    }
    public void changeAuthor(String author) {
        this.author = author;
    }
}
