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
 * Page Object Class correspondente à User Story 2 (US-02):
 * Sistema de disparos por turnos e turno extra no jogo Batalha Naval.
 * Encapsula os localizadores do tabuleiro adversário e as ações de disparo.
 */
public class UserStory2 {

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
     * Lista de células no tabuleiro do adversário já atingidas por disparos (acerto ou água).
     */
    @FindBy(css = "table[id^='board_ai'] .hit, table[id^='board_ai'] .no-hit")
    public List<WebElement> celulasDisparadasAdversario;

    /**
     * Construtor da classe UserStory2.
     *
     * @param driver Instância ativa do Selenium WebDriver.
     */
    public UserStory2(WebDriver driver) {
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
     * Preenche o nickname caso o modal de entrada surja no ecrã.
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
            // Sessão já iniciada
        }
    }

    /**
     * Dispara um míssil simples numa coordenada específica (linha e coluna de 0 a 9)
     * da grelha do adversário.
     *
     * @param linha  Índice da linha (0 a 9).
     * @param coluna Índice da coluna (0 a 9).
     */
    public void dispararNaCoordenada(int linha, int coluna) {
        By seletorCelula = By.cssSelector("table[id^='board_ai'] .cell-" + linha + "-" + coluna);
        WebElement celula = wait.until(ExpectedConditions.elementToBeClickable(seletorCelula));
        celula.click();
    }

    /**
     * Devolve o total de disparos já registados visualmente no tabuleiro adversário.
     *
     * @return Número de células marcadas com acerto ou falha.
     */
    public int obterTotalDisparosNoAdversario() {
        return celulasDisparadasAdversario.size();
    }
}