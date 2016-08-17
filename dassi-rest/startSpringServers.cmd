set JAVA_HOME="C:\Program Files\Java\jre1.8.0_91"
set PATH=%JAVA_HOME%\bin;%PATH%

cd %~dp0
start "server" "java" -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8455,suspend=n -jar -Dserver.port=8090 C:\sviluppo\~codeRepo\GitHubTest\dassi-rest\target\DassiRestServices-0.0.1-SNAPSHOT.jar
