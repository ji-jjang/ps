package com.juny.programmerstracker;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgrammersTrackerApplication {

  private static String programmersId;
  private static String programmersPw;
  private static String baekjoonId;

  public static void main(String[] args) {

    programmersId = System.getenv("PROGRAMMERS_ID");
    programmersPw = System.getenv("PROGRAMMERS_PW");
    baekjoonId = System.getenv("BAEKJOON_ID");

    if (programmersId == null || programmersPw == null || baekjoonId == null) {
      throw new RuntimeException(
          "Environment variables {PROGRAMMERS_ID, PROGRAMMERS_PW, BAEKJOON_ID} must be set.");
    }

    System.setProperty(
        "webdriver.chrome.driver",
        "/opt/chrome-linux64/chromedriver-linux64/chromedriver");

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");

    WebDriver driver = new ChromeDriver(options);

    try {
      driver.get("https://programmers.co.kr/account/sign_in");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      WebElement emailField = driver.findElement(By.name("email"));
      emailField.sendKeys(programmersId);

      WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
      passwordField.sendKeys(programmersPw);

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

      WebElement loginButton =
          wait.until(
              ExpectedConditions.elementToBeClickable(
                  By.xpath(
                      "//button[@class='ayxkplSwAOlzWhl7UloQ IQmH8pxs6MpeDFpLSMPh Gosd7zfsHAxk1MOYSkL1' and text()='로그인하기']")));
      loginButton.click();

      loginButton.click();

      TimeUnit.SECONDS.sleep(3);

      String token = getToken(driver);
      JSONObject data = getProgrammersData(token);
      createSVGImage(data);
      updateReadme();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      driver.quit();
    }
  }

  private static String getToken(WebDriver driver) {
    Cookie sessionCookie = driver.manage().getCookieNamed("_programmers_session_production");
    if (sessionCookie != null) {
      return sessionCookie.getValue();
    } else {
      throw new RuntimeException("Session cookie not found");
    }
  }

  private static JSONObject getProgrammersData(String token)
      throws IOException, InterruptedException {
    String apiUrl = "https://school.programmers.co.kr/api/v1/school/challenges/users/";
    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(apiUrl))
            .header("Cookie", "_programmers_session_production=" + token)
            .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    if (response.statusCode() == 200) {
      return new JSONObject(response.body());
    } else {
      throw new RuntimeException("Failed to fetch data: " + response.statusCode());
    }
  }

  private static void createSVGImage(JSONObject data) throws IOException {
    String svgContent =
        String.format(
            """
      <?xml version="1.0" encoding="UTF-8"?>
      <!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">
      <svg xmlns="http://www.w3.org/2000/svg" version="1.1" width="600px" height="230px"
        style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd"
        xmlns:xlink="http://www.w3.org/1999/xlink">
        <style>
          .title {
          color: #0078ff;
          font-size: 1rem;
          line-height: 2.5rem;
          font-weight: bold;
          font-family: -apple-system,BlinkMacSystemFont,Segoe UI,Helvetica,Arial,sans-serif
          }
          .desc {
          color: #0078ff;
          font-size: 2.5rem;
          font-weight: bold;
          line-height: 1.5rem;
          font-family: -apple-system,BlinkMacSystemFont,Segoe UI,Helvetica,Arial,sans-serif
          }
          .desc-2 {
          color: #0078ff;
          font-size: 1rem;
          font-weight: bold;
          line-height: 1.5rem;
          font-family: -apple-system,BlinkMacSystemFont,Segoe UI,Helvetica,Arial,sans-serif
          }
        </style>

        <rect x="0" y="0" width="530" height="250" fill="#fefefe"/>

        <rect x="10" y="10" width="250" height="100" fill="#ecf5ff"/>
        <text text-anchor="middle" x="135" y="45" class="title" style="fill:#0078ff;" stroke="none" stroke-width="1">
          <tspan>이름</tspan>
        </text>
        <text text-anchor="middle" x="135" y="85" class="desc" stroke="none" stroke-width="1">
          <tspan>%s</tspan>
        </text>

        <rect x="270" y="10" width="250" height="100" fill="#ecf5ff"/>
        <text text-anchor="middle" x="395" y="45" class="title" style="fill:#0078ff;" stroke="none" stroke-width="1">
          <tspan>현재 점수</tspan>
        </text>
        <text text-anchor="middle" x="400" y="85" class="desc" stroke="none" stroke-width="1">
          <tspan>%d</tspan>
        </text>

        <rect x="10" y="120" width="250" height="100" fill="#ecf5ff"/>
        <text text-anchor="middle" x="135" y="150" class="title" style="fill:#0078ff;" stroke="none" stroke-width="1">
          <tspan>해결한 코딩 테스트</tspan>
        </text>
        <text text-anchor="middle" x="135" y="190" class="desc" stroke="none" stroke-width="1">
          <tspan>%d</tspan>
          <tspan class="desc-2">문제</tspan>
        </text>

        <rect x="270" y="120" width="250" height="100" fill="#ecf5ff"/>
        <text text-anchor="middle" x="395" y="150" class="title" style="fill:#0078ff;" stroke="none" stroke-width="1">
          <tspan>나의 랭킹</tspan>
        </text>
        <text text-anchor="middle" x="400" y="190" class="desc" stroke="none" stroke-width="1">
          <tspan>%d</tspan>
          <tspan class="desc-2">위</tspan>
        </text>
      </svg>
      """,
            data.getString("name").split("@")[0],
            data.getInt("score"),
            data.getInt("solvedChallengesCount"),
            data.getInt("rank"));

    Files.writeString(Paths.get("programmers_info.svg"), svgContent);
  }

  private static void updateReadme() throws IOException {
    String readmeContent =
        new String(
            "# 백준\n[![Solved.ac Profile](http://mazassumnida.wtf/api/v2/generate_badge?boj="
                + baekjoonId
                + ")](https://solved.ac/"
                + baekjoonId
                + "/)\n# 프로그래머스\n");

    String svgImageLink = "![프로그래머스 정보](./programmersTracker/programmers_info.svg)";

    readmeContent += svgImageLink;

    Files.write(Paths.get("../README.md"), readmeContent.getBytes());
  }
}
