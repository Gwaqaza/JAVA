find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java za.co.wethinkcode.pmahele.simulator.Simulator src/scenario.txt
