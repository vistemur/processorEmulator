# pre setup
set -euo pipefail
cd `dirname ${BASH_SOURCE[0]}`

cp out/artifacts/processorEmulator_jar/processorEmulator.jar processor.jar
sed '/^$/d' program.txt > input.txt
java -jar processor.jar input.txt
rm processor.jar
rm input.txt
