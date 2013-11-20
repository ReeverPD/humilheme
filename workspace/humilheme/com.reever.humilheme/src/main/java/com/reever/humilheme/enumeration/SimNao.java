package com.reever.humilheme.enumeration;

/**
 *
 * @author Iuri Andreazza
 */
public enum SimNao {

    S("S", "Sim"), N("N", "Não");

    private String valor;

    private String description;

    private SimNao(String description) {
        this.description = description;
    }

    private SimNao(String valor, String description) {
        this.valor = valor;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public Boolean toBoolean() {
        return this.equals(S);
    }

    public static SimNao toEnum(Boolean value) {
        return value ? SimNao.S : SimNao.N;
    }

    public String getValor() {
        return valor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static SimNao getSimNao(final String valor) {
        if ("1".equals(valor) || "S".equalsIgnoreCase(valor)) {
            return SimNao.S;
        }

        return SimNao.N;
    }

}
