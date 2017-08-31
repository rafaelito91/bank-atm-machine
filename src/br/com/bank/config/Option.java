package br.com.bank.config;

/**
 * Created by rafael on 31/08/17.
 */
public class Option {

    private final Integer index;

    private final String name;

    public Option(final Integer index, final String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
