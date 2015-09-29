#!/bin/bash
#Script qui compile et execute un projet JAVA avec en paramètre le nom du fichier contenant le main

#javac -sourcepath sources -d classes sources/Rationnel.java
#java -classpath classes Rationnel

#Argument $1 : Nom du fichier java contenant le main
if test $# -eq 1
	then
	javac -sourcepath sources -d classes sources/$1
	javaClassPath=$(echo $1|cut -f1 -d.)
	java -classpath classes $javaClassPath
#Argument $1 : dossier des sources, $2 : dossier des classes, $3 : Nom du fichier java contenant le main
elif test $# -eq 3
	then
	javaClassPath=$(echo $3|cut -f1 -d.)
	javac -sourcepath $1 -d $2 $1/$3
	java -classpath classes $javaClassPath
fi

#Exemple d'utilisation :
#./javaRun.sh Rationnel.java
# ou encore (en précisant les sources et classes):
#./javaRun.sh sources classes Rationnel.java
