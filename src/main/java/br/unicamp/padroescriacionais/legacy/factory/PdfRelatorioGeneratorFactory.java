package br.unicamp.padroescriacionais.legacy.factory;

import br.unicamp.padroescriacionais.legacy.generator.PdfRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;

public class PdfRelatorioGeneratorFactory extends RelatorioGeneratorFactory {

    @Override
    public RelatorioGenerator criarGenerator() {
        return new PdfRelatorioGenerator();
    }
}
