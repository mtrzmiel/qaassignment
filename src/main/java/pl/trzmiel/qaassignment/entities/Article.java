package pl.trzmiel.qaassignment.entities;

public class Article {

    private final String title;
    private final String subTitle;
    private final String context;
    private final String tag;

    private Article(ArticleBuilder articleBuilder) {
        this.title = articleBuilder.getTitle();
        this.subTitle = articleBuilder.getSubTitle();
        this.context = articleBuilder.getContext();
        this.tag = articleBuilder.getTag();
    }


    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getContext() {
        return context;
    }

    public String getTag() {
        return tag;
    }

    public class ArticleBuilder {

        private String title = "";
        private String subTitle = "";
        private String context = "";
        private String tag = "";

        String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public Article build() {
            return new Article(this);
        }

    }


}
