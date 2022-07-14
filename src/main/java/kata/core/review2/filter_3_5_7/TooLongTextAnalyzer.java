package kata.core.review2.filter_3_5_7;

public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int threshold) {
        this.maxLength = threshold;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength) {
            return Label.TOO_LONG;
        } else {
            return Label.OK;
        }
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (int i = 0; i < analyzers.length; i++) {
            if (analyzers[i].processText(text) != Label.OK) {
                return analyzers[i].processText(text);
            }

        }

        return Label.OK;
    }
}
