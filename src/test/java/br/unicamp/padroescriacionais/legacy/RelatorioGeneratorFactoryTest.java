package br.unicamp.padroescriacionais.legacy;

import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;
import br.unicamp.padroescriacionais.legacy.domain.Relatorio;
import br.unicamp.padroescriacionais.legacy.domain.TipoRelatorio;
import br.unicamp.padroescriacionais.legacy.factory.CsvRelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.factory.HtmlRelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.factory.JsonRelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.factory.PdfRelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.factory.RelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.factory.RelatorioGeneratorFactoryProvider;
import br.unicamp.padroescriacionais.legacy.factory.XmlRelatorioGeneratorFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RelatorioGeneratorFactoryTest {

    @Test
    void deveRetornarFabricaCorretaParaCadaFormato() {
        assertInstanceOf(PdfRelatorioGeneratorFactory.class,
                RelatorioGeneratorFactoryProvider.obterFabrica(FormatoRelatorio.PDF));
        assertInstanceOf(CsvRelatorioGeneratorFactory.class,
                RelatorioGeneratorFactoryProvider.obterFabrica(FormatoRelatorio.CSV));
        assertInstanceOf(JsonRelatorioGeneratorFactory.class,
                RelatorioGeneratorFactoryProvider.obterFabrica(FormatoRelatorio.JSON));
        assertInstanceOf(XmlRelatorioGeneratorFactory.class,
                RelatorioGeneratorFactoryProvider.obterFabrica(FormatoRelatorio.XML));
        assertInstanceOf(HtmlRelatorioGeneratorFactory.class,
                RelatorioGeneratorFactoryProvider.obterFabrica(FormatoRelatorio.HTML));
    }

    @Test
    void fabricasDevemGerarConteudoParaTodosFormatos() {
        Relatorio relatorio = new Relatorio(
                "Relatorio Teste",
                "Conteudo de teste",
                TipoRelatorio.VENDAS,
                LocalDateTime.of(2026, 5, 7, 10, 0)
        );

        for (FormatoRelatorio formato : FormatoRelatorio.values()) {
            RelatorioGeneratorFactory fabrica = RelatorioGeneratorFactoryProvider.obterFabrica(formato);
            String resultado = fabrica.gerar(relatorio);

            assertNotNull(resultado, "Resultado nulo para formato: " + formato);
            assertFalse(resultado.isBlank(), "Resultado vazio para formato: " + formato);
            assertTrue(resultado.contains("Relatorio Teste"), "Resultado deve manter o titulo");
        }
    }
}
