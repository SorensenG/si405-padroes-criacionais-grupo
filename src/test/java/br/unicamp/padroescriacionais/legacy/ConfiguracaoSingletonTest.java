package br.unicamp.padroescriacionais.legacy;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;
import br.unicamp.padroescriacionais.legacy.service.ConfiguracaoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfiguracaoSingletonTest {

    private final ConfiguracaoSistema configuracao = ConfiguracaoSistema.getInstance();

    @AfterEach
    void restaurarConfiguracaoPadrao() {
        configuracao.setNomeEmpresa("Empresa XPTO Ltda.");
        configuracao.setAmbiente("DEV");
        configuracao.setDiretorioExportacao("/tmp/relatorios");
        configuracao.setDebugAtivo(false);
    }

    @Test
    void deveRetornarSempreAMesmaInstanciaCompartilhada() {
        ConfiguracaoSistema primeira = ConfiguracaoSistema.getInstance();
        ConfiguracaoSistema segunda = ConfiguracaoSistema.getInstance();

        assertSame(primeira, segunda);
    }

    @Test
    void configuracaoServiceDeveUsarInstanciaSingleton() {
        ConfiguracaoService service = new ConfiguracaoService();

        assertSame(ConfiguracaoSistema.getInstance(), service.getConfiguracao());
    }

    @Test
    void alteracaoNaInstanciaSingletonDeveSerCompartilhada() {
        ConfiguracaoSistema primeira = ConfiguracaoSistema.getInstance();
        ConfiguracaoSistema segunda = ConfiguracaoSistema.getInstance();

        primeira.setAmbiente("HOMOLOG");

        assertEquals("HOMOLOG", segunda.getAmbiente());
    }
}
