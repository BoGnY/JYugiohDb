# Contributing

Hi there! We're thrilled that you'd like to contribute to JYugiohDB. Your help is essential for keeping it great.

JYugiohDB is an open source project supported by the efforts of an entire community and built one contribution at a time by users like you. We'd love for you to get involved. Whatever your level of skill or however much time you can give, your contribution is greatly appreciated. There are many ways to contribute, from writing tutorials or blog posts, improving the documentation, submitting bug reports and feature requests, helping other users by commenting on issues, or writing code which can be incorporated into JYugiohDB itself.

The most important things that you need to do first of all are to read the [docs/CODE_OF_CONDUCT.md](/docs/CODE_OF_CONDUCT.md "Code of conduct"), to read the [docs/CODING-GUIDELINES.md](/docs/CODING-GUIDELINES.md "Coding guidelines") and to respect the [git style guide](https://github.com/agis/git-style-guide "Git style guide").

Following these guidelines helps to communicate that you respect the time of the developers managing and developing this open source project. In return, they should reciprocate that respect in addressing your issue, assessing changes, and helping you finalize your pull requests.

## Looking for support?

We'd love to help. Check out [the support guidelines](/README.md#3-support "Support guidelines").

## How to report a bug

Think you found a bug? Please check [the list of open issues](/issues "Open issues") to see if your bug has already been reported. If it hasn't please [submit a new issue](/issues/new "Submit issue").

Not familiar with git? Start by looking at [Github's collaborating pages](https://help.github.com/categories/collaborating/ "Github's collaborating pages").

Here are a few tips for writing *great* bug reports:

* **DO NOT open** an issue on Github for your general questions
* **DO NOT comment** on a pull request unless you are involved in the testing of such or have something meaningful to contribute.
* Use a correct GitHub label, more info [here](#labels "Labels info")
* Describe the specific problem (e.g., "widget doesn't turn clockwise", please **DO NOT USE** a generic "getting an error") by follow our [docs/ISSUE_TEMPLATE.md](/docs/ISSUE_TEMPLATE.md "New issue guidelines")
* Include the steps to reproduce the bug, what you expected to happen, and what happened instead
* Check that you are using the latest version of the project and its dependencies
* Include what version of the project your using, as well as any relevant dependencies
* Only include one bug per issue. If you have discovered two bugs, please file two issues
* Include screenshots or screencasts whenever possible
* Even if you don't know how to fix the bug, including a failing test may help others track it down

**If you find a security vulnerability, do not open an issue. Please email [admin@bogny.it](mailto:admin@bogny.it) instead.**

## How to suggest a feature or enhancement

If you find yourself wishing for a feature that doesn't exist in JYugiohDB, you are probably not alone. There are bound to be others out there with similar needs. Many of the features that JYugiohDB has today have been added because our users saw the need.

Feature requests are welcome. But take a moment to find out whether your idea fits with the scope and goals of the project. It's up to you to make a strong case to convince the project's developers of the merits of this feature. Please provide as much detail and context as possible, including describing the problem you're trying to solve.

[Open an issue](/issues/new "Submit issue") which describes the feature you would like to see, why you want it, how it should work, etc.

## Your first contribution

We'd love for you to contribute to the project. Unsure where to begin contributing to JYugiohDb? You can start by looking through these "kind/proposal" and "kind/question" issues:

* [kind/proposal](/issues?q=is%3Aopen+is%3Aissue+label%3Akind%2Fproposal) - issues that contains a new proposal to be evaluated
* [kind/question](/issues?q=is%3Aopen+is%3Aissue+label%3Akind%2Fquestion) - issues which contains a simple question

*p.s. Feel free to ask for help; everyone is a beginner at first* :smiley_cat:

## How to propose changes

Here's a few general guidelines for proposing changes:

* If you are changing any user-facing functionality, please be sure to update the documentation
* For each new files you have created, add license description on every headers file, based on [docs/LICENSE-CODE.md](/docs/LICENSE-CODE.md "License code") file and paste this:
```java
/**
 *
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
 *
 * JYugiohDb (c) 2017-2018 by BoGnY <admin@bogny.it> (https://www.bogny.it)
 * and all other authors and contributors, see AUTHORS.md for a full list
 * https://github.com/BoGnY/JYugiohDB/blob/master/AUTHORS.md
 *
 *
 * This work is licensed under a Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 *
 * To view a copy of this license, visit
 * https://creativecommons.org/licenses/by-nc-sa/4.0/
 *
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute and/or sublicense
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
```

* If you add some lines of code, please follow our [coding guidelines](/docs/CODING-GUIDELINES.md "Coding guidelines")
* If you are adding a new behavior or changing an existing behavior, please be sure to update the corresponding test(s)
* Each pull request should implement **one** feature or bugfix. If you want to add or fix more than one thing, submit more than one pull request
* Do not commit changes to files that are irrelevant to your feature or bugfix
* Don't bump the version number in your pull request (it will be bumped prior to release)
* Write a [good commit message](http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html "Write good commit")

At a high level, the process for [proposing changes](https://guides.github.com/introduction/flow/ "Proposing changes") is:

1. Configure and install the [dependencies](#dependencies "Dependencies list")
2. [Fork](/fork) and clone the project
3. Set Git to preserve current EOL (more info [here](https://help.github.com/articles/dealing-with-line-endings/ "Dealing with line endings")):
    - for MacOS and Linux user: `git config core.autocrlf input` (respect current EOL) and with `git config core.safecrlf true` (fail commit when EOL are changed)
    - for Windows user: `git config core.autocrlf true` (respect current EOL) and with `git config core.safecrlf true` (fail commit when EOL are changed)
4. Checkout on _**dev**_ branch: `git checkout dev`
5. Create a descriptively named feature branch: `git checkout -b feature/new-feature-name` or `git checkout -b bugfix/issue-99` (where **issue-99** is the related [#ISSUE_NUMBER](/issues))
6. Make your change, test it and add documentation, so make sure the test still pass
7. Run test again, and run another test
8. Push to your fork and [submit a pull request](/compare "Submit Pull Request") describing your change that follow our [pull request template](/docs/PULL_REQUEST_TEMPLATE.md "Pull Request guidelines")
9. Pat your self on the back and wait for your pull request to be reviewed and merged

**Interesting in submitting your first Pull Request?** It's easy! You can learn how from this *free* series [How to Contribute to an Open Source Project on GitHub](https://egghead.io/series/how-to-contribute-to-an-open-source-project-on-github "How to Contribute to an Open Source Project on GitHub")

## Labels

If we open/look an issue/PR, we must add a `kind/*`, an `area/*` and a `status/*` _(based on [Traefik](https://github.com/containous/traefik "Traefik") project and its bots)_.

### Contributor

* `contributor/need-more-information`: we need more information from the contributor in order to analyze a problem.
* `contributor/waiting-for-feedback`: we need the contributor to give us feedback.
* `contributor/waiting-for-corrections`: we need the contributor to take actions in order to move forward with a PR. **(only for PR)** _[bot, humans]_
* `contributor/needs-resolve-conflicts`: use it only when there is some conflicts (and an automatic rebase is not possible). **(only for PR)** _[bot, humans]_

### Kind

* `kind/enhancement`: a new or improved feature.
* `kind/question`: It's a question. **(only for issue)**
* `kind/proposal`: proposal PR/issues need a public debate.
  * _Proposal issues_ are design proposal that need to be refined with multiple contributors.
  * _Proposal PRs_ are technical prototypes that need to be refined with multiple contributors.
* `kind/bug/possible`: if we need to analyze to understand if it's a bug or not. **(only for issues)**
* `kind/bug/confirmed`: we are sure, it's a bug. **(only for issues)**
* `kind/bug/fix`: it's a bug fix. **(only for PR)**

### Resolution

* `resolution/duplicate`: it's a duplicate issue/PR.
* `resolution/declined`: Rule #1 of open-source: no is temporary, yes is forever.
* `resolution/WIP`: Work In Progress. **(only for PR)**

### Platform

* `platform/linux`: Linux related.
* `platform/macos`: MacOS related.
* `platform/windows`: Windows related.

### Area

* `area/core`: related to application core.
* `area/doc`: regards improving/adding documentation.
* `area/log`: related to logs system.
* `area/script`: related to CI, Gradle or other scripts.
* `area/sql`: related to SQLite or JDBC.
* `area/ui`: UI related.

### Priority

* `priority/P0`: needs hot fix. **(only for issue)**
* `priority/P1`: need to be fixed in next release. **(only for issue)**
* `priority/P2`: need to be fixed in the future. **(only for issue)**
* `priority/P3`: maybe. **(only for issue)**

### Status - Workflow

The `status/*` labels represent the desired state in the workflow.

* `status/0-needs-triage`: all new issue or PR have this status. _[bot only]_
* `status/1-needs-design-review`: need a design review. **(only for PR)**
* `status/2-needs-review`: need a code/documentation review. **(only for PR)**
* `status/3-needs-merge`: ready to merge. **(only for PR)**
* `status/4-merge-in-progress`: merge in progress. _[bot only]_

## Dependencies

To successfully develop the application, you will need the following installed:

* Java Development Kit version 8 >= update 40
* JavaFX version = 8.0 (requires Java)
* Gradle version >= 4.2 (requires Java)
* SpotBugs version >= 3.1 (requires Java)
* Git shell version >= 2 (for Windows use [Git for Windows](https://gitforwindows.org/ "Git for Windows"))
* Bash shell version >= 4.4 (for Windows is included on Git for Windows)
* Ruby version = 2.4.+
* RubyGems >= 2.7.4 (requires Ruby)
* github_changelog_generator (instructions [here](https://github.com/skywinder/github-changelog-generator "github_changelog_generator")) >= 1.14.+ (requires Ruby and RubyGems)

## Code of conduct

This project is governed by the [Contributor Covenant Code of Conduct](/docs/CODE_OF_CONDUCT.md "Code of conduct"). By participating, you are expected to uphold this code!

## Additional Resources

* [GitHub Help](https://help.github.com "GitHub Help")
* [Contributing to Open Source on GitHub](https://guides.github.com/activities/contributing-to-open-source/ "Contributing to Open Source on GitHub")
* [Using Pull Requests](https://help.github.com/articles/using-pull-requests/ "Using Pull Requests")
