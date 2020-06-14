package models;

public class News {
    private String headline;
    private String content;
    private String author;
    private int departmentId;
    private int id;

    public News(String headline, String content, String author){
        this.headline = headline;
        this.content = content;
        this.author = author;
    }

    public News(String headline, String content, String author, int departmentId){
        this.author = author;
        this.content = content;
        this.headline = headline;
        this.departmentId = departmentId;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (departmentId != news.departmentId) return false;
        if (id != news.id) return false;
        if (headline != null ? !headline.equals(news.headline) : news.headline != null) return false;
        if (content != null ? !content.equals(news.content) : news.content != null) return false;
        return author != null ? author.equals(news.author) : news.author == null;
    }

    @Override
    public int hashCode() {
        int result = headline != null ? headline.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + departmentId;
        result = 31 * result + id;
        return result;
    }

}
