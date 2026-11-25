package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de testes de aceitação (JUnit 5) para a User Story 1 (US-01):
 * Valida a inicialização do tabuleiro 10x10 e o carregamento imediato da partida.
 */
public class UserStory1Test {

    private WebDriver driver;
    private UserStory1 userStory1;

    /**
     * Inicializa o navegador Chrome, maximiza a janela e acede à página do jogo.
     */
    @BeforeEach
    public void setUp() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://papergames.io/en/battleship");

        userStory1 = new UserStory1(driver);
    }

    /**
     * Fecha o navegador após a execução do teste.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Testa se ao iniciar partida contra o robô são apresentados dois tabuleiros
     * de 10x10 (100 quadrículas cada).
     *
     * @throws InterruptedException Caso a pausa de visualização seja interrompida.
     */
    @Test
    public void testInicializacaoTabuleiro10x10() throws InterruptedException {
        userStory1.clicarPlayVsRobot();
        userStory1.preencherNicknameSeNecessario("JogadorISCTE1");

        Thread.sleep(2000);

        assertTrue(userStory1.isAreaDeJogoVisivel(), "A área principal do jogo deve estar visível.");
        assertEquals(2, userStory1.obterNumeroDeTabuleiros(), "Devem existir exatamente 2 grelhas (jogador e adversário).");
        assertEquals(100, userStory1.contarQuadriculasDoTabuleiro(0), "A primeira grelha deve ter 100 quadrículas.");
        assertEquals(100, userStory1.contarQuadriculasDoTabuleiro(1), "A segunda grelha deve ter 100 quadrículas.");
    }
}