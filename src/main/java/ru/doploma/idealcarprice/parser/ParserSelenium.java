package ru.doploma.idealcarprice.parser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.doploma.idealcarprice.dto.CalculationDetailDTO;
import ru.doploma.idealcarprice.helper.AutoRuHelper;
import ru.doploma.idealcarprice.model.PartCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserSelenium {
    public static String parseAveragePrice(String modelCode) {
        System.setProperty("webdriver.chrome.driver", "webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get(AutoRuHelper.AUTO_RU_STATS_URL + modelCode);
        WebElement price = webDriver.findElement(new By.ByXPath(AutoRuHelper.XPATH_TO_PRICE));
        String priceString = price.getText().replaceAll(" ", "").replaceFirst("₽", "");
        webDriver.close();
        return priceString;
    }

    public static Map<String, CalculationDetailDTO> parseDetailPrice(
            String url,
            List<PartCode> partCodes,
            String replaceString,
            String className) {
        System.setProperty("webdriver.chrome.driver", "webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36");
        WebDriver webDriver = new ChromeDriver(options);
        Map<String, CalculationDetailDTO> linksAndPrices = new HashMap<>();
        for (PartCode partCode: partCodes) {
            String detailLink = url.replaceFirst(replaceString, partCode.getVendorCode());
            webDriver.get(detailLink);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement price = webDriver.findElement(new By.ByClassName(className));
            linksAndPrices.put(
                    detailLink,
                    new CalculationDetailDTO(
                            Double.parseDouble(price.getText().replaceAll(" ", "").replaceFirst("₽", "")),
                            partCode.getCount()
                    )
                );
        }
        webDriver.close();
        return linksAndPrices;
    }
}
