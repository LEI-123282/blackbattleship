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
 * Page Object Class correspondente à User Story 1 (US-01):
 * Inicialização de tabuleiro 10x10 e frota aleatória no jogo Batalha Naval (Papergames.io).
 * Encapsula os localizadores da interface e as interações iniciais da partida.
 */
public class UserStory1 {

    private final WebDriver driver;
    private final WebDriverWait wait;

    /**
     * Botão "Play vs robot" na página principal do jogo.
     */
    @FindBy(css = ".w-100:nth-child(2) > .btn .flex-grow-1")
    public WebElement playVsRobotButton;

    /**
     * Contentor principal da área de jogo da Batalha Naval.
     */
    @FindBy(id = "battleships")
    public WebElement battleshipsContainer;

    /**
     * Campo de texto para introdução de nickname de convidado, caso surja.
     */
    @FindBy(css = "input[type='text']")
    public WebElement nicknameInput;

    /**
     * Botão de confirmação do nickname.
     */
    @FindBy(xpath = "//button[@type='submit' or contains(., 'Continue') or contains(., 'Play')]")
    public WebElement confirmNicknameButton;

    /**
     * Lista de tabelas correspondentes às grelhas do jogador e do adversário.
     */
    @FindBy(css = "#battleships table")
    public List<WebElement> gameBoards;

    /**
     * Construtor da classe UserStory1.
     *
     * @param driver Instância ativa do Selenium WebDriver.
     */
    public UserStory1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Clica no botão "Play vs robot" para iniciar uma partida contra o computador.
     */
    public void clicarPlayVsRobot() {
        wait.until(ExpectedConditions.elementToBeClickable(playVsRobotButton)).click();
    }

    /**
     * Preenche o nickname caso o ecrã de registo rápido de convidado seja apresentado.
     *
     * @param nickname Nome de exibição a atribuir ao jogador.
     */
    public void preencherNicknameSeNecessario(String nickname) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.visibilityOf(nicknameInput));
            nicknameInput.clear();
            nicknameInput.sendKeys(nickname);
            confirmNicknameButton.click();
        } catch (Exception ignored) {
            // Sessão já ativa sem pedido de nickname
        }
    }

    /**
     * Verifica se o contentor principal do jogo está visível no ecrã.
     *
     * @return {@code true} se a área de jogo estiver carregada e visível.
     */
    public boolean isAreaDeJogoVisivel() {
        return wait.until(ExpectedConditions.visibilityOf(battleshipsContainer)).isDisplayed();
    }

    /**
     * Obtém o número total de tabuleiros apresentados na partida (jogador e adversário).
     *
     * @return Número de grelhas encontradas.
     */
    public int obterNumeroDeTabuleiros() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#battleships table")));
        return gameBoards.size();
    }

    /**
     * Conta o número de quadrículas existentes numa grelha 10x10.
     *
     * @param indiceTabuleiro Índice do tabuleiro (0 para o primeiro, 1 para o segundo).
     * @return Total de células encontradas na grelha.
     */
    public int contarQuadriculasDoTabuleiro(int indiceTabuleiro) {
        WebElement tabuleiro = wait.until(ExpectedConditions.visibilityOf(gameBoards.get(indiceTabuleiro)));
        return tabuleiro.findElements(By.cssSelector("td")).size();
    }
}