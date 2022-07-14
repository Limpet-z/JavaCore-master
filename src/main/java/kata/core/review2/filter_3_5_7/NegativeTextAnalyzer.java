package kata.core.review2.filter_3_5_7;

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private final String[] keywords = {":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }

}
