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
 * Classe de testes de aceitação (JUnit 5) para a User Story 2 (US-02):
 * Valida a execução de disparos sequenciais e a alternância de turnos com o adversário.
 */
public class UserStory2Test {

    private WebDriver driver;
    private UserStory2 userStory2;

    /**
     * Configura o ChromeDriver e navega para a página da Batalha Naval.
     */
    @BeforeEach
    public void setUp() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://papergames.io/en/battleship");

        userStory2 = new UserStory2(driver);
    }

    /**
     * Encerra a sessão do navegador após cada teste.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Testa dois disparos em coordenadas distintas da grelha adversária,
     * respeitando o tempo de transição de turno entre jogadas.
     *
     * @throws InterruptedException Caso alguma pausa seja interrompida.
     */
    @Test
    public void testDisparosPorTurnos() throws InterruptedException {
        userStory2.iniciarPartidaContraRobo();
        userStory2.preencherNicknameSeNecessario("JogadorISCTE2");

        Thread.sleep(2000);

        // Primeiro disparo na coordenada (2, 2)
        userStory2.dispararNaCoordenada(2, 2);
        Thread.sleep(2500);

        // Segundo disparo na coordenada (5, 5) após turno do robô ou turno extra
        userStory2.dispararNaCoordenada(5, 5);
        Thread.sleep(1500);

        assertTrue(userStory2.obterTotalDisparosNoAdversario() >= 2,
                "Devem estar registados pelo menos 2 disparos na grelha do adversário.");
    }
}