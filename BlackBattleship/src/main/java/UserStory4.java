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
 * Page Object Class correspondente à User Story 4 (US-04):
 * Recolha de presentes (Gifts) que surgem dinamicamente no tabuleiro após algumas jogadas,
 * atribuindo armas extra ao jogador que os atingir.
 */
public class UserStory4 {

    private final WebDriver driver;
    private final WebDriverWait wait;

    /**
     * Botão "Play vs robot" na página inicial.
     */
    @FindBy(css = ".w-100:nth-child(2) > .btn .flex-grow-1")
    public WebElement playVsRobotButton;

    /**
     * Campo de texto para introdução de nickname de convidado.
     */
    @FindBy(css = "input[type='text']")
    public WebElement nicknameInput;

    /**
     * Botão de confirmação do nickname.
     */
    @FindBy(xpath = "//button[@type='submit' or contains(., 'Continue') or contains(., 'Play')]")
    public WebElement confirmNicknameButton;

    /**
     * Construtor da classe UserStory4.
     *
     * @param driver Instância ativa do Selenium WebDriver.
     */
    public UserStory4(WebDriver driver) {
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
            // Sessão já ativa
        }
    }

    /**
     * Efetua disparos sequenciais em coordenadas livres da grelha adversária até que
     * um presente (ícone de caixa/arma) surja no tabuleiro do oponente, e clica nele para o recolher.
     *
     * @return {@code true} se um presente tiver sido encontrado e recolhido durante a partida.
     * @throws InterruptedException Caso a pausa entre jogadas seja interrompida.
     */
    public boolean jogarAteRecolherPresente() throws InterruptedException {
        By seletorPresente = By.cssSelector("table[id^='board_ai'] td img, table[id^='board_ai'] .fa-question");

        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna += 2) {
                // Verifica se já apareceu um presente no tabuleiro adversário
                List<WebElement> presentes = driver.findElements(seletorPresente);
                if (!presentes.isEmpty() && presentes.get(0).isDisplayed()) {
                    presentes.get(0).click();
                    return true;
                }

                // Dispara numa célula ainda não atingida para fazer avançar os turnos
                By seletorCelula = By.cssSelector("table[id^='board_ai'] .cell-" + linha + "-" + coluna);
                List<WebElement> celulas = driver.findElements(seletorCelula);
                if (!celulas.isEmpty()) {
                    String classes = celulas.get(0).getAttribute("class");
                    if (classes != null && !classes.contains("hit") && !classes.contains("no-hit")) {
                        celulas.get(0).click();
                        Thread.sleep(1800);
                    }
                }
            }
        }
        return false;
    }
}