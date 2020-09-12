Scenarios are in
test_cases.pdf
test_cases.docx

In current version second test should fail

To compile project and run tests:
mvn clean install -Dtestng.testname="Regression" -Dsurefire.suiteXmlFiles="./testng.xml" -Dmaven.test.failure.ignore=true

Output would be in:
target\surefire-reports\emailable-report.html

Screenshots are in
screenshots

Copy of one report is in:
emailable-report.html
