package br.unicamp.padroescriacionais.legacy.factory;

import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;

import java.util.EnumMap;
import java.util.Map;

public final class RelatorioGeneratorFactoryProvider {

    private static final Map<FormatoRelatorio, RelatorioGeneratorFactory> FABRICAS =
            new EnumMap<>(FormatoRelatorio.class);

    static {
        FABRICAS.put(FormatoRelatorio.PDF, new PdfRelatorioGeneratorFactory());
        FABRICAS.put(FormatoRelatorio.CSV, new CsvRelatorioGeneratorFactory());
        FABRICAS.put(FormatoRelatorio.JSON, new JsonRelatorioGeneratorFactory());
        FABRICAS.put(FormatoRelatorio.XML, new XmlRelatorioGeneratorFactory());
        FABRICAS.put(FormatoRelatorio.HTML, new HtmlRelatorioGeneratorFactory());
    }

    private RelatorioGeneratorFactoryProvider() {
    }

    public static RelatorioGeneratorFactory obterFabrica(FormatoRelatorio formato) {
        RelatorioGeneratorFactory fabrica = FABRICAS.get(formato);
        if (fabrica == null) {
            throw new IllegalArgumentException("Formato desconhecido: " + formato);
        }
        return fabrica;
    }
}
