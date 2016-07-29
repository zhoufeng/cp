
@echo off

g:
cd G:\workspace\commonworkspace\aliutil

call mvn deploy -X
echo end install aliutil
pause
cd G:\workspace\alicopydubbo\alicopydubbo\alicopydubbo-htmlfetch-provider

call mvn install

echo end install htmlfetch
pause