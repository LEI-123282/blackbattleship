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

/**
 * Classe de testes de aceitação (JUnit 5) para a User Story 3 (US-03):
 * Valida a disponibilidade inicial de 2 Big Missiles, a seleção da arma especial
 * e o impacto em cruz de 5 quadrículas no centro do tabuleiro adversário.
 */
public class UserStory3Test {

    private WebDriver driver;
    private UserStory3 userStory3;

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

        userStory3 = new UserStory3(driver);
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
     * Testa o disparo de um Big Missile na célula central (4, 4),
     * verificando o decremento da munição (de 2 para 1) e o impacto em 5 quadrículas.
     *
     * @throws InterruptedException Caso alguma pausa seja interrompida.
     */
    @Test
    public void testUtilizacaoBigMissile() throws InterruptedException {
        userStory3.iniciarPartidaContraRobo();
        userStory3.preencherNicknameSeNecessario("JogadorISCTE3");

        Thread.sleep(2000);

        // Verifica que o jogador inicia com 2 Big Missiles
        assertEquals(2, userStory3.obterQuantidadeBigMissiles(),
                "O jogador deve iniciar a partida com 2 Big Missiles.");

        userStory3.selecionarBigMissile();
        Thread.sleep(800);

        // Dispara no centro (4, 4) para garantir que todas as 5 células da cruz cabem na grelha
        userStory3.dispararArmaNaCoordenada(4, 4);
        Thread.sleep(2000);

        assertEquals(1, userStory3.obterQuantidadeBigMissiles(),
                "Após disparar um Big Missile, a quantidade disponível deve passar para 1.");
        assertEquals(5, userStory3.obterTotalQuadriculasAfetadas(),
                "O Big Missile deve atingir exatamente 5 quadrículas em formato de cruz.");
    }
}