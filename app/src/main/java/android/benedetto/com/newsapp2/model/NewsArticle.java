package android.benedetto.com.newsapp2.model;

public class NewsArticle {

    private String mTitle;
    private String mContent;

    public NewsArticle(String title, String content) {
        mTitle = title;
        mContent = content;
    }

    public NewsArticle(String title) {
        mTitle = title;
        mContent = null;
    }

    public NewsArticle() {
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }
}
