#!/usr/bin/env bash

set -e

cd "$(dirname "$(readlink -f "$BASH_SOURCE")")/.."

github_changelog_generator BoGnY/JYugiohDb
