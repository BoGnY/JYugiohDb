# JYugiohDb

## 1. What is JYugiohDb?
This application is a searchable database of all the Yu-Gi-Oh cards, developed in Java, where are shown all infos, cards image, all sets infos for each card, and its market value.

All informations are extracted from the [official Konami database](https://www.db.yugioh-card.com/yugiohdb "Official Konami database") (information and set list), while prices are extracted from [Yu-Gi-Oh Prices](https://yugiohprices.com "Yu-Gi-Oh Prices") site (using its [APIs functions](https://yugiohprices.docs.apiary.io "Yu-Gi-Oh Prices APIs functions")).

It is based on my personal YugiohDb application, developed in C#, which has not been publicly released.

## 2. License
JYugiohDb is released under the terms of [Creative Commons BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode "Creative Commons BY-NC-SA"). JYugiohDb is free to use and modify, if you give the appropriate credit, and can't be used for commercial purposes. It is free to redistribute your contributions under the same license as the original [Creative Commons BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode "Creative Commons BY-NC-SA").

## 3. Support
**[Wiki](https://github.com/BoGnY/JYugiohDB/wiki "Official wiki")** - The Wiki has information related to "How To", FAQ, feature requirements, etc.

**Search** - A good way for locating an answer to your question or finding more information about this application, is to search across this project website and/or the Internet via your favorite search engine, eg. [Google](https://www.google.com "Google search") or [Bing](https://www.bing.com "Bing search").

## 4. News
There are several ways to keep up to date with projects news. These include:

On **[issue tracker](https://github.com/BoGnY/JYugiohDB/issues "JYugiohDB Issue Tracker")** we send release announcements and important updates to users. Your Github account can also be used to report, monitor, and comment on issues relating to this project.

~**[Blog](https://www.bogny.it "BoGnY's blog")** is used to communicate announcements about new releases, topics relating to projects, etc. Users are encouraged to subscribe to the RSS feed to know when new posts are posted there.~ **NOT YET**

~**Twitter** is used to notify users about up-to-date details about what is happening with project development. Twitter users are encouraged to follow "@[??????](https://twitter.com "Twitter profile")".~ **NOT YET**

## 5. Versioning

Our release numbering convention follows the guidelines of [Semantic Versioning](https://semver.org "Semantic Versioning 2.0.0"). Given a version number **Major.Minor.Patch**, an optional **Pre-release** suffix, and a **Build metadata** suffix (eg. 2.4.5-rc.2+build.1):

* **Major** - Indicates a very large change in the core package. Rewrites or major milestones. API changes which are not backwards-compatible.
* **Minor** - Introduction of new features or significant changes in functionality, in a backwards-compatible manner.
* **Patch** - Bug fixes, maintenance and security releases.
* **Pre-release** - Optional, indicates a development release (_absence of optional suffix indicates a stable release_):
    * aN or alpha.N for alpha releases
    * bN or beta.N for beta releases
    * rcN or rc.N for release candidates
* **Build metadata** - Indicates the build number. Which will be ignored when determining version precedence. Two packages with same version, but different build metadata, are considered to be the same version.
