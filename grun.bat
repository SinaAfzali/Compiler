@echo off
setlocal

:: === Define temp directory ===
set TEMP_DIR=.\temp

:: Create temp directory if it doesn't exist
if not exist "%TEMP_DIR%" mkdir "%TEMP_DIR%"

echo ================================
echo Checking prerequisites...
echo ================================

:: Check if ANTLR jar exists
if not exist ".\antlr-4.8-complete.jar" (
    echo ERROR: antlr-4.8-complete.jar not found! Download from https://www.antlr.org/download.html
    pause
    exit /b 1
)

echo OK: Prerequisites checked.
echo.

echo ================================
echo Running ANTLR generation...
echo ================================

java -jar .\antlr-4.8-complete.jar -Dlanguage=Java -visitor -listener -o "%TEMP_DIR%" Language.g4

if %ERRORLEVEL% neq 0 (
    echo ERROR: ANTLR generation failed!
    pause
    exit /b 1
)

echo Generated files in %TEMP_DIR%.
echo.

echo ================================
echo Compiling Java files...
echo ================================

:: Compile all Java files including generated ones and custom classes
javac -cp ".;.\antlr-4.8-complete.jar;%TEMP_DIR%" -d "%TEMP_DIR%" ^
    Main.java Symbol.java Scope.java LanguageVisitorImpl.java TokenExtractor.java SymbolTableBuilder.java ^
    "%TEMP_DIR%\*.java"

if %ERRORLEVEL% neq 0 (
    echo ERROR: Compilation failed! Check Java imports and syntax.
    pause
    exit /b 1
)

echo Compiled successfully.
echo.

echo ================================
echo Running the main program...
echo ================================

java -cp ".;.\antlr-4.8-complete.jar;%TEMP_DIR%" Main

echo.

echo ================================
echo Process Completed
echo ================================
pause