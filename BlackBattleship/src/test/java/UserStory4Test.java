package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de testes de aceitação (JUnit 5) para a User Story 4 (US-04):
 * Valida o surgimento dinâmico de presentes (Gifts) durante a partida e a sua recolha.
 */
public class UserStory4Test {

    private WebDriver driver;
    private UserStory4 userStory4;

    /**
     * Configura o ChromeDriver e abre a página do jogo Batalha Naval.
     */
    @BeforeEach
    public void setUp() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://papergames.io/en/battleship");

        userStory4 = new UserStory4(driver);
    }

    /**
     * Encerra a sessão do WebDriver após o teste.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Testa a progressão de jogadas até ao aparecimento de um presente no tabuleiro
     * do adversário e valida a sua recolha através de um disparo direto.
     *
     * @throws InterruptedException Caso a execução seja interrompida.
     */
    @Test
    public void testRecolhaDePresenteNoTabuleiro() throws InterruptedException {
        userStory4.iniciarPartidaContraRobo();
        userStory4.preencherNicknameSeNecessario("JogadorISCTE4");

        Thread.sleep(2000);

        boolean presenteRecolhido = userStory4.jogarAteRecolherPresente();
        Thread.sleep(1500);

        assertTrue(presenteRecolhido,
                "Deverá surgir e ser recolhido pelo menos um presente no tabuleiro adversário durante a partida.");
    }
}