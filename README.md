# Проект по автоматизации тестирования hh.ru

### Технологии и инструменты:
<p align="center">
<img src="images/logos/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/>
<img src="images/logos/Java.svg" width="50" height="50"  alt="Java"/>
<img src="images/logos/Github.svg" width="50" height="50"  alt="Github"/>
<img src="images/logos/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/>
<img src="images/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/>
<img src="images/logos/Selenide.svg" width="50" height="50"  alt="Selenide"/>
<img src="images/logos/Selenoid.svg" width="50" height="50"  alt="Selenoid"/>
<img src="images/logos/Allure_Report.svg" width="50" height="50"  alt="Allure_Report"/>
<img src="images/logos/Allure_TO.svg" width="50" height="50"  alt="Allure_TO"/>
<img src="images/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/>
<img src="images/logos/Jira.svg" width="50" height="50"  alt="Jira"/>
</p>

### Реализованные проверки:
#### UI 
* Отображение строки поиска на главной странице
* Проверка плейсхолдера строки поиска на главной странице
* Переход на страницу результатов поиска при выполнении поиска с главной страницы
* Переход на страницу расширенного поиска с главной страницы
* Отображение поисковых подсказок на главной странице
* Проверка заголовка на главной странице
* Отображение popup подтверждения региона на главной странице
* Проверка смены языка на английский на главной странице
* Отсутствие ошибок в логах консоли на главной странице
* Подстановка подсказки в поле "Ключевые слова" на странице расширенного поиска
* Переход на страницу результатов поиска при выполнении поиска со страницы расширенного поиска
#### API
* Поиск работодателя по наименованию
* Проверка пагинации при поиске работодателя
* Проверка ошибки авторизации при добавлении вакансии в избранное
* Проверка ошибки авторизации при подтверждении номера телефона
* Проверка получения поисковых подсказок
* роверка ошибки получения поисковых подсказок при отсутствии текста для поиска ключевого слова

### Запуск тестов из терминала
#### Локальный запуск тестов с параметрами из конфигурационного файла:
```bash
gradle clean test -Denv=local
```
#### Удаленный запуск тестов с параметрами из конфигурационного файла:
```shell
gradle clean test -Denv=remote
```

#### Удаленный запуск тестов с передачей параметров:

```bash
gradle clean ${TEST_SUITE} 
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DremoteDriverUrl=https://user1:1234@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${VIDEO_STORAGE}/video/
```
где: 

- <code>TEST_SUITE</code> – ттесттовый набор (UI тесты, API тесты)
- <code>BROWSER</code> – браузер, в котором будут выполняться тесты
- <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты
- <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты
- <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты
- <code>VIDEO_STORAGE</code> - адрес удаленного сервера, по которому можно получить видео

### <img alt="Jenkins" height="20" src="images/logos/Jenkins.svg" width="20" align="center"> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/20-Tadree-hh.ru/)
<p align="center">
<img title="Jenkins Build" src="images/screens/Jenkins.png">
</p>

### <img alt="Allure" height="20" src="images/logos/Allure_Report.svg" width="20" align="center"> Отчет в Allure report
#### Основная страница отчета
<p align="center">
<img title="Allure report" src="images/screens/Allure-report.png">
</p>

#### Тест-кейсы
<p align="center">
<img title="Allure tests" src="images/screens/Allure-tests.png">
</p>

### <img alt="Allure TestOps" height="20" src="images/logos/Allure_TO.svg" width="20" align="center"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3515/dashboards)
#### Dashboard
<p align="center">
<img title="Allure TestOps Dashboard" src="images/screens/Allure-TestOps-dashboard.png">
</p>

#### Тест-кейсы
<p align="center">
<img title="Allure TestOps tests" src="images/screens/Allure-TestOps-tests.png">
</p>

### <img alt="Jira" height="20" src="images/logos/Jira.svg" width="20" align="center"> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-787)
<p align="center">
<img title="Jira" src="images/screens/Jira.png">
</p>

### <img alt="Telegram" height="20" src="images/logos/Telegram.svg" width="20" align="center"> Уведомления в Telegram с использованием бота
<p align="center">
<img title="Telegram" src="images/screens/tg.png">
</p>

### <img alt="Selenoid" height="20" src="images/logos/Selenoid.svg" width="20" align="center"> Пример видео выполнения теста на Selenoid
<p align="center">
  <img title="Selenoid Video" src="images/screens/video.gif">
</p>