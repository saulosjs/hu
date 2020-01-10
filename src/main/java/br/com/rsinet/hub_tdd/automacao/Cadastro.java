package br.com.rsinet.hub_tdd.automacao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.leituraExcel.Constant;
import br.com.rsinet.hub_tdd.leituraExcel.ExcelUtils;
import br.com.rsinet.hub_tdd.pageObject.Objetos;

public class Cadastro {
	public void preencher() throws Exception {
		WebDriver driver = new ChromeDriver();

		Objetos page = PageFactory.initElements(driver, Objetos.class);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://www.advantageonlineshopping.com/#/");
		page.clickLogin.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elemento = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")));
		elemento.click();

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		page.usuario.sendKeys(ExcelUtils.getCellData(1, 0));
		page.email.sendKeys(ExcelUtils.getCellData(1, 1));
		page.senha.sendKeys(ExcelUtils.getCellData(1, 2));
		page.confirmar.sendKeys(ExcelUtils.getCellData(1, 3));
		page.nome.sendKeys(ExcelUtils.getCellData(1, 4));
		page.sobreNome.sendKeys(ExcelUtils.getCellData(1, 5));
		page.telefone.sendKeys(ExcelUtils.getCellData(1, 6));
		page.cidade.sendKeys(ExcelUtils.getCellData(1, 8));
		page.endereco.sendKeys(ExcelUtils.getCellData(1, 9));
		page.estado.sendKeys(ExcelUtils.getCellData(1, 10));
		page.postal.sendKeys(ExcelUtils.getCellData(1, 11));

	}

}
