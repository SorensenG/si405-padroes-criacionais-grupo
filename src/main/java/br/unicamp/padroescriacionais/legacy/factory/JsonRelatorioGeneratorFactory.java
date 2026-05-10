package br.unicamp.padroescriacionais.legacy.factory;

import br.unicamp.padroescriacionais.legacy.generator.JsonRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;

public class JsonRelatorioGeneratorFactory extends RelatorioGeneratorFactory {

    @Override
    public RelatorioGenerator criarGenerator() {
        return new JsonRelatorioGenerator();
    }
}
