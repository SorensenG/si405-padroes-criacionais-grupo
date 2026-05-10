package br.unicamp.padroescriacionais.legacy.generator;

import br.unicamp.padroescriacionais.legacy.domain.Relatorio;

public class XmlRelatorioGenerator implements RelatorioGenerator {

    @Override
    public String gerar(Relatorio relatorio) {
        StringBuilder sb = new StringBuilder();
        sb.append("<relatorio>\n");
        sb.append("  <titulo>").append(xmlString(relatorio.getTitulo())).append("</titulo>\n");
        sb.append("  <tipo>").append(xmlString(relatorio.getTipo().name())).append("</tipo>\n");
        sb.append("  <dataGeracao>").append(xmlString(relatorio.getDataGeracao().toString())).append("</dataGeracao>\n");
        sb.append("  <conteudo>").append(xmlString(relatorio.getConteudo())).append("</conteudo>\n");
        sb.append("</relatorio>\n");
        return sb.toString();
    }

    private String xmlString(String valor) {
        if (valor == null) return "";
        return valor
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}
