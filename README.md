# Проект по автоматизации тестирования [hh.ru](https://hh.ru/)

### Технологии и инструменты:
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logos/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logos/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logos/Github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logos/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logos/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logos/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://qameta.io/allure-report/"><img src="images/logos/Allure_Report.svg" width="50" height="50"  alt="Allure_Report"/></a>
<a href="https://qameta.io/"><img src="images/logos/Allure_TO.svg" width="50" height="50"  alt="Allure_TO"/></a>
<a href="https://www.jenkins.io/"><img src="images/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://www.atlassian.com/ru/software/jira/"><img src="images/logos/Jira.svg" width="50" height="50"  alt="Jira"/></a>
<a href="https://www.browserstack.com/"><img src="images/logos/Browserstack.svg" width="50" height="50"  alt="Browserstack"/></a>
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
#### Mobile
* Проверка заголовка главного экрана
* Проверка отображения релевантных поисковых подсказок
* Проверка отображения результатов поиска

### Запуск тестов из терминала
#### Локальный запуск тестов
##### Для UI тестов с параметрами из конфигурационного файла
```bash
gradle clean ui_tests -Denv=local
```
##### Для API тестов
```bash
gradle clean api_tests -Denv=local
```
#### Удаленный запуск тестов:
##### Для UI тестов с параметрами из конфигурационного файла
```shell
gradle clean ui_tests -Denv=remote
```

##### Для UI тестов с передачей параметров:
```bash
gradle clean ui_tests
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DremoteDriverUrl=https://{REMOTE_DRIVER_LOGIN}:{REMOTE_DRIVER_PASSWORD}@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${VIDEO_STORAGE}/video/
```
где:
- <code>BROWSER</code> – браузер, в котором будут выполняться тесты
- <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты
- <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты
- <code>REMOTE_DRIVER_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты
- <code>REMOTE_DRIVER_LOGIN</code> – логин удаленного сервера, на котором будут запускаться тесты
- <code>REMOTE_DRIVER_PASSWORD</code> – пароль удаленного сервера, на котором будут запускаться тесты
- <code>VIDEO_STORAGE</code> - адрес удаленного сервера, по которому можно получить видео

##### Для android тестов
```bash
gradle clean android_tests -Denv=local
```

### <img alt="Jenkins" height="20" src="images/logos/Jenkins.svg" width="20" align="center"> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/20-Tadree-hh.ru/)
<p align="center">
<img title="Jenkins Build" src="images/screens/Jenkins.png">
</p>
<p align="center">
<img title="Jenkins Build" src="images/screens/Jenkins_build.png">
</p>

1. Для запуска сборки необходимо перейти в раздел **Собрать с параметрами**
2. Запуская UI тесты, необходимо указать параметры для сборки и
      в <code>TEST_SUITE</code> выбрать ui_tests
3. Запуская API тесты или android тесты, можно оставить все предзаполненные поля, поменяв <code>TEST_SUITE</code>
      соответственно на api_tests или android_tests 
4. Запуская все тесты, необходимо указать параметры сборки для UI тестов и
      в <code>TEST_SUITE</code> выбрать test 
5. Нажать кнопку **Собрать**.

### <img alt="Allure" height="20" src="images/logos/Allure_Report.svg" width="20" align="center"> <a href="https://jenkins.autotests.cloud/job/20-Tadree-hh.ru/45/allure/">Отчет</a> в Allure report
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
<img title="Telegram" src="images/screens/tg.png" width=40%>
</p>

### <img alt="Selenoid" height="20" src="images/logos/Selenoid.svg" width="20" align="center"> Пример видео выполнения UI теста на Selenoid
<p align="center">
  <img title="Selenoid Video" src="images/screens/video.gif">
</p>

### <img alt="Selenoid" height="20" src="images/logos/Browserstack.svg" width="20" align="center"> Пример видео выполнения android теста в Browserstack
<p align="center">
  <img title="Browserstack Video" src="images/screens/mobile_test.gif" width=60%>
</p>