package Expressions;

import java.util.ArrayList;
import java.util.Date;

public class Expression {
    private ExpressionType expressionType;
    private String content;
    private String tag;
    private String additionalContent;
    private ArrayList<Sentence> sentences;
    private Retention retention;

    public Expression(ExpressionType expressionType, String content, String tag, String additionalContent, ArrayList<Sentence> sentences, Retention retention) {
        this.expressionType = expressionType;
        this.content = content;
        this.tag = tag;
        this.additionalContent = additionalContent;
        this.sentences = sentences;
        this.retention = retention;
    }

    public ExpressionType getExpressionType() {
        return expressionType;
    }

    public String getContent() {
        return content;
    }

    public String getTag() {
        return tag;
    }

    public String getAdditionalContent() {
        return additionalContent;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    public Retention getRetention() {
        return retention;
    }

}

class Sentence{
    String content;
    boolean preferred;
}

class Retention{
    double retentionRate;
    boolean checked;
    Date initialDate;
    Date planedNextDate;
    ArrayList<Date> reviewDates;
}