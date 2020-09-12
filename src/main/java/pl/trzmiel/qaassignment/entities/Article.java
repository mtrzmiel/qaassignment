package pl.trzmiel.qaassignment.entities;

public class Article {

    private final String title;
    private final String summary;
    private final String context;
    private final String tag; // assumption, that only one tag is valid, but this should be consider

    private Article(ArticleBuilder articleBuilder) {
        this.title = articleBuilder.getTitle();
        this.summary = articleBuilder.getSummary();
        this.context = articleBuilder.getContext();
        this.tag = articleBuilder.getTag();
    }


    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getContext() {
        return context;
    }

    public String getTag() {
        return tag;
    }

    public static class ArticleBuilder {

        private String title = "";
        private String summary = "";
        private String context = "";
        private String tag = "";

        String getTitle() {
            return title;
        }

        public ArticleBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        String getSummary() {
            return summary;
        }

        public ArticleBuilder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        String getContext() {
            return context;
        }

        public ArticleBuilder setContext(String context) {
            this.context = context;
            return this;
        }

        String getTag() {
            return tag;
        }

        public ArticleBuilder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public Article build() {
            return new Article(this);
        }

    }


}
