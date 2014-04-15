1. Checkout source

2. Do a clean build

./tools/apache-ant-1.9.3/bin/ant clean package

3. Run the server as
	java -jar ./target/build/dist/pubmatic-publisher-onboarding.jar

4. Whereever you have checked out the code, there is a test.xlsx file. 
   Test this service as

	curl -d "" -i "http://localhost:8080?fileName=GIVE FULL PATH TO YOUR test.xlsx"

    You should get json back for a section of onboarding

