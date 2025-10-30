@echo off
setlocal

:: === Define temp directory ===
set TEMP_DIR=.\temp

:: Create temp directory if it doesn't exist
if not exist "%TEMP_DIR%" mkdir "%TEMP_DIR%"

echo ================================
echo Running ANTLR Lexer & Parser generation...
echo ================================

java -jar .\antlr-4.8-complete.jar -Dlanguage=Java -o "%TEMP_DIR%" Language.g4

echo.
echo ================================
echo Compiling Java files...
echo ================================

:: Compile all Java files including Code.java
javac -cp ".;antlr-4.8-complete.jar;%TEMP_DIR%" -d "%TEMP_DIR%" Main.java "%TEMP_DIR%\*.java"

echo.
echo ================================
echo Running the main program...
echo ================================

java -cp ".;antlr-4.8-complete.jar;%TEMP_DIR%" Main

echo.
echo ================================
echo Process Completed
echo ================================
pause
