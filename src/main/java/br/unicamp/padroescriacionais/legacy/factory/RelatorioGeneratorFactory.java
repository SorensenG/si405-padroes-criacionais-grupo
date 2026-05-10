package br.unicamp.padroescriacionais.legacy.factory;

import br.unicamp.padroescriacionais.legacy.domain.Relatorio;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;

public abstract class RelatorioGeneratorFactory {

    public final String gerar(Relatorio relatorio) {
        return criarGenerator().gerar(relatorio);
    }

    public abstract RelatorioGenerator criarGenerator();
}
