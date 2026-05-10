package br.unicamp.padroescriacionais.legacy.generator;

import br.unicamp.padroescriacionais.legacy.domain.Relatorio;

public class HtmlRelatorioGenerator implements RelatorioGenerator {

    @Override
    public String gerar(Relatorio relatorio) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html lang=\"pt-BR\">\n");
        sb.append("<head>\n");
        sb.append("  <meta charset=\"UTF-8\">\n");
        sb.append("  <title>").append(htmlString(relatorio.getTitulo())).append("</title>\n");
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append("  <h1>").append(htmlString(relatorio.getTitulo())).append("</h1>\n");
        sb.append("  <p><strong>Tipo:</strong> ").append(htmlString(relatorio.getTipo().name())).append("</p>\n");
        sb.append("  <p><strong>Gerado em:</strong> ").append(htmlString(relatorio.getDataGeracao().toString())).append("</p>\n");
        sb.append("  <pre>").append(htmlString(relatorio.getConteudo())).append("</pre>\n");
        sb.append("</body>\n");
        sb.append("</html>\n");
        return sb.toString();
    }

    private String htmlString(String valor) {
        if (valor == null) return "";
        return valor
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
