all: compile compileTest

compile:
	mkdir -p bin
	javac src/MySegmentTree.java -d bin

compileTest:
	mkdir -p bin
	javac -classpath /usr/share/java/junit4.jar:./bin testcase/TestMySegmentTree.java testcase/TestRunner.java -d bin

test:
	cd bin ; java -classpath .:/usr/share/java/junit4.jar TestRunner

run:
	cd bin ; java -classpath .:/usr/share/java/junit4.jar MySegmentTree

runCov:
	rm bin/*.exec 2> /dev/null || true
	cd bin ; java -javaagent:../lib/jacocoagent.jar -cp .:/usr/share/java/junit4.jar:/usr/share/java/mockito-core.jar TestRunner
 
calCov:
	cd bin ; java -jar ../lib/jacococli.jar report jacoco.exec --classfiles ../bin \
	--sourcefiles ../src --sourcefiles ../testcase --xml ../jacoco.xml --html reportDir
clean:
	-rm -r bin/*.class bin/*.exec jacoco.xml bin/reportDir 2> /dev/null || true
