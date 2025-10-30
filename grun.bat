@echo off
REM === Compile and Run ANTLR Project ===
echo Running ANTLR Lexer & Parser generation...
java -jar .\antlr-4.8-complete.jar -Dlanguage=Java Language.g4

echo.
echo Compiling Java files...
javac -cp ".;antlr-4.8-complete.jar" *.java

echo.
echo Running the main program...
java -cp ".;antlr-4.8-complete.jar" Code

echo.
echo === Process Completed ===
pause
