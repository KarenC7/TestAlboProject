#****************************************************************************************#
#*                                                                                      *#
#*  DESCRIPCION          : EJECUCIÓN DE APLICAION TEST ALBO                             *#
#*                                                                                      *#
#****************************************************************************************#

#!/bin/bash

FILE_JAR="test-0.0.1-SNAPSHOT.jar"

Java -Dserver.port=80 -jar $FILE_JAR

exit