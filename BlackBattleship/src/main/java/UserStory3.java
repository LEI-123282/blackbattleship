package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page Object Class correspondente à User Story 3 (US-03):
 * Utilização de armas especiais com áreas de impacto distintas (Big Missile em cruz de 5 quadrículas).
 * Encapsula os localizadores da barra de armas (#player_weapons) e o disparo em área.
 */
public class UserStory3 {

    private final WebDriver driver;
    private final WebDriverWait wait;

    /**
     * Botão "Play vs robot" na página inicial.
     */
    @FindBy(css = ".w-100:nth-child(2) > .btn .flex-grow-1")
    public WebElement playVsRobotButton;

    /**
     * Campo de texto para o nickname de convidado.
     */
    @FindBy(css = "input[type='text']")
    public WebElement nicknameInput;

    /**
     * Botão de confirmação do nickname.
     */
    @FindBy(xpath = "//button[@type='submit' or contains(., 'Continue') or contains(., 'Play')]")
    public WebElement confirmNicknameButton;

    /**
     * Botão da arma especial Big Missile (3.º botão na barra #player_weapons).
     */
    @FindBy(css = "#player_weapons .weapon-button:nth-child(3)")
    public WebElement bigMissileButton;

    /**
     * Distintivo numérico (.badge) que indica a quantidade restante de Big Missiles.
     */
    @FindBy(css = "#player_weapons .weapon-button:nth-child(3) > .badge")
    public WebElement bigMissileCountBadge;

    /**
     * Células afetadas por disparos (acerto ou falha) no tabuleiro adversário.
     */
    @FindBy(css = "table[id^='board_ai'] .hit, table[id^='board_ai'] .no-hit")
    public List<WebElement> celulasAfetadas;

    /**
     * Construtor da classe UserStory3.
     *
     * @param driver Instância ativa do Selenium WebDriver.
     */
    public UserStory3(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Inicia uma partida contra o computador.
     */
    public void iniciarPartidaContraRobo() {
        wait.until(ExpectedConditions.elementToBeClickable(playVsRobotButton)).click();
    }

    /**
     * Preenche o nickname caso o modal de convidado seja apresentado.
     *
     * @param nickname Nome de exibição do jogador.
     */
    public void preencherNicknameSeNecessario(String nickname) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.visibilityOf(nicknameInput));
            nicknameInput.clear();
            nicknameInput.sendKeys(nickname);
            confirmNicknameButton.click();
        } catch (Exception ignored) {
            // Sessão já ativa
        }
    }

    /**
     * Obtém a quantidade atual disponível de Big Missiles a partir do indicador visual.
     *
     * @return Número inteiro de munições disponíveis para o Big Missile.
     */
    public int obterQuantidadeBigMissiles() {
        String textoBadge = wait.until(ExpectedConditions.visibilityOf(bigMissileCountBadge)).getText().trim();
        return Integer.parseInt(textoBadge);
    }

    /**
     * Seleciona o Big Missile na barra de armas do jogador.
     */
    public void selecionarBigMissile() {
        wait.until(ExpectedConditions.elementToBeClickable(bigMissileButton)).click();
    }

    /**
     * Dispara a arma selecionada na coordenada especificada do tabuleiro adversário.
     *
     * @param linha  Índice da linha (0 a 9).
     * @param coluna Índice da coluna (0 a 9).
     */
    public void dispararArmaNaCoordenada(int linha, int coluna) {
        By seletor = By.cssSelector("table[id^='board_ai'] .cell-" + linha + "-" + coluna);
        wait.until(ExpectedConditions.elementToBeClickable(seletor)).click();
    }

    /**
     * Conta o total de quadrículas atingidas no tabuleiro do adversário após o impacto em área.
     *
     * @return Número total de quadrículas marcadas.
     */
    public int obterTotalQuadriculasAfetadas() {
        return celulasAfetadas.size();
    }
}