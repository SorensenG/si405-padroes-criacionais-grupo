package br.unicamp.padroescriacionais.legacy.factory;

import br.unicamp.padroescriacionais.legacy.generator.CsvRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;

public class CsvRelatorioGeneratorFactory extends RelatorioGeneratorFactory {

    @Override
    public RelatorioGenerator criarGenerator() {
        return new CsvRelatorioGenerator();
    }
}
