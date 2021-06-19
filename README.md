# RSS Feed Reader

Desktop app with a system tray icon that notifies you when
there are new items in your RSS feeds.

## Prerequisites

To build the project, you will need a [Java JDK](https://adoptopenjdk.net/) and [Maven](https://maven.apache.org/).

## Getting started


To build the project:

- Clone the source code
- Execute the `package` target with Maven
- Run the `RssFeedReader*.jar` file output in the `target/` directory.

For example:

```bash
git clone git@github.com:DevDungeon/RSS-Feed-Reader.git
cd RSS-Feed-Reader
mvn package
java -jar ./target/RssFeedReader-1.0-SNAPSHOT.jar  # Or whatever version it is
```



To do
-----

- Add the proper package and Main file, update pom.xml
- Configure log4j2.properties if needed
- Configure project license, add to pom.xml, add LICENSE.txt
- Update the README.md
- Update dependency versions in pom.xml
- Delete icons/images if they are not needed (console apps)

Contact
-------

Email or XMPP: NanoDano <nanodano@devdungeon.com>
