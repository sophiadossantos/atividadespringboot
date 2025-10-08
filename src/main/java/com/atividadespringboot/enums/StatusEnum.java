package com.atividadespringboot.enums;

public enum StatusEnum {
    ATIVO(1, "Ativo"),
    INATIVO(0, "Inativo");

    private final Integer codigo;
    private final String descricao;

    StatusEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() { return codigo; }
    public String getDescricao() { return descricao; }

    public static StatusEnum toEnum(Integer cod) {
        if (cod == null) return null;
        for (StatusEnum status : StatusEnum.values()) {
            if (cod.equals(status.getCodigo())) return status;
        }
        throw new IllegalArgumentException("Código inválido: " + cod);
    }

    public static String getDescricaoPorCodigo(Integer cod) {
        StatusEnum status = toEnum(cod);
        return (status != null) ? status.getDescricao() : "Código inválido";
    }
}
