package br.unicamp.padroescriacionais.legacy.factory;

import br.unicamp.padroescriacionais.legacy.generator.HtmlRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;

public class HtmlRelatorioGeneratorFactory extends RelatorioGeneratorFactory {

    @Override
    public RelatorioGenerator criarGenerator() {
        return new HtmlRelatorioGenerator();
    }
}
