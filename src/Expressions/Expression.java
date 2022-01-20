package Expressions;

import java.util.ArrayList;
import java.util.Date;

public abstract class Expression {
    String content;
    String tag;
    String additionalContent;
    ArrayList<Sentence> sentences;
    Retention retention;
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