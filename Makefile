all: compile compileTest

compile:
	mkdir -p bin
	javac src/MySegmentTree.java -d bin

compileTest:
	mkdir -p bin
	javac -classpath /usr/share/java/junit4.jar src/MySegmentTree.java testcase/TestMySegmentTree.java testcase/TestRunner.java -d bin

test:
	cd bin ; java -classpath .:/usr/share/java/junit4.jar TestRunner

run:
	cd bin ; java -classpath .:/usr/share/java/junit4.jar MySegmentTree

clean:
	-rm bin/*.class

